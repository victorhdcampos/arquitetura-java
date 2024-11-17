package br.edu.infnet.victorhdcampos.service;

import java.util.List;
import br.edu.infnet.victorhdcampos.domain.Receita;
import java.time.LocalDate;

public interface ReceitaService extends GenericService<Receita>{

    List<Receita> getReceitaPorDataEmissao(LocalDate dataIni, LocalDate dataFim);
}
