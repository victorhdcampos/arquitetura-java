package br.edu.infnet.victorhdcampos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name="`receita_item`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String medicamento;

	private float quantidade;

	private String unidadeMedida;

	private String posologia;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="receita_id")
	@JsonBackReference
	private Receita receita;

}
