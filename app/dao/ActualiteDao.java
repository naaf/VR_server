package dao;

import java.util.List;
import play.db.jpa.JPA;
import entity.Depot;
import entity.FilActualite;

public class ActualiteDao
{
  public FilActualite findById(Integer id) {
    return JPA.em().find(FilActualite.class, id);
  }
  
  public List<FilActualite> findAll(Integer residence)
  {
    List<FilActualite> l = JPA.em().createQuery("select e from FilActualite e where e.residenceId = :valeur").setParameter("valeur",residence).getResultList();
  
    return l;
  }

  
  public void save(FilActualite c) {
    JPA.em().persist(c);
  }
  
  



}
