package br.edu.infnet.victorhdcampos.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name="`paciente_regulado`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRegulado extends Paciente {

    private String codigoRegulacao;

	private LocalDate dataRegulacao;  

    private String tipoRegulacao;  
      
    private String instituicaoRegulacao;

}
