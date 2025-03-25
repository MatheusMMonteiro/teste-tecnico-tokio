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

import br.com.tokiomarine.seguradora.dto.ViaCepResponseDTO;
import br.com.tokiomarine.seguradora.dto.address.AddressCreateDTO;
import br.com.tokiomarine.seguradora.model.Address;
import br.com.tokiomarine.seguradora.service.AddressService;
import br.com.tokiomarine.seguradora.service.ViaCepService;

@RestController
@RequestMapping("/v1/address")
public class AddressController {

	private final AddressService service;
	private final ViaCepService viaCepService;

	public AddressController(AddressService service, ViaCepService viaCepService) {
		this.service = service;
		this.viaCepService = viaCepService;
	}

	@GetMapping("/cep/{cep}")
    public ViaCepResponseDTO consultarCep(@PathVariable String cep) {
        return viaCepService.consultarCep(cep);
    }
	
	
	@GetMapping
	public ResponseEntity<List<Address>> list (){
		return ResponseEntity.ok(service.list());
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid AddressCreateDTO dto){
		return service.create(dto).map(resp ->
		ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).body("Addresse já cadastrado!"));
	}
	
	@PutMapping
	public ResponseEntity<Address> update(@RequestBody @Valid Address dto){
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
