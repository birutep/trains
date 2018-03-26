package lt.train.spotting.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.train.spotting.users.User;
import lt.train.spotting.users.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRep;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRep.findByName(name);
		
		optionalUser
			.orElseThrow(()-> new UsernameNotFoundException("User with this name not found."));
		
		return optionalUser.map(CustomUserDetails::new).get();			
	}
	
}
