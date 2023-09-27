package rinha.backend.java.pessoa;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class DetalhaPessoaController {

    private final PessoaRepository repository;

    public DetalhaPessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("pessoas/{id}")
    public PessoaResponse busca(@PathVariable UUID id) {

        var possivelPessoa = repository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatusCode.valueOf(404)));

        return new PessoaResponse(possivelPessoa);

    }
}
