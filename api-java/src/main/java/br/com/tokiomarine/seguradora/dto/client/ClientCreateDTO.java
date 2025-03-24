package br.com.tokiomarine.seguradora.dto.client;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClientCreateDTO {

	@NotBlank(message = "O nome é obrigatório!")
    private String firstName;
	
	private String lastName;

    @Email(message = "E-mail inválido!")
    @NotBlank(message = "O e-mail é obrigatório!")
    private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
}
