package rinha.backend.java.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    boolean existsByApelido(String apelido);

    @Query(value = "SELECT * FROM pessoa p WHERE " +
            "LOWER(p.nome) LIKE %:nome% OR " +
            "LOWER(p.apelido) LIKE %:apelido% OR " +
            "EXISTS (SELECT 1 FROM unnest(p.stacks) stack WHERE LOWER(stack) LIKE %:stack%)",
            nativeQuery = true)
    List<Pessoa> findPessoasContendo(@Param("nome") String nome,@Param("apelido")String apelido,@Param("stack")String stack);
}
