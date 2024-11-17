package br.edu.infnet.victorhdcampos.controller;
import br.edu.infnet.victorhdcampos.domain.Receita;
import br.edu.infnet.victorhdcampos.service.ReceitaService;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("api/receita")
public class ReceitaController extends GenericController<Receita>{
    public ReceitaController(ReceitaService service){ super(service); }

    @Autowired
	private ReceitaService receitaService;

	@Operation(summary = "Pesquisar por data de emissão (yyyy-mm-dd)")
    @GetMapping("/data/{dataIni}&{dataFim}")
    public ResponseEntity<List<Receita>> obterReceitaPorData(@PathVariable LocalDate dataIni, @PathVariable LocalDate dataFim){


		if(dataIni.isAfter(dataFim)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

        List<Receita> items = receitaService.getReceitaPorDataEmissao(dataIni,dataFim);

        if(items.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
		}

        return new ResponseEntity<>(items, HttpStatus.OK);
    }       

}
