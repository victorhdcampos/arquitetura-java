package br.edu.infnet.victorhdcampos.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name="`paciente_convenio`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteConvenio extends Paciente {

    private String nomeConvenio;

    private String numeroCarteira;  

	private LocalDate validadeCarteira;        
}
