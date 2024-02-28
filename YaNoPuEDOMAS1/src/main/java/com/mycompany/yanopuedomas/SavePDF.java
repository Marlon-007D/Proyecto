/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.yanopuedomas;

/**
 *
 * @author Demera
 */
public class SavePDF {
   private InvoiceGeneration strategy;
    
    public void setInvoiceGeneration(InvoiceGeneration strategy) {
        this.strategy = strategy;
    }
    public void generateInvoice(String name, String id, String address, String phone, String email, 
                                String expirationDate, String cardName, String cardNumber, String cvv) {
        if (strategy != null) {
            strategy.generateInvoicePDF(name, id, address, phone, email, expirationDate, cardName, cardNumber, cvv);
        }
    }
}
