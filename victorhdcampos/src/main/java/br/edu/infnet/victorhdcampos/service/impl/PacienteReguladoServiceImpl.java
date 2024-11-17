package br.edu.infnet.victorhdcampos.service.impl;

import br.edu.infnet.victorhdcampos.domain.Endereco;
import br.edu.infnet.victorhdcampos.domain.PacienteRegulado;
import br.edu.infnet.victorhdcampos.repository.PacienteReguladoRepository;
import br.edu.infnet.victorhdcampos.service.LocalizacaoService;
import br.edu.infnet.victorhdcampos.service.PacienteReguladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Component
public class PacienteReguladoServiceImpl extends GenericServiceImpl<PacienteRegulado, Long, PacienteReguladoRepository> implements PacienteReguladoService {

    public PacienteReguladoServiceImpl(PacienteReguladoRepository repository){
        super(repository);
    }

	@Autowired
	private LocalizacaoService localizacaoService;

    @Override
    public void incluir(PacienteRegulado paciente){
        
        try{
             String cep = paciente.getEndereco().getCep();
            
            Endereco endereco = localizacaoService.findByCep(cep);

            paciente.setEndereco(endereco);

            repository.save(paciente);

        }catch (Exception e){
            throw e;
        }
    }    

    public List<PacienteRegulado> getPacientePorNome(String nome) {
        return repository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
    }

}

