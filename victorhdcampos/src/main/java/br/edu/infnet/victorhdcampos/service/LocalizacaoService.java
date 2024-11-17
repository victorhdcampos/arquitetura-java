package br.edu.infnet.victorhdcampos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.victorhdcampos.client.EnderecoClient;
import br.edu.infnet.victorhdcampos.client.LocalidadeClient;
import br.edu.infnet.victorhdcampos.domain.Endereco;
import br.edu.infnet.victorhdcampos.domain.Estado;
import br.edu.infnet.victorhdcampos.domain.Municipio;

@Service
public class LocalizacaoService {

	@Autowired
	private EnderecoClient enderecoClient;
	@Autowired
	private LocalidadeClient localidadeClient;

	public Endereco findByCep(String cep) {
		return enderecoClient.findByCep(cep);
	}

	public Collection<Estado> obterEstados(){
		return localidadeClient.obterEstados();
	}
	
	public Collection<Municipio> obterMunicipios(Integer uf){
		return localidadeClient.obterMunicipios(uf);
	}
}
