package br.edu.infnet.victorhdcampos.controller;
import br.edu.infnet.victorhdcampos.domain.Paciente;
import br.edu.infnet.victorhdcampos.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/paciente")
public class PacienteController{

    @Autowired
	private PacienteService pacienteService;

    @Operation(summary = "Pesquisar todos")
    @GetMapping
    public ResponseEntity<List<Paciente>> obterLista(){
        List<Paciente> items = pacienteService.obterLista();

		if(items.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
		}

        return new ResponseEntity<>(items, HttpStatus.OK);
    }    

	@Operation(summary = "Pesquisar por nome")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Paciente>> getPacientePorNome(@PathVariable String nome){
        List<Paciente> items = pacienteService.getPacientePorNome(nome);

        if(items.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
		}

        return new ResponseEntity<>(items, HttpStatus.OK);
    }       

}