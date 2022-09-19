package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.*;
import com.mindhub.skywalkies.dtos.AddProductDTO;
import com.mindhub.skywalkies.dtos.NewProductDTO;
import com.mindhub.skywalkies.dtos.ProductDTO;
import com.mindhub.skywalkies.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        if (productDTO.getName().isEmpty() || productDTO.getType().isEmpty() || productDTO.getShoeColors().isEmpty() || productDTO.getSizes().isEmpty() || productDTO.getStock() < 0 || productDTO.getPrice() < 0) {
            return new ResponseEntity<>("no jaja", HttpStatus.FORBIDDEN);
        } else {
            product.setName(productDTO.getName());
            product.setType(productDTO.getType());
            product.setShoeColors(productDTO.getShoeColors());
            product.setSize(productDTO.getSizes());
            product.setStock(productDTO.getStock());
            product.setPrice(productDTO.getPrice());

            productService.saveProduct(product);
            return new ResponseEntity<>("si jejox", HttpStatus.ACCEPTED);
        }
    }

    @Transactional
    @PostMapping("/products/addCart")
    public ResponseEntity<Object> addProduct(@RequestBody AddProductDTO addProductDTO, Authentication authentication) {
        Client client = clientService.findClientByEmail(authentication.getName());
        Product product = productService.getProductById(addProductDTO.getId());

        if (addProductDTO.getProductName().isEmpty() || addProductDTO.getQuantity() < product.getStock() || !addProductDTO.getSize().equals(product.getSize())) {
            return new ResponseEntity<>("no jaja", HttpStatus.FORBIDDEN);
        }


        Bill bill = new Bill(LocalDateTime.now(), false, 0);
        Client_order client_order = new Client_order(bill);
        Ordered_product ordered_product = new Ordered_product(client_order, addProductDTO.getQuantity(), addProductDTO.getSize(), addProductDTO.getQuantity() * product.getPrice(), product);
        billService.saveBill(bill);
        client_orderService.saveClientOrders(client_order);
        ordered_productService.saveOrderProduct(ordered_product);

        return new ResponseEntity<>("claro que si crack", HttpStatus.CREATED);
    }


}
// if (client.getBills().stream().anyMatch(bill -> !bill.isPayed())){
//   Bill bill = client.getBills().stream().filter(bill1 -> !bill1.isPayed()).reduce();
//}