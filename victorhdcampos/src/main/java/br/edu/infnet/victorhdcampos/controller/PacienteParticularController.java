package br.edu.infnet.victorhdcampos.controller;
import br.edu.infnet.victorhdcampos.domain.PacienteParticular;
import br.edu.infnet.victorhdcampos.service.PacienteParticularService;
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
@RequestMapping("api/paciente-particular")
public class PacienteParticularController extends GenericController<PacienteParticular>{
    public PacienteParticularController(PacienteParticularService service){ super(service); }

    @Autowired
	private PacienteParticularService pacienteService;

	@Operation(summary = "Pesquisar por nome")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<PacienteParticular>> getPacientePorNome(@PathVariable String nome){
        List<PacienteParticular> items = pacienteService.getPacientePorNome(nome);

        if(items.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
		}

        return new ResponseEntity<>(items, HttpStatus.OK);
    }       

}
