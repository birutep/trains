package lt.train.spotting.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepository userRep;
	
	@Transactional(readOnly=true)
	public List<User> getAllUsers(){
		return userRep.findAll();
	}
	
	@Transactional
	public User getUserById(Long userID) {
		return userRep.getOne(userID);
	}
	
	@Transactional
	public void addUser(User user) {
		userRep.save(user);
	}
	
	@Transactional
	public void deleteUser(Long userID) {
		userRep.delete(userRep.getOne(userID));
	}
	
}