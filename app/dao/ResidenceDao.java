package dao;

import java.util.List;
import play.db.jpa.JPA;
import entity.Residence;

public class ResidenceDao
{
  public Residence findById(Integer id) {
    return JPA.em().find(Residence.class, id);
  }
  
  public List<Residence> findAll()
  {
    List<Residence> l = JPA.em().createQuery("FROM Residence E").getResultList();
  
    return l;
  }
  
  public void save(Residence c) {
    JPA.em().persist(c);
  }



}
