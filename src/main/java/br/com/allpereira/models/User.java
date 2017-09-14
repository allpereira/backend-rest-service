package br.com.allpereira.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Boolean enabled;
	private Date registryDate;
	private String name;
	private String mail;
	private String password;
	private String federalID;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_privileges", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	private List<Privilege> privileges;

}
