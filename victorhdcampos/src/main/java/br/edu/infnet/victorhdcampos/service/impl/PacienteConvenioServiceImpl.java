package br.edu.infnet.victorhdcampos.service.impl;

import br.edu.infnet.victorhdcampos.domain.Endereco;
import br.edu.infnet.victorhdcampos.domain.PacienteConvenio;
import br.edu.infnet.victorhdcampos.repository.PacienteConvenioRepository;
import br.edu.infnet.victorhdcampos.service.LocalizacaoService;
import br.edu.infnet.victorhdcampos.service.PacienteConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Component
public class PacienteConvenioServiceImpl extends GenericServiceImpl<PacienteConvenio, Long, PacienteConvenioRepository> implements PacienteConvenioService {

    public PacienteConvenioServiceImpl(PacienteConvenioRepository repository){
        super(repository);
    }

	@Autowired
	private LocalizacaoService localizacaoService;

    @Override
    public void incluir(PacienteConvenio paciente){
        
        try{
             String cep = paciente.getEndereco().getCep();
            
            Endereco endereco = localizacaoService.findByCep(cep);

            paciente.setEndereco(endereco);

            repository.save(paciente);

        }catch (Exception e){
            throw e;
        }
    }    

    public List<PacienteConvenio> getPacientePorNome(String nome) {
        return repository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
    }

}

