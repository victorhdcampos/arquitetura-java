package br.edu.infnet.victorhdcampos.service.impl;

import br.edu.infnet.victorhdcampos.domain.Receita;
import br.edu.infnet.victorhdcampos.repository.ReceitaRepository;
import br.edu.infnet.victorhdcampos.service.ReceitaService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;


@Service
@Component
public class ReceitaServiceImpl extends GenericServiceImpl<Receita, Long, ReceitaRepository> implements ReceitaService {

    public ReceitaServiceImpl(ReceitaRepository repository){
        super(repository);
    }

        public List<Receita> getReceitaPorDataEmissao(LocalDate dataIni, LocalDate dataFim) {
        return repository.findByDataEmissaoBetween(dataIni, dataFim);
    }

}

