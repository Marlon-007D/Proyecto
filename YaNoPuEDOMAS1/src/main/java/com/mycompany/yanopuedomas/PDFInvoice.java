/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.yanopuedomas;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import javax.swing.JOptionPane;
import com.itextpdf.layout.Document;

/**
 *
 * @author Demera
 */
public class PDFInvoice implements InvoiceGeneration {
    
    @Override
    public void generateInvoicePDF(String name, String id, String address, String phone, String email, 
                                   String expirationDate, String cardName, String cardNumber, String cvv) {
        try {
            String folderPath = "Facturas/";
            java.io.File folder = new java.io.File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String fileName = folderPath + "factura_" + name + ".pdf";
            PdfWriter writer = new PdfWriter(fileName);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph("Factura de Pago"));
            document.add(new Paragraph("Nombre: " + name));
            document.add(new Paragraph("Cédula: " + id));
            document.add(new Paragraph("Dirección: " + address));
            document.add(new Paragraph("Teléfono: " + phone));
            document.add(new Paragraph("Correo electrónico: " + email));
            document.add(new Paragraph("Fecha de expiración: " + expirationDate));
            document.add(new Paragraph("Nombre del titular de la tarjeta: " + cardName));
            document.add(new Paragraph("Número de tarjeta: " + cardNumber));
            document.add(new Paragraph("CVV: " + cvv));
            document.close();
            JOptionPane.showMessageDialog(null, "Factura PDF generada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la factura PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}