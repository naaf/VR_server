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
import dao.ActualiteDao;
import dao.DepotDao;
import entity.FilActualite;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Actualites extends Controller
{
  @Transactional
  public static Result add()
  {
    final Form<FilActualite> categoryForm = play.data.Form.form(FilActualite.class).bindFromRequest();
    Map<String, Object> data = new HashMap<String, Object>();
    final FilActualite category = categoryForm.get();
    ActualiteDao dao = new ActualiteDao();
    dao.save(category);
    data.put("status", Boolean.TRUE);
    return ok(toJson(data));
  }

  @Transactional
  public static Result getAll(Integer id)
  {
    ActualiteDao actualiteDao = new ActualiteDao();

    List<FilActualite> listContacts = actualiteDao.findAll(id);
  
    Map<String, List<FilActualite>> data = new HashMap<String, List<FilActualite>>();
    data.put("actualites", listContacts);
    return ok(toJson(data));
  }
  
  @play.db.jpa.Transactional
  public static Result delete(Integer id)
  {
    Map<String, Object> data = new HashMap<String, Object>();
    ActualiteDao actualiteDao = new ActualiteDao();
    actualiteDao.delete(actualiteDao.findById(id));
    data.put("status", Boolean.TRUE);
    return ok(toJson(data));
  }
 
}
