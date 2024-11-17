package br.edu.infnet.victorhdcampos.repository;
import br.edu.infnet.victorhdcampos.domain.Receita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByDataEmissaoBetween(LocalDate dataIni, LocalDate dataFim);
}
