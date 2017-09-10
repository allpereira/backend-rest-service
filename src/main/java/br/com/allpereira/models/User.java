package br.com.allpereira.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date registryDate;
	private String name;
	private String login;
	private String mail;
	private String password;
	private String federalID;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

}
