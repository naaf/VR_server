package dao;

import java.util.List;
import entity.Message;
import entity.User;
import play.db.jpa.JPA;

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
