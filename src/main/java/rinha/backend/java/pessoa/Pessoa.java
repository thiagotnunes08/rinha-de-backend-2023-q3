package rinha.backend.java.pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Pessoa {

    @Id
    private UUID id;
    private String apelido;
    private String nome;
    private LocalDate nascimento;
    private List<String> stacks = new ArrayList<>();

    public Pessoa(UUID id, String apelido, String nome, LocalDate nascimento, List<String> stacks) {
        this.id = id;
        this.apelido = apelido;
        this.nome = nome;
        this.nascimento = nascimento;
        this.stacks = stacks;
    }

    /**
     * @deprecated uso exclusivo do hibernate
     */
    @Deprecated
    public Pessoa() {
    }

    public UUID getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public List<String> getStacks() {
        return stacks;
    }
}
