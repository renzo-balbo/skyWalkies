package com.mindhub.skywalkies.Service.implementations;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mindhub.skywalkies.Service.PDFService;
import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client_order;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PDFServiceImplement implements PDFService {
    private static Font titleFont = new Font(Font.FontFamily.HELVETICA, 18,
            Font.BOLD);
    private static Font headerFont = new Font(Font.FontFamily.HELVETICA, 14,
            Font.BOLD, BaseColor.WHITE);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 12,
            Font.NORMAL);

    @Override
    public void generatePDF(HttpServletResponse response, List<Client_order> client_orders, Bill bill) {
        try {
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            document.setMargins(2,2,2,2);



            /*TITLES*/

            Paragraph title = new Paragraph("Skywalkies - Resumen de cuenta", titleFont);
            title.setSpacingAfter(3);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingBefore(-2);

            Paragraph subTitle = new Paragraph("Factura número: " + bill.getId(), subFont);
            subTitle.setAlignment(Element.ALIGN_CENTER);
            subTitle.setSpacingAfter(1);

            Paragraph date = new Paragraph("Fecha de emisión: " + LocalDate.now(), subFont);
            date.setSpacingAfter(6);
            date.setAlignment(Element.ALIGN_CENTER);




            /*LOGO*/

            Image img = Image.getInstance("./src/main/resources/static/public/img/logo-pdf.png");
            img.scaleAbsoluteWidth(100);
            img.scaleAbsoluteHeight(100);
            img.setAlignment(Element.ALIGN_CENTER);

            /*HEADERS*/

            PdfPTable pdfPTable = new PdfPTable(4);
            PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Descripcion", headerFont));
            PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Fecha", headerFont));
            PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Tipo", headerFont));
            PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Monto", headerFont));
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

            client_orders.forEach(client_order -> {

                //PdfPCell pdfPCell5 = new PdfPCell(new Paragraph(bill.getDescription(), subFont));
                PdfPCell pdfPCell6 = new PdfPCell(new Paragraph(bill.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), subFont));
                PdfPCell pdfPCell7 = new PdfPCell(new Paragraph(String.valueOf(bill.getClient()), subFont));
                PdfPCell pdfPCell8 = new PdfPCell(new Paragraph("$" + String.valueOf(bill.getSubTotal()), subFont));
                //pdfPCell5.setBorder(0);
                pdfPCell6.setBorder(0);
                pdfPCell7.setBorder(0);
                pdfPCell8.setBorder(0);

                //pdfPTable.addCell(pdfPCell5);
                pdfPTable.addCell(pdfPCell6);
                pdfPTable.addCell(pdfPCell7);
                pdfPTable.addCell(pdfPCell8);
            });

            document.add(img);
            document.add(title);
            document.add(subTitle);
            document.add(date);
            document.add(pdfPTable);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
