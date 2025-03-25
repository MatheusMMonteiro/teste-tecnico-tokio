package br.com.tokiomarine.seguradora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.dto.address.AddressCreateDTO;
import br.com.tokiomarine.seguradora.model.Address;
import br.com.tokiomarine.seguradora.model.Client;
import br.com.tokiomarine.seguradora.repository.AddressRepository;
import br.com.tokiomarine.seguradora.repository.ClientRepository;

@Service
public class AddressService {

	private final AddressRepository repository;
	private final ClientRepository clientRepository;

	public AddressService(AddressRepository repository, ClientRepository clientRepository) {
		this.repository = repository;
		this.clientRepository = clientRepository;
	}


	public List<Address> list(){
		return repository.findAll();
	}

	public List<Address> listById(Long id){
		return repository.findByCreatedById(id);
	}

	public Optional<Object> create(AddressCreateDTO dto) {
		
		Optional<Client> clientOptional = clientRepository.findById(dto.getClientId());
	    if (!clientOptional.isPresent()) {
	        throw new BadRequestException("Cliente com id " + dto.getClientId() + " não encontrado.");
	    }

		Address data = new Address();

		data.setAddress(dto.getAddress());
		data.setNumber(dto.getNumber());
		data.setComplement(dto.getComplement());
		data.setPostalCode(dto.getPostalCode());
		data.setCity(dto.getCity());
		data.setState(dto.getState());
		data.setCountry(dto.getCountry());
		data.setCreatedBy(clientOptional.get());

		return Optional.ofNullable(repository.save(data)); 
	}
	
	public Optional<Address> update(Address dto){
		return repository.findById(dto.getId()).map(resp -> {
			resp.setAddress(dto.getAddress());
			resp.setNumber(dto.getNumber());
			resp.setComplement(dto.getComplement());
			resp.setPostalCode(dto.getPostalCode());
			resp.setCity(dto.getCity());
			resp.setState(dto.getState());
			resp.setCountry(dto.getCountry());
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
