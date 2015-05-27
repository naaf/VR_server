package controllers;

import static play.libs.Json.toJson;
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

    final Message category = categoryForm.get();
    MessageDao dao = new MessageDao();
    dao.save(category);
    return ok(toJson("Ajouté"));
  }

  @play.db.jpa.Transactional
  public static Result getAll()
  {
    MessageDao countryDao = new MessageDao();

    List<Message> listContacts = countryDao.findAll();
  
    Map<String, List<Message>> data = new HashMap<String, List<Message>>();
    data.put("messages", listContacts);
    return ok(toJson(data));
  }

}
