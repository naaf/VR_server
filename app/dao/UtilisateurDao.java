package dao;

import java.util.List;
import entity.User;
import play.db.jpa.JPA;

public class UtilisateurDao
{
  public User findById(Integer id) {
    return JPA.em().find(User.class, id);
  }
  
  public List<User> findAll()
  {
    List<User> l = JPA.em().createQuery("FROM User E").getResultList();
  
    return l;
  }



}
