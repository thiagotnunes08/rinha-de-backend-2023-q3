package rinha.backend.java.pessoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContagemPessoasController {

    private final PessoaRepository repository;

    public ContagemPessoasController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contagem-pessoas")
    public int buscaTodos() {

        return repository.findAll().size();

    }
}
