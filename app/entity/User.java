package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 */

@Entity
@Table(name = "utilisateur")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "surname", nullable = false, length = 64)
	private String lastName;

	@Column(name = "name", nullable = false, length = 64)
	private String firstName;

	@Column(name = "email", nullable = false, length = 128)
	private String email;

	@Column(name = "password", nullable = false, length = 256)
	private String password;



	@Column(name = "role", nullable = false, length = 32)
	@Enumerated(EnumType.STRING)
	private RoleEnum roleUser;
	
	@Column(name = "type_habitant", nullable = true, length = 32)
  @Enumerated(EnumType.STRING)
  private UserEnum typeUser;
	
	@Column(name = "residence_id", nullable = true)
	private Integer residenceId;
	
	public User()
  {
    // TODO Auto-generated constructor stub
  }

	
  public User(String lastName, String firstName, String email, String password, RoleEnum roleUser, UserEnum typeUser,
      Integer residenceId)
  {
    super();
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.password = password;
    this.roleUser = roleUser;
    this.typeUser = typeUser;
    this.residenceId = residenceId;
  }


  public Integer getResidenceId()
  {
    return residenceId;
  }


  public void setResidenceId(Integer residenceId)
  {
    this.residenceId = residenceId;
  }





  @Override
  public String toString()
  {
    return "User [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
        + ", password=" + password + ", roleUser=" + roleUser + ", typeUser=" + typeUser + ", residenceId="
        + residenceId + "]";
  }


  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public RoleEnum getRoleUser()
  {
    return roleUser;
  }

  public void setRoleUser(RoleEnum roleUser)
  {
    this.roleUser = roleUser;
  }

  public UserEnum getTypeUser()
  {
    return typeUser;
  }

  public void setTypeUser(UserEnum typeUser)
  {
    this.typeUser = typeUser;
  }


	
}