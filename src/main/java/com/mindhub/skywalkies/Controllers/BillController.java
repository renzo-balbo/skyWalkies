package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.BillService;
import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.Service.ProductService;
import com.mindhub.skywalkies.dtos.BillDTO;
import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.repositories.BillRepository;
import org.hibernate.engine.profile.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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
    public List<BillDTO> getBills() {
        return billService.getAllBills().stream().map(BillDTO::new).collect(Collectors.toList());
    }
    @GetMapping("/bills/{id}")
    public BillDTO getbill(@PathVariable long id) {
        return new BillDTO(billService.getBillByid(id));
    }
    @Transactional
    @PostMapping("/bills/payment")
    public ResponseEntity<Object> payment(@RequestParam String cardHolder, @RequestParam String thruDate, @RequestParam String cardNumber, @RequestParam int cvv, @RequestParam  Integer numberTicket ,Authentication authentication){
        Client client = clientService.findClientByEmail(authentication.getName());
        Bill bill = billService.findByTicketNumber(numberTicket);
        if (cardHolder.isEmpty() || thruDate.isEmpty() || cardNumber.isEmpty() || cvv <= 99 || numberTicket<=0){
            return new ResponseEntity<>("Please complete all the fields", HttpStatus.FORBIDDEN);
        }else {
            try{
                bill.setPayed(true);
                billService.saveBill(bill);
                return new ResponseEntity<>("Payment completed", HttpStatus.CREATED);
            } catch (Exception e )
            {return new ResponseEntity<>("anashe",HttpStatus.FORBIDDEN);}

        }

     //   Bill bill1 = new Bill(client,LocalDateTime.now(), true, getIvaTocaacamaster(bill.getSubTotal(), 1.21), bill.getIva()+ bill.getSubTotal(), bill.getTicketNumber());


    }

    public double getIvaTocaacamaster(double subtotal, double porcentaje){
        return subtotal *  porcentaje / 100;
    }

}