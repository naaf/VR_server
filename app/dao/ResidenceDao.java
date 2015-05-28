package dao;

import java.util.List;
import play.Logger;
import play.db.jpa.JPA;
import entity.Residence;

public class ResidenceDao
{
  public Residence findById(Integer id)
  {
    return JPA.em().find(Residence.class, id);
  }

  public List<Residence> findAll()
  {
    List<Residence> l = JPA.em().createQuery("FROM Residence E").getResultList();

    return l;
  }

  public int save(Residence c)
  {
    if (c != null)
    {
      JPA.em().persist(c);
      JPA.em().flush();
      Logger.info("insertion de la résidence :" + c.toString());
      return c.getId();
    }
    return 0;
  }

  public Residence findByAdress(Residence r)
  {

    String req = "select e from Residence e where e.number = :valeur and" + " e.streetName = :valeur1 and"
        + " e.city = :valeur2 and" + " e.zipCode = :valeur3";
    List<Residence> l = JPA.em().createQuery(req).setParameter("valeur", r.getNumber())
        .setParameter("valeur1", r.getStreetName()).setParameter("valeur2", r.getCity())
        .setParameter("valeur3", r.getZipCode()).getResultList();
    if (l != null && l.size() == 0)
    {
      return null;
    }

    return l.get(0);

  }

}
