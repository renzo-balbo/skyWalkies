package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.BillService;
import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.Service.Client_orderService;
import com.mindhub.skywalkies.Service.ProductService;
import com.mindhub.skywalkies.dtos.BillDTO;
import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Product;
import com.mindhub.skywalkies.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;
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
    @Autowired
    private Client_orderService client_orderService;

    @GetMapping("/bills")
    public List<BillDTO> getBills() {
        return billService.getAllBills().stream().map(BillDTO::new).collect(Collectors.toList());
    }
    @GetMapping("/bills/{id}")
    public BillDTO getbill(@PathVariable long id) {
        return new BillDTO(billService.getBillByid(id));
    }
    @PatchMapping("/bills/payment")
    public ResponseEntity<Object> payment(@RequestParam long idBill){
        Bill bill = billService.getBillByid(idBill);
        bill.setPayed(true);
        Bill bill2 = new Bill(LocalDateTime.now(),false,0);
        billService.saveBill(bill);
        billService.saveBill(bill2);
        return new ResponseEntity<>("Payed successfully!", HttpStatus.CREATED);
    }

     //   Bill bill1 = new Bill(client,LocalDateTime.now(), true, getIvaTocaacamaster(bill.getSubTotal(), 1.21), bill.getIva()+ bill.getSubTotal(), bill.getTicketNumber());

    public double getIvaTocaacamaster(double subtotal, double porcentaje){
        return subtotal *  porcentaje / 100;
    }

}