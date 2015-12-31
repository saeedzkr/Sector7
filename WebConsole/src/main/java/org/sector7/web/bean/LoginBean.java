package org.sector7.web.bean;


import org.sector7.model.dao.UserDAOImpl;
import org.sector7.model.entity.User;
import org.sector7.services.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import org.apache.log4j.*;



/**
 * Created by s.zakipour on 11/09/2015.
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable

{

    final Logger logger = Logger.getLogger("callLogger");

    private String userName;
    private String password;

    private long userID;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String login() {
        org.sector7.model.dao.UserDAOImpl userDAO = new UserDAOImpl();
        String msg = "sombody login with user : " + userName + "and ip : " + FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        logger.log(Level.INFO, msg);
        //boolean result = UserDAO.login(uname, password);
        User user = userDAO.getUser(userName, password);
//        if (userName.equals("saeed") && password.equals("zakipour")) {
        if (user.getUserid()!=0) {
            // get Http Session and store username

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("username", userName);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("pages/main.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "pages/main.xhtml";

        } else {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
            return "login";
        }
    }

    public String logout() {
        String msg = " user : " + userName + " is loggout ";
        logger.log(Level.INFO, msg);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "logout";
    }

    public String Control() {
        UserService srv = new UserService();
        return srv.getUsers("saeed");

    }


}
