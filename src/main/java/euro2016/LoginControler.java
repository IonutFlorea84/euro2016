/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euro2016;

import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gabi
 */
@Controller
public class LoginControler {
    @RequestMapping ("/")
    public String goLogin(){
        return "login_jsp";
    }
    
@RequestMapping ("/login")
    public ModelAndView goHome(String action, String user_id, String password, HttpSession session) throws InstantiationException, IllegalAccessException, SQLException{
        ModelAndView mv = new ModelAndView("login_jsp");
        DB_connection conn = new DB_connection();
        conn.makeConnection();
        if (action.equals("Login")) {
            if (conn.checkUser(user_id, password)) {
                session.setAttribute("user_id", user_id);
                mv.addObject("message1", "Welcome and have fun, "+ user_id);
                mv.setViewName("home_page");
            } else { 
                  mv.addObject("message", "User or password wrong, please check");
                  mv.setViewName("login_jsp");
                    }
                
        } else if (action.equals("Register")){
            
            mv.setViewName("register");
             
        }
        return mv;
    }
    @RequestMapping ("/register")
    public ModelAndView newRegister(Users user, HttpSession session) throws InstantiationException, IllegalAccessException, SQLException{
        ModelAndView mv = new ModelAndView("confirm");
        DB_connection conn = new DB_connection();
        conn.makeConnection();
         if (!conn.checkUser_id(user.getUser_id())) { 
             user.setPassword("0000");
             conn.addUserToDB(user);
             session.setAttribute("user", user);
             session.setAttribute("user_id", user.getUser_id());              
                                
                
             mv.addObject("message3", "Welcome "+ user.getName() + ", have fun!");
                                
                
            mv.addObject("message2", "Welcome "+ user.getName() + ", please insert your confirm code");
         
            
            
       
             
        
    }
  return mv;
}
  @RequestMapping ("/confirm")
    public ModelAndView Confirm(String passwordMail, HttpSession session, String password1, String password2) throws InstantiationException, IllegalAccessException, SQLException{
        ModelAndView mv = new ModelAndView("login_jsp");
        String user_id= (String)session.getAttribute("user_id");
        Users user= (Users)session.getAttribute("user");
        if (passwordMail.equals("0000")) {
             DB_connection conn = new DB_connection();
             conn.makeConnection();
                          
                                
             if (password1.equals(password2)) { 
                 
             user.setPassword(password2);
             conn.updateUser(user);
             session.invalidate();
             }
             else mv.addObject("message3", "Welcome "+ user_id + ", please check your passw");
        }
            
       
             
        
    
  return mv;
}  
  
}

    
