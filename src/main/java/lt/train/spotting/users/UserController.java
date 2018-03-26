package lt.train.spotting.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	UserService userServ;
	
	public UserController() {}
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	@ApiOperation(value="Get all users")
	public @ResponseBody List<User> getUsers(){
		return userServ.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.GET, path= "/users/{userId}")
	@ApiOperation(value="Get user by ID")
	public @ResponseBody User findUserById(@PathVariable Long userId) {
		return userServ.getUserById(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create user")
	public @ResponseBody void addUser(@RequestBody User user) {
		userServ.addUser(user);
	}
		
	@RequestMapping(path= "/user/{userId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete user")
	public @ResponseBody void deleteUser(@PathVariable Long userId) {
		userServ.deleteUser(userId);
	}
	
	
}
