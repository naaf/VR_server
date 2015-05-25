package controllers;

import static play.libs.Json.toJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import dao.ActualiteDao;
import dao.DepotDao;
import dao.UtilisateurDao;
import entity.Depot;
import entity.FilActualite;
import entity.User;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Depots extends Controller
{
  @Transactional
  public static void add()
  {
    final Form<Depot> categoryForm = play.data.Form.form(Depot.class).bindFromRequest();

    final Depot category = categoryForm.get();
    DepotDao dao = new DepotDao();
    dao.save(category);
  }

  @play.db.jpa.Transactional
  public static Result getAll()
  {
    DepotDao countryDao = new DepotDao();

    List<Depot> listContacts = countryDao.findAll();
  
    Map<String, List<Depot>> data = new HashMap<String, List<Depot>>();
    data.put("depots", listContacts);
    return ok(toJson(data));
  }

}
