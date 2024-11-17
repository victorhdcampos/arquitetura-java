package br.edu.infnet.victorhdcampos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name="`endereco`")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	private String localidade;
	
	private String uf;
 
    public Endereco(String cep) {
        this.cep = cep; 
    }
    
	@Override
	public String toString() {
		return "Endereço: " + cep;
	}

}
