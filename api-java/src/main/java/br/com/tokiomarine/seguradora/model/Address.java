package br.com.tokiomarine.seguradora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "addressess")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "address", length = 250)
	private String address;
	
	@NotBlank
	@Column(name= "number", length = 20)
	private String number;
	
	@Column(name= "complement", length = 250)
	private String complement;
	
	@Column(name= "postal_code", length = 10)
	private String postalCode;
	
	@Column(name= "city", length = 250)
	private String city;
	
	@Column(name= "state", length = 250)
	private String state;
	
	@Column(name= "country", length = 250)
	private String country;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	@NotNull
	@JsonIgnoreProperties({"addresses"})
	private Client createdBy;
	
	public Address() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Client getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Client createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
}
