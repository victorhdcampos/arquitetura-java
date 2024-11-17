package br.edu.infnet.victorhdcampos.repository;

import br.edu.infnet.victorhdcampos.domain.ReceitaItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaItemRepository extends JpaRepository<ReceitaItem, Long> {
}
