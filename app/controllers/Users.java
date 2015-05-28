package controllers;

import static play.libs.Json.toJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xerces.impl.dv.dtd.IDDatatypeValidator;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import dao.ResidenceDao;
import dao.UtilisateurDao;
import entity.Contact;
import entity.Identifiant;
import entity.Inscription;
import entity.Residence;
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
    final Form<Inscription> categoryForm = play.data.Form.form(Inscription.class).bindFromRequest();
    Map<String,Object> data = new HashMap<String, Object>();
    final Inscription c = categoryForm.get();
    ResidenceDao daoRes = new ResidenceDao();
    Residence r = new Residence();
    
    r.setCity(c.getCity());
    r.setNumber(c.getNumber());
    r.setStreetName(c.getStreetName());
    r.setZipCode(c.getZipCode());
    
    Residence response = daoRes.findByAdress(r);
    Integer id = null;
    if( response == null){
      id = daoRes.save(r);
    }else{
      id = response.getId();
    }
    
    UtilisateurDao dao = new UtilisateurDao();
    
    User s = new User();
    User s1 = dao.authentification(c.getEmail(), c.getPassword());
    if( s1 != null){
      data.put("status", Boolean.FALSE);
      return ok(toJson(data));
    }
   
    s.setEmail(c.getEmail());
    s.setFirstName(c.getFirstName());
    s.setLastName(c.getLastName());
    s.setPassword(c.getPassword());
    s.setRoleUser(c.getRoleUser());
    s.setTypeUser(c.getTypeUser());
   
    s.setResidenceId(id);
    dao.save(s);
    data.put("status", Boolean.TRUE);
    return ok(toJson(data));
  }

  @Transactional
  public static Result authentification()
  {
    final Form<User> categoryForm = play.data.Form.form(User.class).bindFromRequest();
    Map<String,Object> data = new HashMap<String, Object>();
    final User category = categoryForm.get();
    UtilisateurDao dao = new UtilisateurDao();
    User response = dao.authentification(category.getEmail(), category.getPassword());
    if (response != null){
      
      Identifiant ident = new Identifiant();
      ident.setIdResidence(response.getResidenceId());
      ident.setIdUser(response.getId());
      data.put("status", Boolean.TRUE);
      data.put("user", ident);
      return ok(toJson(data));
    }
    data.put("status", Boolean.FALSE);
    return ok(toJson(data));
  }

  @play.db.jpa.Transactional
  public static Result getContacts(Integer id)
  {
    UtilisateurDao countryDao = new UtilisateurDao();
    Map<String,Object> data = new HashMap<String, Object>();
    List<User> listContacts = countryDao.findAll(id);
    List<Contact> contacts = new ArrayList<Contact>();
    for (User s : listContacts)
    {
      contacts.add(new Contact(s.getFirstName(), s.getEmail(), s.getId(), s.getResidenceId()));
    }
    //Map<String, List<Contact>> data = new HashMap<String, List<Contact>>();
    data.put("status", Boolean.TRUE);
    data.put("contacts", contacts);
    return ok(toJson(data));
  }

  @play.db.jpa.Transactional
  public static Result getContact(Integer id)
  {
    UtilisateurDao countryDao = new UtilisateurDao();
    Map<String,Object> data = new HashMap<String, Object>();
    User s = countryDao.findById(id);
    Contact c = new Contact(s.getFirstName(), s.getEmail(), s.getId(), s.getResidenceId());
   // Map<String, Contact> data = new HashMap<String, Contact>();
    data.put("status", Boolean.TRUE);
    data.put("contact", c);
    return ok(toJson(data));
  }

}
