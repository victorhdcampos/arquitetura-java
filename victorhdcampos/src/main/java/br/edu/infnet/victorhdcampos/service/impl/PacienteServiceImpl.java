package br.edu.infnet.victorhdcampos.service.impl;

import br.edu.infnet.victorhdcampos.domain.Endereco;
import br.edu.infnet.victorhdcampos.domain.Paciente;
import br.edu.infnet.victorhdcampos.repository.PacienteRepository;
import br.edu.infnet.victorhdcampos.service.LocalizacaoService;
import br.edu.infnet.victorhdcampos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Component
public class PacienteServiceImpl extends GenericServiceImpl<Paciente, Long, PacienteRepository> implements PacienteService {

    public PacienteServiceImpl(PacienteRepository repository){
        super(repository);
    }

	@Autowired
	private LocalizacaoService localizacaoService;

    @Override
    public void incluir(Paciente paciente){
        
        try{
             String cep = paciente.getEndereco().getCep();
            
            Endereco endereco = localizacaoService.findByCep(cep);

            paciente.setEndereco(endereco);

            repository.save(paciente);

        }catch (Exception e){
            throw e;
        }
    }    

    public List<Paciente> getPacientePorNome(String nome) {
        return repository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
    }

}

