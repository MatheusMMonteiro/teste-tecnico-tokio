package br.com.tokiomarine.seguradora.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.dto.client.ClientCreateDTO;
import br.com.tokiomarine.seguradora.model.Client;
import br.com.tokiomarine.seguradora.service.ClientService;


@RestController
@RequestMapping("/v1/client")
public class ClientController {

	private final ClientService service;

	public ClientController(ClientService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Client>> list (){
		return ResponseEntity.ok(service.list());
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid ClientCreateDTO dto){
		return service.create(dto).map(resp ->
		ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente já cadastrado!"));
	}

	@PutMapping
	public ResponseEntity<Client> update(@RequestBody @Valid Client dto){
		return service.update(dto).map(resp ->
		ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
	 	boolean isDeleted = service.delete(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
	}


}
