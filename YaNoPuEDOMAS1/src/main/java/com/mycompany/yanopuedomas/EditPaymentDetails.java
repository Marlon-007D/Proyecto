/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.yanopuedomas;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Demera
 */

public class EditPaymentDetails {
    private final MongoEdit mongoEdit;

    public EditPaymentDetails() {
        this.mongoEdit = new MongoEdit();
    }

    public void EditPay(String IDs, String newIDs, String name, String address, String phone, String email, String expirationDate, String cardName, String cardNumber, String cvv) {
        mongoEdit.Conexion();
        MongoCollection<Document> collection = mongoEdit.collection;
        Document filter = new Document("Cedula", IDs);
        Document update = new Document("$set", new Document("Cedula", newIDs)
                .append("Nombre", name)
                .append("Direccion", address)
                .append("Telefono", phone)
                .append("Correo", email));
        UpdateResult result = collection.updateOne(filter, update);
        if (result.getModifiedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente en MongoDB");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna factura con el ID proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    void EditPay(String ID, String newID, String name, String address, String phone, String email) {
    }
}
