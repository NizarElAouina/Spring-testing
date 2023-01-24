package AVAProject.AVA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import AVAProject.AVA.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	public boolean existsByEmail(String email);
}
