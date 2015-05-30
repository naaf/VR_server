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
import dao.DepotDao;
import dao.MessageDao;
import entity.Depot;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Depots extends Controller
{
  @Transactional
  public static Result add()
  {
    final Form<Depot> categoryForm = play.data.Form.form(Depot.class).bindFromRequest();
    Map<String, Object> data = new HashMap<String, Object>();
    final Depot category = categoryForm.get();
    DepotDao dao = new DepotDao();
    dao.save(category);
    data.put("status", Boolean.TRUE);
    return ok(toJson(data));
  }

  @play.db.jpa.Transactional
  public static Result getAll(Integer id)
  {
    DepotDao depotDao = new DepotDao();
    Map<String, Object> data = new HashMap<String, Object>();
    List<Depot> listContacts = depotDao.findAll(id);
    data.put("status", Boolean.TRUE);
    data.put("depots", listContacts);
    return ok(toJson(data));
  }
  
  @play.db.jpa.Transactional
  public static Result delete(Integer id)
  {
    Map<String, Object> data = new HashMap<String, Object>();
    DepotDao depotDao = new DepotDao();
    depotDao.delete(depotDao.findById(id));
    data.put("status", Boolean.TRUE);
    return ok(toJson(data));
  }

}
