package br.com.tokiomarine.seguradora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.dto.client.ClientCreateDTO;
import br.com.tokiomarine.seguradora.model.Client;
import br.com.tokiomarine.seguradora.repository.ClientRepository;

@Service
public class ClientService {

	private final ClientRepository repository;

	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}

	public List<Client> list(){
		return repository.findAll();
	}

	public Optional<Object> create(ClientCreateDTO dto) {
		return repository.findByEmail(dto.getEmail()).map(resp -> {
			return Optional.empty();
		}).orElseGet(() -> {
			Client client = new Client();
			client.setFirstName(dto.getFirstName());
			client.setLastName(dto.getLastName());
			client.setEmail(dto.getEmail());
			return Optional.ofNullable(repository.save(client));
		});
	}


	public Optional<Client> update(Client dto) {
		return repository.findById(dto.getId()).map(resp -> {
			return Optional.ofNullable(repository.save(dto));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	public boolean delete(Long id) {
	    if (repository.existsById(id)) {
	        repository.deleteById(id);
	        return true;
	    }
	    return false;
	}
}
