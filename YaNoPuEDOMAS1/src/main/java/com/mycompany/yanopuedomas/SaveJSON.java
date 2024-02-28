/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.yanopuedomas;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author Demera
 */
public class SaveJSON {
    public interface PaymentSaver {
        void savePayment(String name, String id, String address, String phone, String email, String expirationDate, String cardName, String cardNumber, String cvv);
    }
    private static class JSONPaymentSaver implements PaymentSaver {
        @Override
        public void savePayment(String name, String id, String address, String phone, String email, String expirationDate, String cardName, String cardNumber, String cvv) {
            try {
                JSONObject json = new JSONObject();
                json.put("Nombre", name);
                json.put("Cedula", id);
                json.put("Direccion", address);
                json.put("Telefono", phone);
                json.put("Correo", email);
                json.put("Fecha caducidad", expirationDate);
                json.put("Titular de la tarjeta", cardName);
                json.put("Numero de tarjeta", cardNumber);
                json.put("CVV", cvv);

                FileWriter file = new FileWriter("pago.json", true);
                file.write(json.toJSONString() + "\n");
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void InsertarPagoJSON(String name, String id, String address, String phone, String email, String expirationDate, String cardName, String cardNumber, String cvv) {
        PaymentSaver saver = new JSONPaymentSaver();
        saver.savePayment(name, id, address, phone, email, expirationDate, cardName, cardNumber, cvv);
    }
}
