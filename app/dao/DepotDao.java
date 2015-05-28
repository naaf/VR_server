package dao;

import java.util.List;
import play.db.jpa.JPA;
import entity.Depot;

public class DepotDao
{
  public Depot findById(Integer id)
  {
    return JPA.em().find(Depot.class, id);
  }

  public void save(Depot c)
  {
    if (c != null)
    {
      JPA.em().persist(c);
    }
  }

  public List<Depot> findAll(Integer residence)
  {
    List<Depot> l = JPA.em().createQuery("select e from Depot e where e.residenceId = :valeur")
        .setParameter("valeur", residence).getResultList();

    return l;
  }

  public void delete(Depot c)
  {
    if (c != null)
    {
      JPA.em().remove(c);
    }

  }

}
