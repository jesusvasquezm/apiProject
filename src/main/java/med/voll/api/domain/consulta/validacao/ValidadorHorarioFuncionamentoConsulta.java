package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValicacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoConsulta {

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
