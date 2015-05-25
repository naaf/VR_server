package entity;

public class Contact
{
  private String nom;
  private String email;
  private String mobile;
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
  
}
