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
public class Actualites extends Controller
{

  @Transactional
  public static void add()
  {
    final Form<FilActualite> categoryForm = play.data.Form.form(FilActualite.class).bindFromRequest();

    final FilActualite category = categoryForm.get();
    ActualiteDao dao = new ActualiteDao();
    dao.save(category);
  }

  @play.db.jpa.Transactional
  public static Result getAll()
  {
    ActualiteDao countryDao = new ActualiteDao();

    List<FilActualite> listContacts = countryDao.findAll();
  
    Map<String, List<FilActualite>> data = new HashMap<String, List<FilActualite>>();
    data.put("actualites", listContacts);
    return ok(toJson(data));
  }
}
