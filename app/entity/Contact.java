package entity;

public class Contact
{
  private String nom;
  private String email;
  private String mobile;
  private Integer id;
  private Integer ResidenceId;
  public String getNom()
  {
    return nom;
  }
  public void setNom(String nom)
  {
    this.nom = nom;
  }
  public String getEmail()
  {
    return email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public String getMobile()
  {
    return mobile;
  }
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  
  public Contact()
  {
    // TODO Auto-generated constructor stub
  }
  public Contact(String nom, String email)
  {
    super();
    this.nom = nom;
    this.email = email;
  }
  public Integer getId()
  {
    return id;
  }
  public void setId(Integer id)
  {
    this.id = id;
  }
  public Integer getResidenceId()
  {
    return ResidenceId;
  }
  public void setResidenceId(Integer residenceId)
  {
    ResidenceId = residenceId;
  }
  @Override
  public String toString()
  {
    return "Contact [nom=" + nom + ", email=" + email + ", mobile=" + mobile + ", id=" + id + ", ResidenceId="
        + ResidenceId + "]";
  }
  public Contact(String nom, String email, Integer id, Integer residenceId)
  {
    super();
    this.nom = nom;
    this.email = email;
    this.id = id;
    ResidenceId = residenceId;
  }
 
  
  
  
}
