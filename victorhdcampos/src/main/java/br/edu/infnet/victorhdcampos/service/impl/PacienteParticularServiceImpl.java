package br.edu.infnet.victorhdcampos.service.impl;

import br.edu.infnet.victorhdcampos.domain.Endereco;
import br.edu.infnet.victorhdcampos.domain.PacienteParticular;
import br.edu.infnet.victorhdcampos.repository.PacienteParticularRepository;
import br.edu.infnet.victorhdcampos.service.LocalizacaoService;
import br.edu.infnet.victorhdcampos.service.PacienteParticularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Component
public class PacienteParticularServiceImpl extends GenericServiceImpl<PacienteParticular, Long, PacienteParticularRepository> implements PacienteParticularService {

    public PacienteParticularServiceImpl(PacienteParticularRepository repository){
        super(repository);
    }

	@Autowired
	private LocalizacaoService localizacaoService;

    @Override
    public void incluir(PacienteParticular paciente){
        
        try{
             String cep = paciente.getEndereco().getCep();
            
            Endereco endereco = localizacaoService.findByCep(cep);

            paciente.setEndereco(endereco);

            repository.save(paciente);

        }catch (Exception e){
            throw e;
        }
    }    

    public List<PacienteParticular> getPacientePorNome(String nome) {
        return repository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
    }

}

