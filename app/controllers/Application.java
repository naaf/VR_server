package controllers;

import java.util.Arrays;
import java.util.List;
import dao.UtilisateurDao;
import entity.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import play.Logger;
import play.db.jpa.Transactional;

public class Application extends Controller
{

  @Transactional
  public static Result index()
  {
    UtilisateurDao dao = new UtilisateurDao();
    User user = dao.findById(1);
    List<User> l = dao.findAll();
    return ok(index.render("Your new application is ready." + l));
  }

}
