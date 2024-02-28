
package com.mycompany.yanopuedomas;

import com.mycompany.yanopuedomas.MongoConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.bson.Document;
//patrón Composite porque representan diferentes operaciones en la base de datos MongoDB y pueden ser tratadas de manera uniforme 
//como componentes individuales.

public class ModifyMongo {
    private MongoConnection mongoConnection;
    MongoSearch mongoSearch = new MongoSearch ();

    public ModifyMongo() {
        mongoConnection = new MongoConnection();
    }
        
         public void modificarDocumento(String nombreSopaBase) {
    // Realizar la búsqueda de documentos por el nombre de la sopa base
    FindIterable<Document> resultados = mongoSearch.searchSoupBase(nombreSopaBase);

    // Verificar si se encontraron resultados
    if (resultados == null || !resultados.iterator().hasNext()) {
        JOptionPane.showMessageDialog(null, "No se encontraron documentos para modificar");
        return;
    }

    // Mostrar un JPanel con JComboBox para que el usuario modifique las opciones
    JPanel panel = new JPanel();
    JComboBox<String> sopaBaseComboBox = new JComboBox<>(new String[]{"Seleccione opcion","Verduras", "Carne", "Pollo", "Pescado"});
    JComboBox<String> proteinaComboBox = new JComboBox<>(new String[]{"Seleccione opcion","Pollo", "Cerdo", "Ternera", "Salmón"});
    JComboBox<String> comboToppinsComboBox = new JComboBox<>(new String[]{"Seleccione opcion","Konbo 1", "Konbo 2", "Konbo 3", "Konbo 4"});
    
    panel.add(new JLabel("Sopa Base:"));
    panel.add(sopaBaseComboBox);
    panel.add(new JLabel("Proteína:"));
    panel.add(proteinaComboBox);
    panel.add(new JLabel("Combo Toppins:"));
    panel.add(comboToppinsComboBox);

    int result = JOptionPane.showConfirmDialog(null, panel, "Modificar Documento", JOptionPane.OK_CANCEL_OPTION);
    while (result == JOptionPane.OK_OPTION) {
        // Obtener las opciones seleccionadas por el usuario
        String nuevaSopaBase = (String) sopaBaseComboBox.getSelectedItem();
        String nuevaProteina = (String) proteinaComboBox.getSelectedItem();
        String nuevoComboToppins = (String) comboToppinsComboBox.getSelectedItem();

        // Validar que todas las opciones hayan sido seleccionadas
        if (nuevaSopaBase.equals("Seleccione opcion") || nuevaProteina.equals("Seleccione opcion") || nuevoComboToppins.equals("Seleccione opcion")) {
            JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
            result = JOptionPane.showConfirmDialog(null, panel, "Modificar Documento", JOptionPane.OK_CANCEL_OPTION);
        } else {
            // Actualizar el documento con los nuevos valores
            for (Document documento : resultados) {
                documento.put("Sopa base", nuevaSopaBase);
                documento.put("Proteína", nuevaProteina);
                documento.put("Combo Toppins", nuevoComboToppins);
                
                mongoConnection.connect();
                MongoCollection<Document> collection = mongoConnection.database.getCollection("FinalOrder");
                collection.replaceOne(new Document("_id", documento.getObjectId("_id")), documento);
            }

            JOptionPane.showMessageDialog(null, "Documento modificado exitosamente");
            break; // Salir del bucle
        }
    }
}
    }

