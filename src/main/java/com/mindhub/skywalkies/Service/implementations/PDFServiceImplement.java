package com.mindhub.skywalkies.Service.implementations;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mindhub.skywalkies.Service.PDFService;
import com.mindhub.skywalkies.Service.ProductService;
import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client_order;
import com.mindhub.skywalkies.models.Ordered_product;
import com.mindhub.skywalkies.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class PDFServiceImplement implements PDFService {
    private static Font titleFont = new Font(Font.FontFamily.HELVETICA, 18,
            Font.BOLD);
    private static Font headerFont = new Font(Font.FontFamily.HELVETICA, 14,
            Font.BOLD, BaseColor.WHITE);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 12,
            Font.NORMAL);

    @Autowired
    private ProductService productService;
    @Override
    public void generatePDF(HttpServletResponse response,  Bill bill) {
        try {
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            document.setMargins(2,2,2,2);

           Set<Client_order> client_orders= bill.getClient_orders();




            /*TITLES*/

            Paragraph title = new Paragraph("Skywalkies - payment summary", titleFont);
            title.setSpacingAfter(3);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingBefore(-2);

            Paragraph subTitle = new Paragraph("Bill number: " + bill.getId(), subFont);
            subTitle.setAlignment(Element.ALIGN_CENTER);
            subTitle.setSpacingAfter(1);

            Paragraph date = new Paragraph("Date: " + LocalDate.now(), subFont);
            date.setSpacingAfter(6);
            date.setAlignment(Element.ALIGN_CENTER);




            /*LOGO*/

            Image img = Image.getInstance("./src/main/resources/static/public/img/logo-pdf.png");
            img.scaleAbsoluteWidth(100);
            img.scaleAbsoluteHeight(100);
            img.setAlignment(Element.ALIGN_CENTER);

            /*HEADERS*/

            PdfPTable pdfPTable = new PdfPTable(4);
            PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Name", headerFont));
            PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Quantity", headerFont));
            PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Price", headerFont));
            PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Total", headerFont));
            pdfPCell1.setBackgroundColor(new BaseColor(220, 7, 253));
            pdfPCell2.setBackgroundColor(new BaseColor(220, 7, 253));
            pdfPCell3.setBackgroundColor(new BaseColor(220, 7, 253));
            pdfPCell4.setBackgroundColor(new BaseColor(220, 7, 253));
            pdfPCell1.setBorder(0);
            pdfPCell2.setBorder(0);
            pdfPCell3.setBorder(0);
            pdfPCell4.setBorder(0);
            pdfPTable.addCell(pdfPCell1);
            pdfPTable.addCell(pdfPCell2);
            pdfPTable.addCell(pdfPCell3);
            pdfPTable.addCell(pdfPCell4);

            /*TABLE OF TRANSACTIONS*/
            if(bill.getClient_orders()!=null){
                bill.getClient_orders().forEach(client_order -> {
                    client_order.getOrdered_products().forEach(ordered_product -> {
                                Product product = ordered_product.getProduct();



                PdfPCell pdfPCell5 = new PdfPCell(new Paragraph(String.valueOf(product.getName()), subFont));
                PdfPCell pdfPCell6 = new PdfPCell(new Paragraph(String.valueOf(ordered_product.getQuantity()) , subFont));
                PdfPCell pdfPCell7 = new PdfPCell(new Paragraph("$" + String.valueOf(product.getPrice()), subFont));
                PdfPCell pdfPCell8 = new PdfPCell(new Paragraph("$" + String.valueOf(product.getPrice()*ordered_product.getQuantity()), subFont));
                pdfPCell5.setBorder(0);
                pdfPCell6.setBorder(0);
                pdfPCell7.setBorder(0);
                pdfPCell8.setBorder(0);

                pdfPTable.addCell(pdfPCell5);
                pdfPTable.addCell(pdfPCell6);
                pdfPTable.addCell(pdfPCell7);
                pdfPTable.addCell(pdfPCell8);
            });});};
               Paragraph total = new Paragraph("Total:", titleFont);
               Paragraph footer = new Paragraph("$" +String.valueOf(bill.getTotal()), titleFont);

            document.add(img);
            document.add(title);
            document.add(subTitle);
            document.add(date);
            document.add(pdfPTable);
            document.add(total);
            document.add(footer);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
