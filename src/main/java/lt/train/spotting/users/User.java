package lt.train.spotting.users;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private Long id;
	
	@Column (name="NAME")
	private String name;
	
	@Column (name="PASSWORD")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable (
			name="USER_ROLE", 
			joinColumns = @JoinColumn(
					name="ROLE_ID"))
	private Set<Role> roles; // 1-Admin  2-User

	public User() {}
	
	//kazi koks keistumas - sis konstruktorius reikalingas,
	//kad suristi CustomUserDetails (extendina Useri) su Useriu
	public User(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}

	
