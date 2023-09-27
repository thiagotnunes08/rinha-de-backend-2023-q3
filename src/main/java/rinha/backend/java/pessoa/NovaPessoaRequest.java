package rinha.backend.java.pessoa;

import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record NovaPessoaRequest(@Length(max = 32) String apelido, @Length(max = 100) String nome, LocalDate nascimento,
                                List<String> stack) {
    public Pessoa toModel(UUID id) {
        return new Pessoa(id, apelido, nome, nascimento, stack);
    }

    public boolean nomeOuApelidoNulo() {
        return this.apelido == null || this.nome == null;
    }

    public boolean validaNomeTexto() {

        var numeros = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

        for (String numero : numeros) {

            boolean contemNumero = nome.contains(numero);

            if (contemNumero) {

                return true;
            }

        }

        return false;
    }

    public boolean stackMaiorQue32Caracter() {

        if (stack != null) {

            for (String stacks : stack) {

                int quantidadeLetras = stacks.length();

                if (quantidadeLetras >= 32) {
                    return true;
                }

            }

        }
        return false;
    }

}
