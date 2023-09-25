package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValicacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoConsulta implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){

       var dataConsulta = dados.data();
       var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

       var horarioAntesDoFuncionamento = dataConsulta.getHour() < 7;
       var horarioDepoisDoFuncionamento = dataConsulta.getHour() >18;

       if(domingo || horarioAntesDoFuncionamento|| horarioDepoisDoFuncionamento){
           throw  new ValicacaoException("Consulta fora do horário de funcionamento da clínica");
       }
    }
}
