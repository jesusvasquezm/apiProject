package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValicacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteAtivo){
            throw  new ValicacaoException("Consulta não pode ser agendada com paciente excluido");
        }
    }

}
