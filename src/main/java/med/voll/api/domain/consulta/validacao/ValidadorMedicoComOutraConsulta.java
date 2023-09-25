package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValicacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsulta {

    private ConsultaRepository repository;

    public  void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw  new ValicacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
