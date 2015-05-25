package dao;

import java.util.List;
import entity.FilActualite;
import entity.Message;
import play.db.jpa.JPA;

public class ActualiteDao
{
  public FilActualite findById(Integer id) {
    return JPA.em().find(FilActualite.class, id);
  }
  
  public List<FilActualite> findAll()
  {
    List<FilActualite> l = JPA.em().createQuery("FROM FilActualite E").getResultList();
  
    return l;
  }
  
  public void save(FilActualite c) {
    JPA.em().persist(c);
  }



}
