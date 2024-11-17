package br.edu.infnet.victorhdcampos.repository;

import br.edu.infnet.victorhdcampos.domain.PacienteRegulado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteReguladoRepository extends JpaRepository<PacienteRegulado, Long> {

    List<PacienteRegulado> findByNomeContaining(String nome, Sort by);
}
