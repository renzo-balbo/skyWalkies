package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.AvatarService;
import com.mindhub.skywalkies.Service.ProductService;
import com.mindhub.skywalkies.dtos.AvatarDTO;
import com.mindhub.skywalkies.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
        return productService.getAllProducts().stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
    }
}
