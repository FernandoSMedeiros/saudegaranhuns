package consulta;

import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Status;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;

import org.junit.Test;

public class TesteConsulta {
    
    private CenarioPaciente paciente;
    private ConsultaHibernate database;
    
    @Before
    public void iniciar(){
        paciente = new CenarioPaciente();
        database = new ConsultaHibernate();
    }
    
    @Test
    public void nova(){
       Consulta consulta = new Consulta(Especialidade.GERAL, Prioridade.IDOSO, Status.FILA, LocalDate.of(2017, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.MARCH, 5), paciente.joao());
       database.inserir(consulta);
       
       Boolean consultaCadastrada = database.recuperar(5).getDataSolicitacao().equals(LocalDate.of(2017, Month.SEPTEMBER, 1));
    }
    
}
