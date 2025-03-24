package br.com.tokiomarine.seguradora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
	List<Address> findByCreatedById(Long id);
}
