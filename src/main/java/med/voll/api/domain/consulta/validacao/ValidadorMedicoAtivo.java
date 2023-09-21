package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValicacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {
    public MedicoRepository medico;

    public void validar(DadosAgendamentoConsulta dados){
        var dadosMedico = dados.idMedico();
        var medicoEstaAtivo = medico.findAtivoById(dadosMedico);

        if(dadosMedico == null){
            return;
        }

        if(!medicoEstaAtivo){
            throw  new ValicacaoException("A consula não pode ser agendada com o medico excluido");
        }

    }
}
