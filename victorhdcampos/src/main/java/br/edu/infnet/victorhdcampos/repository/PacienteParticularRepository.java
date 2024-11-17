package br.edu.infnet.victorhdcampos.repository;

import br.edu.infnet.victorhdcampos.domain.PacienteParticular;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteParticularRepository extends JpaRepository<PacienteParticular, Long> {

    List<PacienteParticular> findByNomeContaining(String nome, Sort by);
}
