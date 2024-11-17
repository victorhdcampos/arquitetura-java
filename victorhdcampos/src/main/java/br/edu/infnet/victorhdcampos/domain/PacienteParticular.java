package br.edu.infnet.victorhdcampos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name="`paciente_particular`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteParticular extends Paciente {
 
    private String metodoPagamento;    
    private String indicacao;       

}
