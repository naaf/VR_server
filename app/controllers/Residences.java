package controllers;

import static play.libs.Json.toJson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import dao.ResidenceDao;
import entity.Residence;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Residences extends Controller
{
  @Transactional
  public static Result add()
  {
    final Form<Residence> categoryForm = play.data.Form.form(Residence.class).bindFromRequest();

    final Residence category = categoryForm.get();
    ResidenceDao dao = new ResidenceDao();
    dao.save(category);
    return ok(toJson("Ok"));
  }

  @Transactional
  public static Result getAll()
  {
    ResidenceDao countryDao = new ResidenceDao();

    List<Residence> listResidences = countryDao.findAll();
  
    Map<String, List<Residence>> data = new HashMap<String, List<Residence>>();
    data.put("residences", listResidences);
    return ok(toJson(data));
  }
 
}
