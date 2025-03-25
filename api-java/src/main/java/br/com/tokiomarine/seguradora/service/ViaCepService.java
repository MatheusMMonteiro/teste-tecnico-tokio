package br.com.tokiomarine.seguradora.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tokiomarine.seguradora.dto.ViaCepResponseDTO;

@FeignClient(name = "viaCepClient", url = "https://viacep.com.br/ws")
public interface ViaCepService {
	 
	@GetMapping("/{cep}/json/")
	ViaCepResponseDTO consultarCep(@PathVariable("cep") String cep);
}
