package dao;

import java.util.List;
import play.db.jpa.JPA;
import entity.User;

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
  public void save(User c) {
    JPA.em().persist(c);
  }




}
