package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(String nome, String cpf, String email, String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
    this(paciente.getNome(),paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }
}
