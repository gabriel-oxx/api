package med.voll.api.models.entities.user;

import med.voll.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuthentication implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			System.out.println("Buscando usuário pelo nome: " + username);
			UserDetails userDetails = userRepository.findByUserName(username);
			if (userDetails != null) {
				System.out.println("Usuário encontrado: " + userDetails.getUsername());
			} else {
				System.out.println("Usuário não encontrado");
			}
			return userDetails;
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

}
