package br.edu.infnet.victorhdcampos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.victorhdcampos.service.LocalizacaoService;
import br.edu.infnet.victorhdcampos.service.PacienteService;
import br.edu.infnet.victorhdcampos.service.ReceitaService;
import br.edu.infnet.victorhdcampos.domain.Paciente;
import br.edu.infnet.victorhdcampos.domain.PacienteConvenio;
import br.edu.infnet.victorhdcampos.domain.PacienteParticular;
import br.edu.infnet.victorhdcampos.domain.PacienteRegulado;
import br.edu.infnet.victorhdcampos.domain.Receita;
import br.edu.infnet.victorhdcampos.domain.ReceitaItem;
import br.edu.infnet.victorhdcampos.domain.Endereco;
import br.edu.infnet.victorhdcampos.domain.Documento;
import br.edu.infnet.victorhdcampos.domain.Telefone;
import br.edu.infnet.victorhdcampos.domain.Estado;
import br.edu.infnet.victorhdcampos.domain.Municipio;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private ReceitaService receitaService;
	@Autowired
	private LocalizacaoService localizacaoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		for(Estado estado : localizacaoService.obterEstados()) {
			System.out.println("ESTADO: " + estado.getNome());
		}
		
		for(Municipio municipio : localizacaoService.obterMunicipios(33)) {
			System.out.println("MUNICÍPIO: " + municipio.getNome());
		}
		
		
		FileReader file = new FileReader("files/pacientes.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);

		Paciente paciente = null;	

		List<ReceitaItem> itens = new ArrayList<ReceitaItem>();

		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "PC":
				
				PacienteConvenio pacienteConvenio = new PacienteConvenio();		
				pacienteConvenio.setProntuario(Integer.parseInt(campos[1]));	
				pacienteConvenio.setNome(campos[2]);
				pacienteConvenio.setSexo(campos[3]);
				pacienteConvenio.setPeso(Double.parseDouble(campos[4]));
				pacienteConvenio.setAltura(Double.parseDouble(campos[5]));
				pacienteConvenio.setDataNascimento(LocalDate.parse(campos[6], dateFormat));
				pacienteConvenio.setEndereco(new Endereco(campos[7]));		
				pacienteConvenio.getDocumento().add(new Documento(pacienteConvenio,"CPF", campos[8]));	
				pacienteConvenio.getTelefone().add(new Telefone(pacienteConvenio,"Celular",campos[9]));	

				pacienteConvenio.setNomeConvenio(campos[10]);
				pacienteConvenio.setNumeroCarteira(campos[11]);
				pacienteConvenio.setValidadeCarteira(LocalDate.parse(campos[12], dateFormat));
								
				pacienteService.incluir(pacienteConvenio);

				paciente = pacienteConvenio;
				
				System.out.println("PACIENTE CONVENIO ["+pacienteConvenio.toString()+"]");
				
				break;

			case "PP":
				
				PacienteParticular pacienteParticular = new PacienteParticular();		
				pacienteParticular.setProntuario(Integer.parseInt(campos[1]));	
				pacienteParticular.setNome(campos[2]);
				pacienteParticular.setSexo(campos[3]);
				pacienteParticular.setPeso(Double.parseDouble(campos[4]));
				pacienteParticular.setAltura(Double.parseDouble(campos[5]));
				pacienteParticular.setDataNascimento(LocalDate.parse(campos[6], dateFormat));
				pacienteParticular.setEndereco(new Endereco(campos[7]));		
				pacienteParticular.getDocumento().add(new Documento(pacienteParticular, "CPF", campos[8]));	
				pacienteParticular.getTelefone().add(new Telefone(pacienteParticular, "Celular",campos[9]));					

				pacienteParticular.setMetodoPagamento(campos[10]);
				pacienteParticular.setIndicacao(campos[11]);
								
				pacienteService.incluir(pacienteParticular);

				paciente = pacienteParticular;
				
				System.out.println("PACIENTE PARTICULAR ["+pacienteParticular.toString()+"]");
				
				break;
				
			case "PR":
				
				PacienteRegulado pacienteRegulado = new PacienteRegulado();		
				pacienteRegulado.setProntuario(Integer.parseInt(campos[1]));	
				pacienteRegulado.setNome(campos[2]);
				pacienteRegulado.setSexo(campos[3]);
				pacienteRegulado.setPeso(Double.parseDouble(campos[4]));
				pacienteRegulado.setAltura(Double.parseDouble(campos[5]));
				pacienteRegulado.setDataNascimento(LocalDate.parse(campos[6], dateFormat));
				pacienteRegulado.setEndereco(new Endereco(campos[7]));	
				pacienteRegulado.getDocumento().add(new Documento(pacienteRegulado,"CPF", campos[8]));	
				pacienteRegulado.getTelefone().add(new Telefone(pacienteRegulado,"Celular",campos[9]));					
				
				pacienteRegulado.setCodigoRegulacao(campos[10]);
				pacienteRegulado.setDataRegulacao(LocalDate.parse(campos[11], dateFormat)); 
				pacienteRegulado.setTipoRegulacao(campos[12]); 
				pacienteRegulado.setInstituicaoRegulacao(campos[13]);
								
				pacienteService.incluir(pacienteRegulado);

				paciente = pacienteRegulado;
				
				System.out.println("PACIENTE REGULADO ["+pacienteRegulado.toString()+"]");
				
				break;		
				
			case "RI":
				ReceitaItem receitaItem = new ReceitaItem();
				receitaItem.setMedicamento(campos[1]);
				receitaItem.setQuantidade(Integer.parseInt(campos[2]));
				receitaItem.setUnidadeMedida(campos[3]);
				receitaItem.setPosologia(campos[4]);

				itens.add(receitaItem);
				
				break;				
 
			case "R":
				Receita receita = new Receita();
				receita.setDataEmissao(LocalDate.parse(campos[1], dateFormat));
				receita.setDataValidade(LocalDate.parse(campos[2], dateFormat));
				receita.setMedico(campos[3]);
				receita.setPaciente(paciente);

				for(ReceitaItem item: itens){
					item.setReceita(receita);
				}				

				receita.setReceitaItem(itens);	

				receitaService.incluir(receita);

				itens.clear();

				System.out.println("RECEITA ["+receita.toString()+"]");

				break;

			default:
				break;
			}
					
			linha = leitura.readLine();
		}
		
		for(Paciente v: pacienteService.obterLista()) {
			System.out.println("Paciente cadastrado com sucesso: " + v);			
		}

		leitura.close();
	}
}