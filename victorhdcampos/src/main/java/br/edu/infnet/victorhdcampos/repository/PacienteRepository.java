package br.edu.infnet.victorhdcampos.repository;

import br.edu.infnet.victorhdcampos.domain.Paciente;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByNomeContaining(String nome, Sort by);
}
