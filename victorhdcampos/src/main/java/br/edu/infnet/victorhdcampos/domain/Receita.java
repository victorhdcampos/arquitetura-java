package br.edu.infnet.victorhdcampos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name="`receita`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="paciente_id")   
    @JsonIgnore
    @JsonBackReference
    @Schema(hidden = true)
    private Paciente paciente;

	private String medico;

	private LocalDate dataEmissao;

	private LocalDate dataValidade;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ReceitaItem> receitaItem;

    @JsonProperty("paciente")
    @Transient
    private Long pacienteId;

    public void setPacienteId(Long id) {
        Paciente pac = new Paciente() {};	
        pac.setId(id);
		this.paciente = pac;
	}

    public Long getPacienteId() {
        return this.paciente.getId();
	}    

	@Override
	public String toString() {

		return String.format("Receita do medico %s na data %s cadastrada com sucesso!", 
                medico,
                dataEmissao             
			);
	}        

}
