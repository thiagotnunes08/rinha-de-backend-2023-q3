package rinha.backend.java.pessoa;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.UUID;

@RestController
public class NovaPessoaController {

    private final PessoaRepository repository;

    public NovaPessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/pessoas")
    public ResponseEntity<?> cria(@RequestBody @Valid NovaPessoaRequest request) {


        if (repository.existsByApelido(request.apelido())) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(422));
        }

        if (request.validaNomeTexto()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }

        if (request.nomeOuApelidoNulo()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(422));
        }

        if (request.stackMaiorQue32Caracter()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }

        var id = UUID.randomUUID();

        var novaPessoa = request.toModel(id);

        repository.save(novaPessoa);

        return ResponseEntity.created(URI.create("pessoa/%s".formatted(id))).build();

    }
}
