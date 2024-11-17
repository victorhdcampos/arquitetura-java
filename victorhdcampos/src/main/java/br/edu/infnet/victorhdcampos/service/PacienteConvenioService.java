package br.edu.infnet.victorhdcampos.service;

import java.util.List;

import br.edu.infnet.victorhdcampos.domain.PacienteConvenio;

public interface PacienteConvenioService extends GenericService<PacienteConvenio>{

    List<PacienteConvenio> getPacientePorNome(String nome);
}
