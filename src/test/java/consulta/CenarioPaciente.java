package consulta;

import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import java.time.LocalDate;
import java.time.Month;

public class CenarioPaciente {
    
    public Paciente joao(){    
        return new Paciente("Joao", "12345678", LocalDate.of(1945, Month.MARCH, 25), 
               new Endereco("50", "Logo Ali", new Bairro("Indiano")), 
               new PostoSaude("Indiano", new Endereco("S/N", "Indiano", new Bairro("Indiano")
               ))
        );        
    }
    
}
