
package com.mycompany.yanopuedomas;

import com.mycompany.yanopuedomas.MongoConnection;
import com.mongodb.client.MongoClients;
import javax.swing.JOptionPane;
import org.bson.Document;
//patrón Composite porque representan diferentes operaciones en la base de datos MongoDB y pueden ser tratadas de manera uniforme 
//como componentes individuales.

public class MongoDelete {
   private MongoConnection mongoConnection;

    public MongoDelete() {
        mongoConnection = MongoConnection.getInstance();
    }
    
    public void Eliminar(String soupBase){
        // Obtener la colección desde la instancia de MongoConnection
        mongoConnection.connect(); // Asegurar que la conexión esté establecida
        mongoConnection.getCollection().deleteOne(new Document("Sopa base", soupBase));
        JOptionPane.showMessageDialog(null, "Eliminado con éxito");       
    }
}
