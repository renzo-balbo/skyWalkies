package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.AvatarService;
import com.mindhub.skywalkies.Service.BillService;
import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.Service.ProductService;
import com.mindhub.skywalkies.dtos.AvatarDTO;
import com.mindhub.skywalkies.dtos.BillDTO;
import com.mindhub.skywalkies.dtos.SelectedProductDTO;
import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Client_order;
import com.mindhub.skywalkies.models.Product;
import com.mindhub.skywalkies.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BillRepository billRepository;



    @GetMapping("/bills")
    public List<BillDTO> getBills(){
    return billService.getAllBills().stream().map(BillDTO::new).collect(Collectors.toList());
    }

//    @PostMapping("/bills")
//    public ResponseEntity <Object> addBills (@RequestBody Set<SelectedProductDTO> selectedProductDTOSet, Authentication authentication){ selectedProductDTOSet
//
//        Client client = clientService.findClientByEmail(authentication.getName());
//        AtomicReference<Double> total = new AtomicReference<>(0.0); total: "10000.0"
//        Bill bill = new Bill(LocalDateTime.now(),250.00,total.get()*1.21,client);
//        List<Product>productList = new ArrayList<>(); size = 5
//        selectedProductDTOset.forEach(product ->{ selectedProductDTOSet: size = 2
//            Product product1 = productService.getProductById(product.getId());
//            new Client_order(product.getquantity(), product1, bill);
//            for (int i = 0; i < product.getQuantity();i++){
//                productList.add(product1); size = 5
//                Product selectedProduct = productService.getProductById(product1.getId());
//                selectedProduct.setStock(selectedProduct.getStock() - 1);
//                    double productPrice = selectedProduct.getPrice();
//                    total.updateAndGet(v -> new Double((double) (v + productPrice))); total: "10000.0"
//                   productService.saveProduct(selectedProduct); productService: ProductServiceImp@11001
//            }
//        });
//        productService.saveProduct();
//        billRepository.save(bill)
//
//
//          return new ResponseEntity<>("productList", HttpStatus.CREATED);
//    }
}
