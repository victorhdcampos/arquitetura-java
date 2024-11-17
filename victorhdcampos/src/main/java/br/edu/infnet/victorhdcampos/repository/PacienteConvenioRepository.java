package br.edu.infnet.victorhdcampos.repository;

import br.edu.infnet.victorhdcampos.domain.PacienteConvenio;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteConvenioRepository extends JpaRepository<PacienteConvenio, Long> {

    List<PacienteConvenio> findByNomeContaining(String nome, Sort by);
}
