package dao;

import java.util.List;
import play.db.jpa.JPA;
import entity.Message;

public class MessageDao
{
  public Message findById(Integer id) {
    return JPA.em().find(Message.class, id);
  }
  
  public List<Message> findAll(Integer to)
  {
    List<Message> l = JPA.em().createQuery("select e from Message e where e.to = :valeur").setParameter("valeur",to).getResultList();
    
    return l;
  }
  
  public void save(Message c) {
    if (c != null)
    {
      JPA.em().persist(c);
    }
  }

  public void delete(Message c)
  {
    if (c != null)
    {
      JPA.em().remove(c);
    }
    
  }
  

}
