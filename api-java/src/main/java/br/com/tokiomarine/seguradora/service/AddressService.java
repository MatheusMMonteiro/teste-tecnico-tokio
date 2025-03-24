package br.com.tokiomarine.seguradora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.dto.address.AddressCreateDTO;
import br.com.tokiomarine.seguradora.model.Address;
import br.com.tokiomarine.seguradora.model.Client;
import br.com.tokiomarine.seguradora.repository.AddressRepository;

@Service
public class AddressService {

	private final AddressRepository repository;

	public AddressService(AddressRepository repository) {
		this.repository = repository;
	}


	public List<Address> list(){
		return repository.findAll();
	}

	public List<Address> listById(Long id){
		return repository.findByCreatedById(id);
	}

	public Optional<Object> createAddress(AddressCreateDTO dto) {

		Address data = new Address();

		data.setAddress(dto.getAddress());
		data.setNumber(dto.getNumber());
		data.setComplement(dto.getComplement());
		data.setPostalCode(dto.getPostalCode());
		data.setCity(dto.getCity());
		data.setState(dto.getState());
		data.setCountry(dto.getCountry());
		data.setCreatedBy(new Client(dto.getClientId()));

		return Optional.ofNullable(repository.save(data));
	}
}
