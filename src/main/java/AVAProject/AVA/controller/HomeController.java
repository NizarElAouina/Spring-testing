package AVAProject.AVA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import AVAProject.AVA.model.Client;
import AVAProject.AVA.service.ClientService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/createClient")
	public String createClient(@ModelAttribute Client client, HttpSession session) {
		boolean f = clientService.checkEmail(client.getEmail());
		if(f) {
			session.setAttribute("msg","Client déja existant, veuillez vous connecter ou changez de coordonnées");
		}else {
			//System.out.println(client);
		Client clientDtls = clientService.createClient(client);
		if(clientDtls != null) {
			session.setAttribute("msg","Inscription réussie, veuillez désomrais vous connecter");
		}else {
			session.setAttribute("msg","Erreur du serveur");
		}
		//clientService.save(client);
		
		}
		
		return "redirect:/register";
	}
	

}