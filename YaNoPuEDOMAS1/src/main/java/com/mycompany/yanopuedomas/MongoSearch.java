
package com.mycompany.yanopuedomas;

import com.mycompany.yanopuedomas.MongoConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
//patrón Composite porque representan diferentes operaciones en la base de datos MongoDB y pueden ser tratadas de manera uniforme 
//como componentes individuales.
public class MongoSearch {
   private MongoConnection mongoConnection;

    public MongoSearch() {
        mongoConnection = MongoConnection.getInstance();
    }

    public FindIterable<Document> searchSoupBase(String nombre) {
        mongoConnection.connect(); // Asegurar que la conexión esté establecida
        MongoCollection<Document> collection = mongoConnection.getCollection();
        FindIterable<Document> resultados = collection.find(new Document("Sopa base", nombre));
        return resultados;
    }
    
 
}
