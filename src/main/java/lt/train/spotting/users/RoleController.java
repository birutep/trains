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
public class RoleController {
	
	@Autowired
	RoleService roleServ;
	
	public RoleController() {}
	
	@RequestMapping(method=RequestMethod.GET, value="/roles")
	@ApiOperation(value="Get all roles")
	public @ResponseBody List<Role> getRoles(){
		return roleServ.getAllRoles();
	}
	
	@RequestMapping(method=RequestMethod.GET, path= "/roles/{roleId}")
	@ApiOperation(value="Get role by ID")
	public @ResponseBody Role findRoleById(@PathVariable Long roleId) {
		return roleServ.getRoleById(roleId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/roles")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create role")
	public @ResponseBody void addRole(@RequestBody Role role) {
		roleServ.addRole(role);
	}
		
	@RequestMapping(path= "/roles/{roleId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete role")
	public @ResponseBody void deleteRole(@PathVariable Long roleId) {
		roleServ.deleteRole(roleId);
	}
	
	
}
