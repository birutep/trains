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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lt.train.spotting.trains.Train;

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

	//Sitas buvo kai as pirmini pavyzdi buvau pasidarius, kur buvo mintis, kad vienas useris gali tureti daug roliu.
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable (
//			name="USER_ROLE", 
//			joinColumns = @JoinColumn(
//					name="ROLE_ID"))
//	private Set<Role> roles; // 1-Admin  2-User

	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	@JsonIgnore
	private Role role; // 1-Admin  2-User
		
	public User() {}
	
	//kazi koks keistumas - sis konstruktorius reikalingas,
	//kad suristi CustomUserDetails (extendina Useri) su Useriu
	public User(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.role = user.getRole();
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

	
