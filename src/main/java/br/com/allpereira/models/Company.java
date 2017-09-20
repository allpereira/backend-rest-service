package br.com.allpereira.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
@Entity
@Table(name = "companies")
public class Company implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String completeName;
	private String federalID;
	
	private String postalCode;
	private String address;
	private String complement;
	private String addressNumber;
	private String district;
	private String federalUnity;
	private String city;
	
	private String telephone1;
	private String telephone2;
	private String mail;
	

	@OneToMany(mappedBy = "company")
	@JsonBackReference(value = "users")
	private List<User> users;
}
