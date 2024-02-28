
package com.mycompany.yanopuedomas;
import com.mongodb.client.MongoCollection;
import com.mycompany.yanopuedomas.MongoConnection;
import javax.swing.JOptionPane;
import org.bson.Document;

// implementación del patrón Builder que se utiliza para construir documentos específicos para la inserción en una base 
//de datos MongoDB. Permite configurar partes individuales del documento, separa el proceso de construcción del objeto de su 
//representación, permitiendo crear diferentes variantes de un objeto complejo utilizando el mismo proceso de construcción.
public class MongoDocumentBuilder implements DocumentBuilder {
    private String soupBase;
    private String proteins;
    private String toppings;
    private String drinks;

    public MongoDocumentBuilder() {}

    public MongoDocumentBuilder soupBase(String soupBase) {
        this.soupBase = soupBase;
        return this;
    }

    public MongoDocumentBuilder proteins(String proteins) {
        this.proteins = proteins;
        return this;
    }

    public MongoDocumentBuilder toppings(String toppings) {
        this.toppings = toppings;
        return this;
    }

    public MongoDocumentBuilder drinks(String drinks) {
        this.drinks = drinks;
        return this;
    }

    @Override
    public Document build() {
        return new Document("Sopa base", soupBase)
            .append("Proteína", proteins)
            .append("Bebidas", toppings)
            .append("Toppins", drinks);
    }
}

