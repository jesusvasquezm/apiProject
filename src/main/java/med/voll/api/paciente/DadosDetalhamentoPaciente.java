package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DadosDetalhamentoPaciente(String nome, String cpf, String email, String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
    this(paciente.getNome(),paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }
}
