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
  
  public boolean authentification(String email, String password){
    String req = "select user from User user where user.email = :valeur1 and user.password = :valeur2";
    List<User> l =   JPA.em().createQuery(req).setParameter("valeur1",email).setParameter("valeur2", password).getResultList();
    if( l.size() == 1)
      return true;
    return false;
  }
  




}
