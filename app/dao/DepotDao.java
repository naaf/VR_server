package dao;

import java.util.List;
import entity.Depot;
import entity.FilActualite;
import play.db.jpa.JPA;

public class DepotDao
{
  public Depot findById(Integer id) {
    return JPA.em().find(Depot.class, id);
  }
  
  public List<Depot> findAll()
  {
    List<Depot> l = JPA.em().createQuery("FROM Depot E").getResultList();
  
    return l;
  }
  
  public void save(Depot c) {
    JPA.em().persist(c);
  }




}
