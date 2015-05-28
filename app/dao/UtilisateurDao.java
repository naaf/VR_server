package dao;

import java.util.List;
import play.Logger;
import play.db.jpa.JPA;
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
  public void save(User c) {
    JPA.em().persist(c);
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
  




}
