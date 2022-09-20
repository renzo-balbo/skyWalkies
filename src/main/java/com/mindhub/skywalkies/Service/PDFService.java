package com.mindhub.skywalkies.Service;

import com.itextpdf.text.DocumentException;
import com.mindhub.skywalkies.dtos.PDFParamsDTO;
import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client_order;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface PDFService {
    public void generatePDF(HttpServletResponse response, List<Client_order> client_orders, Bill bill);
    //hola
}
