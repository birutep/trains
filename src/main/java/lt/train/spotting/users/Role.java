package lt.train.spotting.users;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private Long id;
	
	@Column (name="ROLE_NAME")
	private String roleName;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<User> users; 
	

	public Role() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}

	

	
}