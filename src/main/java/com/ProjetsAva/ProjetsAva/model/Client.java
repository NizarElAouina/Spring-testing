package com.example.AVAProject.model;

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
@Table(name =  "client", uniqueConstraints = @UniqueConstraint(columnNames = "idClient"))
public class Client {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int idClient;
	private String email;
	private String CIN;
	private String motPasse;
	private String nom;
	private String prenom;
	
	public Client() {
		
	}
	
	public Client(String email, String cIN, String motPasse, String nom, String prenom) {
		super();
		this.email = email;
		CIN = cIN;
		this.motPasse = motPasse;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

}
