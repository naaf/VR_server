package controllers;

import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import dao.ActualiteDao;
import dao.DepotDao;
import dao.UtilisateurDao;
import entity.Depot;
import entity.FilActualite;
import entity.User;

public class Application extends Controller
{

  @Transactional
  public static Result index()
  {
    DepotDao dao = new DepotDao();
    Depot user = dao.findById(1);
//    List<User> l = dao.findAll();
    return ok(index.render("Your new application is ready." + user ));
  }
  


}
