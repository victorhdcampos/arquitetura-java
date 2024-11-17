package br.edu.infnet.victorhdcampos.service;

import java.util.List;
import br.edu.infnet.victorhdcampos.domain.PacienteRegulado;

public interface PacienteReguladoService extends GenericService<PacienteRegulado>{

    List<PacienteRegulado> getPacientePorNome(String nome);
}
