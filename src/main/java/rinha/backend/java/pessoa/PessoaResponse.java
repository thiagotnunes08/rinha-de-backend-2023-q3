package rinha.backend.java.pessoa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record PessoaResponse(UUID id, String apelido, String nome, LocalDate nascimento, List<String> stack) {

    public PessoaResponse(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getApelido(), pessoa.getNome(), pessoa.getNascimento(), pessoa.getStacks());
    }
}
