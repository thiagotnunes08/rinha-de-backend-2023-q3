package rinha.backend.java.pessoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BuscaPessoasController {

    private final PessoaRepository pessoaRepository;

    public BuscaPessoasController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/pessoas")
    public List<PessoaResponse> busca(@RequestParam(value = "parametro") String parametro) {

        return pessoaRepository.findPessoasContendo(parametro,parametro,parametro)
                .stream()
                .map(PessoaResponse::new)
                .collect(Collectors.toList());
    }
}
