package entity;

public class Identifiant
{
  private  int idUser;
  private int idResidence;
  private RoleEnum role;
  public Identifiant()
  {
    // TODO Auto-generated constructor stub
  }
  public int getIdUser()
  {
    return idUser;
  }
  public void setIdUser(int idUser)
  {
    this.idUser = idUser;
  }
  public int getIdResidence()
  {
    return idResidence;
  }
  public void setIdResidence(int idResidence)
  {
    this.idResidence = idResidence;
  }
  public RoleEnum getRole()
  {
    return role;
  }
  public void setRole(RoleEnum role)
  {
    this.role = role;
  }
  @Override
  public String toString()
  {
    return "Identifiant [idUser=" + idUser + ", idResidence=" + idResidence + ", role=" + role + "]";
  }
  
  
  
}
