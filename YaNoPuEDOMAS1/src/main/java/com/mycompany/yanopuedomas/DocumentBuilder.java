package com.mycompany.yanopuedomas;

import javax.swing.JOptionPane;
import org.bson.Document;
// patrón Builder que permite crear documentos.
//Define un método build() que debe ser implementado por las clases que deseen construir documentos
interface DocumentBuilder {
    Document build();
}
