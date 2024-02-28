/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.yanopuedomas;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Demera
 */
public class InsertPayment {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    
    public void InsertarPago(String name, String id, String address, String phone, String email, String expirationDate, String cardName, String cardNumber, String cvv) {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("RamenCat");
        collection = database.getCollection("Factura");
        Document document = new Document()
            .append("Nombre: ", name)
            .append("Cedula: ", id)
            .append("Direccion: ", address)
            .append("Telefono: ", phone)
            .append("Correo: ", email)
            .append("Fecha Expiracion: ", expirationDate)
            .append("Nombre Titular: ", cardName)
            .append("Numero Tarjeta: ", cardNumber)
            .append("CVV: ", cvv);
        collection.insertOne(document);
    }

}
