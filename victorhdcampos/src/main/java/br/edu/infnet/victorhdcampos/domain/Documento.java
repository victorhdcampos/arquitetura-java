package br.edu.infnet.victorhdcampos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name="`documento`")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

	private String numero;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="paciente_id")
    @JsonBackReference
    private Paciente paciente;  

    public Documento(Paciente paciente, String tipo, String numero) {
        this.paciente = paciente;
        this.tipo = tipo; 
        this.numero = numero;
    }
    
}
