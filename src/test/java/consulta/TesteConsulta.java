package consulta;

import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Status;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

public class TesteConsulta {

    private CenarioPaciente paciente;
    private ConsultaHibernate database;

    @Before
    public void iniciar() {
        paciente = new CenarioPaciente();
        database = new ConsultaHibernate();
    }

    @Test
    public void nova() {
        Consulta consultaDeJoao = new Consulta(Especialidade.GERAL, Prioridade.IDOSO, Status.FILA, LocalDate.of(2017, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.MARCH, 5), paciente.joao());
        database.inserir(consultaDeJoao);

        Consulta consultaDeMaria = new Consulta(Especialidade.GERAL, Prioridade.IDOSO, Status.FILA, LocalDate.of(2017, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.MARCH, 5), paciente.maria());
        database.inserir(consultaDeMaria);

        Consulta buscarConsultaDeJoao = database.recuperar(1);
        Consulta buscarConsultaDeMaria = database.recuperar(2);

        Boolean MarcadaConsultaDeJoao = buscarConsultaDeJoao.getDataSolicitacao().equals(LocalDate.of(2017, Month.SEPTEMBER, 1))
                && buscarConsultaDeJoao.getPaciente().getCartaoSus().equals(paciente.joao().getCartaoSus());

        Boolean MarcadaConsultaDeMaria = buscarConsultaDeMaria.getDataSolicitacao().equals(LocalDate.of(2017, Month.SEPTEMBER, 1))
                && buscarConsultaDeMaria.getPaciente().getCartaoSus().equals(paciente.maria().getCartaoSus());

        Assert.assertTrue(MarcadaConsultaDeJoao && MarcadaConsultaDeMaria);
    }

}
