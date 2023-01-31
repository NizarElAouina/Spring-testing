package com.example.AVAProject.model;

import java.sql.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "Animal", uniqueConstraints = @UniqueConstraint(columnNames = "idAnimal"))
public class Animal {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int idAnimal;
	private String espece;
	private String race;
	private Date dateNaissance;
	private String typeAbonnement;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idClient", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client client;
	
	public Animal() {
		
	}
	
	public Animal(String espece, String race, Date dateNaissance, String typeAbonnement) {
		super();
		this.espece = espece;
		this.race = race;
		this.dateNaissance = dateNaissance;
		this.typeAbonnement = typeAbonnement;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getTypeAbonnement() {
		return typeAbonnement;
	}
	public void setTypeAbonnement(String typeAbonnement) {
		this.typeAbonnement = typeAbonnement;
	}
	
}
