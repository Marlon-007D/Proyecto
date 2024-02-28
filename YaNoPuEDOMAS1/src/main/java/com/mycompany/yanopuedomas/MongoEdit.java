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
public class MongoEdit {
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    public void Conexion() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("RamenCat");
        MongoCollection<Document> collection = database.getCollection("Facturas");
    }
    
}
