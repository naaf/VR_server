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
import dao.UtilisateurDao;
import entity.Contact;
import entity.User;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Users extends Controller
{

  @Transactional
  public static Result add()
  {
    final Form<User> categoryForm = play.data.Form.form(User.class).bindFromRequest();

    final User category = categoryForm.get();
    UtilisateurDao dao = new UtilisateurDao();
    dao.save(category);
    return ok(toJson("Ajouté"));
  }
  
  @Transactional
  public static Result authentification()
  {
    final Form<User> categoryForm = play.data.Form.form(User.class).bindFromRequest();

    final User category = categoryForm.get();
    UtilisateurDao dao = new UtilisateurDao();
    boolean response = dao.authentification(category.getEmail(), category.getPassword());
    if(response)
      return ok(toJson( category.getEmail() + " est connecté"));
    return ok(toJson("error " + category.getEmail() + " non inscrit"));
  }

  @play.db.jpa.Transactional
  public static Result getContacts()
  {
    UtilisateurDao countryDao = new UtilisateurDao();

    List<User> listContacts = countryDao.findAll();
    List<Contact> contacts = new ArrayList<Contact>();
    for(User s : listContacts){
      contacts.add(new Contact(s.getFirstName(), s.getEmail()));
    }
    Map<String, List<Contact>> data = new HashMap<String, List<Contact>>();
    data.put("contacts", contacts);
    return ok(toJson(data));
  }

}
