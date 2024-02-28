
package com.mycompany.yanopuedomas;
/*
// Patron Creacional: Factory Method
// Este se encarga de crear objetos de la superclase, los datos de de la subclase se modificaran                                      
*/
public class Ingredients {
    
    public String soupBase;
    public String proteins;
    public String toppins;
    public String drinks;
    // Patron de Comportamiento: Observer
    // Nos permite crear un objeto como Observer, puesto que se encarga de que el Objeto cambie su estado  
    public void Ingredients(String soupBase, String proteins, String toppins, String drinks) {
        this.soupBase = soupBase;
        this.proteins = proteins;
        this.toppins = toppins;
        this.drinks = drinks;
    }

    public Ingredients() {
        
    }

    public String getSoupBase() {
        return soupBase;
    }

    public void setSoupBase(String soupBase) {
        this.soupBase = soupBase;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getToppins() {
        return toppins;
    }

    public void setToppins(String toppins) {
        this.toppins = toppins;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

}
