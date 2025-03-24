package br.com.tokiomarine.seguradora.dto.address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AddressCreateDTO {

	@NotBlank
	private String address;
	
	@NotBlank
	private String number;
	
	private String complement;
	
	@Pattern(regexp = "\\d{8}|\\d{5}-\\d{3}", message = "O CEP deve ter 8 dígitos ou estar no formato XXXXX-XXX")
	private String postalCode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private Long clientId;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	
}
