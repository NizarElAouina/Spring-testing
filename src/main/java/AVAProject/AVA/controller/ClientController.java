package AVAProject.AVA.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

//import java.security.Principal;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import AVAProject.AVA.model.Client;
import AVAProject.AVA.repository.ClientRepository;
import org.springframework.ui.Model;

//import com.becoder.model.UserDtls;
//import com.becoder.repository.UserRepository;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepo;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		Client client = clientRepo.findByEmail(email);
	
		m.addAttribute("client", client);

	}
	
	@GetMapping("/")
	public String home() {
		return "client/home";
	}
	
}