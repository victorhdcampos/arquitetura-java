package br.edu.infnet.victorhdcampos.controller;

import br.edu.infnet.victorhdcampos.Constantes;
import br.edu.infnet.victorhdcampos.service.GenericService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class GenericController<T> {
    public final GenericService<T> service;

    @Operation(summary = "Pesquisar todos")
    @GetMapping
    public ResponseEntity<List<T>> obterLista(){
        List<T> items = service.obterLista();

		if(items.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
		}

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @Operation(summary = "Pesquisar por ID")
    @GetMapping("/{id}")
    public ResponseEntity<T> obterPorId(@PathVariable Long id){
        T item = service.obterPorId(id);

		if(item == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @Operation(summary = "Incluir")
    @PostMapping
    public ResponseEntity<String> incluir(@RequestBody T item){
        service.incluir(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
    }
    
    @Operation(summary = "Alterar")
    @PutMapping
    public ResponseEntity<String> alterar(@RequestBody T item){
        service.alterar(item);
        return ResponseEntity.status(HttpStatus.OK).body(Constantes.MSG_ALTERACAO_SUCESSO);
    }

    @Operation(summary = "Excluir")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id){

		if(service.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_NOT_FOUND);
    }
}