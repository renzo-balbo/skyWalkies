package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.AvatarService;
import com.mindhub.skywalkies.Service.BillService;
import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.Service.ProductService;
import com.mindhub.skywalkies.dtos.AvatarDTO;
import com.mindhub.skywalkies.dtos.BillDTO;
import com.mindhub.skywalkies.dtos.Ordered_productDTO;
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
import org.springframework.transaction.annotation.Transactional;
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

}
