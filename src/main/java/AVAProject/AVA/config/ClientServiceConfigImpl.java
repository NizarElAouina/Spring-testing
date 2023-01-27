package AVAProject.AVA.config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import AVAProject.AVA.model.Client;
//import AVAProject.AVA.repository.ClientRepository;

@Service
public class ClientServiceConfigImpl implements UserDetailsService{

	@Override // to delete
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	/*

	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client client = clientRepo.findByEmail(email);
		if(client != null) {
			return new CustomClient(client);
		}

		throw new UsernameNotFoundException("Utilisateur non inscrit");
	}*/

}