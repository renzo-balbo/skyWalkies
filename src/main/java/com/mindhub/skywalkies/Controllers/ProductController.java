package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.AvatarService;
import com.mindhub.skywalkies.Service.BillService;
import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.Service.ProductService;
import com.mindhub.skywalkies.dtos.AddProductDTO;
import com.mindhub.skywalkies.dtos.AvatarDTO;
import com.mindhub.skywalkies.dtos.ProductDTO;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Product;
import org.apache.maven.artifact.repository.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
        return productService.getAllProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }
    @PostMapping("/products/add")
    public ResponseEntity<Object> addProduct(@RequestBody AddProductDTO AddProductDTO){
//        Product productName = productService.findByName(AddProductDTO.getName());
        if (AddProductDTO.getSizes().isEmpty() || AddProductDTO.getPrice() < 0 || AddProductDTO.getShoeColors().isEmpty() || AddProductDTO.getType().isEmpty() || AddProductDTO.getName().isEmpty()){
            return new ResponseEntity<>("Please fill all the fields", HttpStatus.FORBIDDEN);
        }
        else {
            Product productPrueba1 = new Product(AddProductDTO.getName(), AddProductDTO.getShoeColors(), AddProductDTO.getType(), AddProductDTO.getActive(),AddProductDTO.getSizes(), AddProductDTO.getStock(), AddProductDTO.getPrice());
            productService.saveProduct(productPrueba1);
            return new ResponseEntity<>("Product loaded successfully", HttpStatus.CREATED);
        }
    }


}
