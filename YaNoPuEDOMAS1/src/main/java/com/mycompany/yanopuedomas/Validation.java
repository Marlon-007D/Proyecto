
package com.mycompany.yanopuedomas;

import javax.swing.JCheckBox;

public class Validation {
    
    public String TomarDatosSoup(JCheckBox Yasai ,JCheckBox Chiki,JCheckBox Gyuniku){
        if(Yasai.isSelected()){
           if(Chiki.isSelected() || Gyuniku.isSelected()){
            
            Chiki.setSelected(false);
            Gyuniku.setSelected(false);
            } 
            return "Yasai"; 
        }else if(Chiki.isSelected()){
            if(Yasai.isSelected() || Gyuniku.isSelected()){
            
            Yasai.setSelected(false);
            Gyuniku.setSelected(false);
            } 
            return "Chiki";
        }else if(Gyuniku.isSelected()){
           if(Yasai.isSelected() || Chiki.isSelected()){
            
            Yasai.setSelected(false);
            Chiki.setSelected(false);
            } 
            return "Gyuniku"; 
        }
        return null;   
    }   
    public String TomarDatosBebidas(JCheckBox Matcha ,JCheckBox Sake,JCheckBox Bubble,JCheckBox Ramura){
         if(Matcha.isSelected()){
           if(Sake.isSelected() || Bubble.isSelected() || Ramura.isSelected()){
            
            Sake.setSelected(false);
            Bubble.setSelected(false);
            Ramura.setSelected(false);
            } 
            return "Matcha"; 
        }else if(Sake.isSelected()){
            if(Matcha.isSelected() || Bubble.isSelected() || Ramura.isSelected()){
            
            Matcha.setSelected(false);
            Bubble.setSelected(false);
            Ramura.setSelected(false);
            } 
            return "Sake";
        }else if(Bubble.isSelected()){
           if(Matcha.isSelected() || Sake.isSelected() || Ramura.isSelected()){
            
            Matcha.setSelected(false);
            Sake.setSelected(false);
            Ramura.setSelected(false);
            } 
            return "Bubble"; 
        }else if(Ramura.isSelected()){
           if(Matcha.isSelected() || Sake.isSelected() || Bubble.isSelected()){
            
            Matcha.setSelected(false);
            Sake.setSelected(false);
            Bubble.setSelected(false);
            } 
            return "Ramura"; 
        }
        return null; 
    }
    public String TomarDatosProteina(JCheckBox Buta ,JCheckBox Tariniku,JCheckBox Amazuppai,JCheckBox Butaniku){
        if(Buta.isSelected()){
           if(Tariniku.isSelected() || Amazuppai.isSelected() || Butaniku.isSelected()){
            
            Tariniku.setSelected(false);
            Amazuppai.setSelected(false);
            Butaniku.setSelected(false);
            } 
            return "Buta"; 
        }else if(Tariniku.isSelected()){
            if(Buta.isSelected() || Amazuppai.isSelected() || Butaniku.isSelected()){
            
            Buta.setSelected(false);
            Amazuppai.setSelected(false);
            Butaniku.setSelected(false);
            } 
            return "Tariniku";
        }else if(Amazuppai.isSelected()){
           if(Buta.isSelected() || Tariniku.isSelected() || Butaniku.isSelected()){
            
            Buta.setSelected(false);
            Tariniku.setSelected(false);
            Butaniku.setSelected(false);
            } 
            return "Amazuppai"; 
        }else if(Butaniku.isSelected()){
           if(Buta.isSelected() || Tariniku.isSelected() || Amazuppai.isSelected()){
            
            Buta.setSelected(false);
            Tariniku.setSelected(false);
            Amazuppai.setSelected(false);
            } 
            return "Butaniku"; 
        }
        return null;
    }
    public String TomarDatosToppins(JCheckBox Konbo1 ,JCheckBox Konbo2,JCheckBox Konbo3){
        if(Konbo1.isSelected()){
           if(Konbo2.isSelected() || Konbo3.isSelected()){   
            Konbo2.setSelected(false);
            Konbo3.setSelected(false);
            } 
            return "Konbo1"; 
        }else if(Konbo2.isSelected()){
            if(Konbo1.isSelected() || Konbo3.isSelected()){
            Konbo1.setSelected(false);
            Konbo3.setSelected(false);
            } 
            return "Konbo2";
        }else if(Konbo3.isSelected()){
           if(Konbo1.isSelected() || Konbo2.isSelected()){        
            Konbo1.setSelected(false);
            Konbo2.setSelected(false);
            } 
            return "Konbo3"; 
        }
        return null;
    }
}
