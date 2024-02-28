
package com.mycompany.yanopuedomas;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

//Patron Chain of Responsibility : (MongoConnection, MongoSearch, MongoDelete, MongoModify) manejador que puede procesar una 
//solicitud específica de operación en la base de datos.
//Patron estructural Composite raíz del árbol, representa la conexión global a la base de datos y proporcionando métodos para realizar operaciones
//MongoConnection implementa el patrón Singleton para garantizar que solo exista una instancia de esta clase en toda la aplicación. 
public class MongoConnection {
    private static MongoConnection instance;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    // Constructor privado para evitar la instanciación directa
    MongoConnection() {}

    // Método estático para obtener la instancia única de MongoConnection
    public static MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }

    // Método para inicializar la conexión a MongoDB
    public void connect() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("RamenCat");
        collection = database.getCollection("FinalOrder");
    }

    // Método para obtener la colección MongoDB
    public MongoCollection<Document> getCollection() {
        return collection;
    }
}
