/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.yanopuedomas;

/**
 *
 * @author Demera
 */
public interface InvoiceGeneration {
    void generateInvoicePDF(String name, String id, String address, String phone, String email, 
                            String expirationDate, String cardName, String cardNumber, String cvv);
}
