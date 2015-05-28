package controllers;

import static play.libs.Json.toJson;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import dao.MessageDao;
import entity.Message;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Messages extends Controller
{

  @Transactional
  public static Result add()
  {
    final Form<Message> categoryForm = play.data.Form.form(Message.class).bindFromRequest();
    Map<String, Object> data = new HashMap<String, Object>();
    final Message category = categoryForm.get();
    category.setCreateDate(new Date());
    MessageDao dao = new MessageDao();
    dao.save(category);
    data.put("status", Boolean.TRUE);
    return ok(toJson(data));
  }

  @play.db.jpa.Transactional
  public static Result getAll(Integer id)
  {
    MessageDao messageDao = new MessageDao();

    List<Message> listMessages = messageDao.findAll(id);
  
    Map<String, List<Message>> data = new HashMap<String, List<Message>>();
    data.put("messages", listMessages);
    return ok(toJson(data));
  }
  
  @play.db.jpa.Transactional
  public static Result delete(Integer id)
  {
    Map<String, Object> data = new HashMap<String, Object>();
    MessageDao messageDao = new MessageDao();
    messageDao.delete(messageDao.findById(id));
    data.put("status", Boolean.TRUE);
    return ok(toJson(data));
  }
  
  

}
