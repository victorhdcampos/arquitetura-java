package br.edu.infnet.victorhdcampos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="`paciente`")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int prontuario;    

    private String nome;

	private String sexo;

    private double peso;

    private double altura;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="endereco_id") 
    private Endereco endereco;
 
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Telefone> telefone = new ArrayList<Telefone>();
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Documento> documento = new ArrayList<Documento>();

	private LocalDate dataNascimento;

	private LocalDate dataObito;

    private boolean ativo = true;

    
	@Override
	public String toString() {

		return String.format("Paciente %s, prontuário %s, sexo %s cadastrado com sucesso!", 
                nome,
                prontuario,
                sexo                
			);
	}    

}
