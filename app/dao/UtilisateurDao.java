package dao;

import java.util.List;
import play.Logger;
import play.db.jpa.JPA;
import entity.RoleEnum;
import entity.User;

public class UtilisateurDao
{
  public User findById(Integer id) {
    return JPA.em().find(User.class, id);
  }
  
  public List<User> findAll(Integer id)
  {
    List<User> l = JPA.em().createQuery("select e from User e where e.residenceId = :valeur").setParameter("valeur",id).getResultList();
  
    return l;
  }
  public int save(User c) {
    if (c != null)
    {
      JPA.em().persist(c);
      JPA.em().flush();
      return c.getId();
    }
    return 0;
    
  }
  
  public User findByMail(String email){
    String req = "select user from User user where user.email = :valeur1 ";
    List<User> l =   JPA.em().createQuery(req).setParameter("valeur1",email).getResultList();
    if(l != null && l.size() > 0){
      Logger.info("autentification " + l);
      return l.get(0);
    }
    return null;
  }
  
  public User authentification(String email, String password){
    String req = "select user from User user where user.email = :valeur1 and user.password = :valeur2";
    List<User> l =   JPA.em().createQuery(req).setParameter("valeur1",email).setParameter("valeur2", password).getResultList();
    if(l != null && l.size() > 0){
      Logger.info("autentification " + l);
      return l.get(0);
    }
    Logger.info(" NON autentification " + email + ", " + password);
    return null;
  }
  
  public boolean findExist(Integer id)
  {
    String req = "select e from User e where e.residenceId = :valeur and e.roleUser = :valeur1";
    List<User> l = JPA.em().createQuery(req).setParameter("valeur",id).setParameter("valeur1",RoleEnum.GERANT).getResultList();
    if(l != null && l.size() > 0){
      Logger.info("autentification " + l);
      return true;
    }
    return false;
  }
  




}
