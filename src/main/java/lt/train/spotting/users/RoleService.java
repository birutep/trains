package lt.train.spotting.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRep;
	
	@Transactional(readOnly=true)
	public List<Role> getAllRoles(){
		return roleRep.findAll();
	}
	
	@Transactional
	public Role getRoleById(Long roleID) {
		return roleRep.getOne(roleID);
	}
	
	@Transactional
	public void addRole(Role role) {
		roleRep.save(role);
	}
	
	@Transactional
	public void deleteRole(Long roleID) {
		roleRep.delete(roleRep.getOne(roleID));
	}
	
}
