package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.*;
import com.mindhub.skywalkies.dtos.AddProductDTO;
import com.mindhub.skywalkies.dtos.NewProductDTO;
import com.mindhub.skywalkies.dtos.ProductDTO;
import com.mindhub.skywalkies.models.*;
import com.mindhub.skywalkies.repositories.Client_OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.mindhub.skywalkies.Utilities.BillUtilities.randomNumberTicket;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private BillService billService;
    @Autowired
    private Client_orderService client_orderService;

    @Autowired
    private Ordered_productService ordered_productService;

    @Autowired
    private Client_OrderRepository client_orderRepository;

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return new ProductDTO(productService.getProductById(id));
    }

    @PostMapping("/products/add")
    public ResponseEntity<Object> newProduct(@RequestBody NewProductDTO NewProductDTO, Authentication authentication) {
        Client client = clientService.findClientByEmail(authentication.getName());
//        Product productName = productService.findByName(AddProductDTO.getName());
        if (NewProductDTO.getSizes().isEmpty() || NewProductDTO.getPrice() < 0 || NewProductDTO.getShoeColors().isEmpty() || NewProductDTO.getType().isEmpty() || NewProductDTO.getName().isEmpty()) {
            return new ResponseEntity<>("Please fill all the fields", HttpStatus.FORBIDDEN);
        } else {
            Product productPrueba1 = new Product(NewProductDTO.getName(), NewProductDTO.getShoeColors(), NewProductDTO.getType(), NewProductDTO.getActive(), NewProductDTO.getSizes(), NewProductDTO.getStock(), NewProductDTO.getPrice());
            productService.saveProduct(productPrueba1);
            return new ResponseEntity<>("Product loaded successfully", HttpStatus.CREATED);
        }
    }

    @PatchMapping("/products/edit")
    public ResponseEntity<Object> editProduct(@RequestBody ProductDTO productDTO, Authentication authentication) {
        Client client = clientService.findClientByEmail(authentication.getName());
        Product product = productService.getProductById(productDTO.getId());
        if (!client.getEmail().contains("@skywalkies")){
            return new ResponseEntity<>("Your not allowed to edit objects", HttpStatus.METHOD_NOT_ALLOWED);
        }
        if (productDTO.getName().isEmpty() || productDTO.getType().isEmpty() || productDTO.getShoeColors().isEmpty() || productDTO.getSizes().isEmpty() || productDTO.getStock() < 0 || productDTO.getPrice() < 0) {
            return new ResponseEntity<>("Please complete all fields.", HttpStatus.FORBIDDEN);
        } else {
            product.setName(productDTO.getName());
            product.setType(productDTO.getType());
            product.setShoeColors(productDTO.getShoeColors());
            product.setSize(productDTO.getSizes());
            product.setStock(productDTO.getStock());
            product.setPrice(productDTO.getPrice());
            productService.saveProduct(product);
            return new ResponseEntity<>("Product edited successfully", HttpStatus.ACCEPTED);
        }
    }

    @Transactional
    @PostMapping("/products/addProduct")
    public ResponseEntity<Object> addProduct(@RequestBody Set<AddProductDTO> addProductDTO, Authentication authentication) {
        Client client = clientService.findClientByEmail(authentication.getName());
        Bill bill;
        List<Product> productActive1 = productService.getAllProducts().stream().filter(product -> product.isActive()).collect(Collectors.toList());
        if (!clientService.getAllClients().contains(client)){
            return new ResponseEntity<>("Please first Login", HttpStatus.FORBIDDEN);
        }
        if (!client.isVerificated()){
            return new ResponseEntity<>("Please first verified", HttpStatus.FORBIDDEN);
        }
        if (!addProductDTO.contains(productActive1)){
            return new ResponseEntity<>("That product no exist", HttpStatus.FORBIDDEN);
        }
        if (client.getBills().stream().anyMatch(billToCheck -> !billToCheck.isPayed())){
            bill = client.getBills().stream().filter(bill1 -> !bill1.isPayed()).findFirst().orElse(null);
        } else {
            bill = new Bill(LocalDateTime.now(),false,0);
        }
        Client_order client_order = new Client_order(bill);
        bill.addClient_order(client_order);
        List<Product> productActive = new ArrayList<>();
        addProductDTO.forEach(product ->{
            Product product1 = productService.getProductById(product.getId());
            Ordered_product ordered_product = new Ordered_product(client_order, product.getQuantity(), product.getSize(), product1.getPrice(), product1);
            for (int i = 0; i < product.getQuantity(); i++){
                productActive.add(product1);
                productService.saveProduct(product1);
                ordered_productService.saveOrderProduct(ordered_product);
                bill.setSubTotal(bill.getSubTotal()+product1.getPrice());
            }
        });
        int ticketNumber = randomNumberTicket(1, 999999999);
        bill.setTicketNumber(ticketNumber);
        bill.addTicketNumber(ticketNumber);
        billService.saveBill(bill);
        client_orderService.saveClientOrders(client_order);
        client.addBill(bill);
        clientService.saveClient(client);
        return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
    }

    @PatchMapping("/products/delete/{id}")
   public ResponseEntity<Object> deleteProducts(@PathVariable long id, Authentication authentication){
        Client client = clientService.findClientByEmail(authentication.getName());
        Product product = productService.getProductById(id);
        product.setDeleted(false);
        productService.saveProduct(product);
        return new ResponseEntity<>("products was deleted", HttpStatus.FORBIDDEN);
   }



    @Transactional
    @PatchMapping("/bill/empty")
    public ResponseEntity<Object> emptyBill(@RequestParam long billId, Authentication authentication){
        Client client = clientService.findClientByEmail(authentication.getName());
        Bill bill = client.getBills().stream().filter(bill1 -> bill1.getId()==billId).findFirst().orElse(null);
        if(bill.getClient_orders()!=null){
        bill.getClient_orders().forEach(client_order -> {
            client_order.getOrdered_products().forEach(ordered_product -> {
                Product productToRestore = ordered_product.getProduct();
                productToRestore.setStock(productToRestore.getStock()+ordered_product.getQuantity());
                productService.saveProduct(productToRestore);
            });
            client_order.setBillId(null);
            client_orderService.saveClientOrders(client_order);
        });
        }
        bill.setClient_orders(null);
        bill.setPayed(false);
        bill.setClient(client);
        bill.setDate(LocalDateTime.now());
        bill.setSubTotal(0);
        bill.setIva(0);
        bill.setTicketNumber(bill.getTicketNumber());
        bill.setTotal(0);
        billService.saveBill(bill);
        return new ResponseEntity<>("Cart successfully empty!", HttpStatus.CREATED);
    }

    @Transactional
    @PatchMapping("/ordered_product/remove")
    public ResponseEntity<Object> removeItemFromBill (@RequestParam long orderedProductId, long billId,Authentication authentication){
        Client client = clientService.findClientByEmail(authentication.getName());
        Ordered_product ordered_product = ordered_productService.getProdutById(orderedProductId);
        Bill bill = billService.getBillByid(billId);
        Client_order client_order = bill.getClient_orders().stream().filter(client_order1 -> client_order1.getOrdered_products().contains(ordered_product)).findFirst().orElse(null);

        Product productToRestore = ordered_product.getProduct();
        productToRestore.setStock(productToRestore.getStock()+ordered_product.getQuantity());
        productService.saveProduct(productToRestore);
        client_order.setOrdered_products(client_order.getOrdered_products().stream().filter(ordered_product1 -> ordered_product1 != ordered_product).collect(Collectors.toSet()));
        client_orderService.saveClientOrders(client_order);
        billService.saveBill(bill);

        return  new ResponseEntity<>("Item removed successfully!", HttpStatus.CREATED);
    }

}
