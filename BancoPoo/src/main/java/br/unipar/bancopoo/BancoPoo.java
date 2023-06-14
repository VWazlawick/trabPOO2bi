package br.unipar.bancopoo;

import br.unipar.bancopoo.models.Agencia;
import br.unipar.bancopoo.models.Estado;
import br.unipar.bancopoo.models.Pais;
import br.unipar.bancopoo.repositories.PaisDAO;
import br.unipar.bancopoo.services.PaisService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BancoPoo {

    public static void main(String[] args) {
        
        try{
            PaisService service = new PaisService();
            Pais pais = new Pais();
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
    }
}
