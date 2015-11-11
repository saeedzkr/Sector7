package org.console.bean;

import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by s.zakipour on 11/09/2015.
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable

{
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
        //boolean result = UserDAO.login(uname, password);
        if (userName.equals("saeed") && password.equals("zakipour"))
        {
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

    public String logout()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "logout";
    }


}
