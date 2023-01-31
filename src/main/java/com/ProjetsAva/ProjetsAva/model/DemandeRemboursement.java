package com.example.AVAProject.model;

import java.util.Collection;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "DemandeRemboursement", uniqueConstraints = @UniqueConstraint(columnNames = "idDemande"))
public class DemandeRemboursement {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int idDemande;
	private String Factures;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idClient", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idAnimal", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Animal animal;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "DemandeIntervention",
			joinColumns = @JoinColumn(
		            name = "idDemande", referencedColumnName = "idDemande"),
			inverseJoinColumns = @JoinColumn(
				            name = "idIntervention", referencedColumnName = "idIntervention"))
	private Collection<Intervention> intervention;

}
