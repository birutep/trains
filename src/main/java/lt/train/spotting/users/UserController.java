package lt.train.spotting.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.train.spotting.vagons.VagonCreate;

@RestController
public class UserController {

	@Autowired
	UserService userServ;
	
	@Autowired
	RoleService roleServ;
	
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
	
	@RequestMapping(method=RequestMethod.POST,value="/users/{roleId}")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create user")
	//padariau pathvariable,nes su requestbody mete serializable error... Cia gal reikes pataisyti daabr projekta.
	public @ResponseBody void addUser(@PathVariable Long roleId, @RequestBody User user) {
		user.setRole(roleServ.getRoleById(roleId));
		userServ.addUser(roleId, user);
	}
		
	@RequestMapping(path= "/user/{userId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete user")
	public @ResponseBody void deleteUser(@PathVariable Long userId) {
		userServ.deleteUser(userId);
	}
	
	
}
