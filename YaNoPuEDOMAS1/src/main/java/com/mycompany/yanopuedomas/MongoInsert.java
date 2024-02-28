
package com.mycompany.yanopuedomas;

import com.mongodb.client.MongoCollection;
import com.mycompany.yanopuedomas.MongoConnection;
import javax.swing.JOptionPane;
import org.bson.Document;
//patrón Composite porque representan diferentes operaciones en la base de datos MongoDB y pueden ser tratadas de manera uniforme 
//como componentes individuales.
public class MongoInsert {
    private MongoConnection mongoConnection;

    public MongoInsert() {
        mongoConnection = MongoConnection.getInstance();
    }

    // Método para insertar un documento en la base de datos MongoDB utilizando el Builder
    public void insert(DocumentBuilder documentBuilder) {
        mongoConnection.connect();
        MongoCollection<Document> collection = mongoConnection.getCollection();
        
        // Construir el documento utilizando el Builder
        Document document = documentBuilder.build();

        collection.insertOne(document);
        JOptionPane.showMessageDialog(null, "Datos agregados a la base de datos MongoDB.");
    }
}
