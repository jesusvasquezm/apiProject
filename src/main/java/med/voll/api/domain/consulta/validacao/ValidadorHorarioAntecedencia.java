package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValicacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;


@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();

        var diferencaEmMinutos = Duration.between(agora,dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30){
            throw  new ValicacaoException("Consulta deve ser agendada com antecedencia  minimna de 30 minutos");
        }
    }
}
