package br.edu.infnet.victorhdcampos.service;

import java.util.List;

import br.edu.infnet.victorhdcampos.domain.PacienteParticular;

public interface PacienteParticularService extends GenericService<PacienteParticular>{

    List<PacienteParticular> getPacientePorNome(String nome);
}
