package br.unipar.bancopoo;

import br.unipar.bancopoo.models.Agencia;
import br.unipar.bancopoo.models.Cidade;
import br.unipar.bancopoo.models.Estado;
import br.unipar.bancopoo.models.Pais;
import br.unipar.bancopoo.repositories.PaisDAO;
import br.unipar.bancopoo.services.CidadeService;
import br.unipar.bancopoo.services.EstadoService;
import br.unipar.bancopoo.services.PaisService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BancoPoo {

    public static void main(String[] args) {
        
        try{

            CidadeService service = new CidadeService();
            
            List<Cidade> list = service.findAll();
            System.out.println(list);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
}
