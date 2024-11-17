package br.edu.infnet.victorhdcampos.service;

import java.util.List;

import br.edu.infnet.victorhdcampos.domain.Paciente;

public interface PacienteService extends GenericService<Paciente>{

    List<Paciente> getPacientePorNome(String nome);
  }
