/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.yanopuedomas;

/**
 *
 * @author Demera
 */
public class ValidationPAY {
    private static ValidationPAY instance;
    //Se crea un constructor privado para evitarque la clase sea instanciada externamente
    private ValidationPAY(){        
    }
    /*Se proporciona un metodo estatico publico llamado getInstance()
    que devuelve la unica instancia de la clase Validation
    si la instancia aun no ha sido creada, se crea una nueva
    de lo contrario se devuelve la instancia existente
    */
    public static ValidationPAY getInstance(){
        if(instance == null){
            instance = new ValidationPAY();
        }
        return instance;
    }
    public static boolean validateName(String name) {
        String[] nameParts = name.split("\\s+");
        if (nameParts.length != 2) {
            return false;
        }
        for (String part : nameParts) {
            if (!part.matches("[a-zA-Z\\s]+")) {
                return false;
            }
        }
        return true;
    }
    public boolean validateID(String id) {
        return id.matches("\\d{10}");
    }
     public boolean validatePhone(String phone) {
        return phone.matches("09\\d{8}");
    }
    public static boolean validateEmail(String email) {
    String[] domains = {"@gmail.com", "@outlook.com", "@hotmail.com", "@yahoo.com", "@live.com", "@icloud.com"};
    for (String domain : domains) {
        if (email.endsWith(domain)) {
            return true;
        }
    }
    return false;
    }
    public static boolean validateFullName(String fullName) {
        String[] nameParts = fullName.split("\\s+");
        if (nameParts.length != 4) {
            return false;
        }
        for (String part : nameParts) {
            if (!part.matches("[a-zA-Z\\s]+")) {
                return false;
            }
        }
        return true;
    }
    public static boolean validateCreditCard(String cardNumber) {
        return cardNumber.replaceAll(" ", "").matches("\\d{16}");
    }
    public static boolean validateExpirationDate(String expirationDate) {
    return expirationDate.matches("^(0[1-9]|1[0-2])/[2-3][0-9]$");
    }
    public static boolean validateCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }
}
