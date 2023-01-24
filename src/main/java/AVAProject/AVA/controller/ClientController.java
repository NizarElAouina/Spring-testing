package AVAProject.AVA.controller;


//import java.security.Principal;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.becoder.model.UserDtls;
//import com.becoder.repository.UserRepository;

@Controller
@RequestMapping("/client")
public class ClientController {

	//@Autowired
	//private ClientRepository userRepo;

	//@ModelAttribute
	//private void userDetails(Model m, Principal p) {
	//	String email = p.getName();
	//	UserDtls user = userRepo.findByEmail(email);
	//
	//	m.addAttribute("user", user);

	//}

	@GetMapping("/")
	public String home() {
		return "client/home";
	}

}