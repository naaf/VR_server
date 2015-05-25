package dao;

import java.util.List;
import play.db.jpa.JPA;
import entity.Message;

public class MessageDao
{
  public Message findById(Integer id) {
    return JPA.em().find(Message.class, id);
  }
  
  public List<Message> findAll()
  {
    List<Message> l = JPA.em().createQuery("FROM Message E").getResultList();
  
    return l;
  }
  
  public void save(Message c) {
    JPA.em().persist(c);
  }




}
