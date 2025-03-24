package br.com.tokiomarine.seguradora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokiomarine.seguradora.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByEmail(String email);
	
	Optional<Client> findByEmailAndIdNot(String email, Long id);
}
