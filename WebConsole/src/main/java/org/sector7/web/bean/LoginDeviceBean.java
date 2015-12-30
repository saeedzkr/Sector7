package org.sector7.web.bean;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.sector7.model.dao.DeviceDAOImpl;
import org.sector7.model.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by sector7 on 12/29/15.
 */
@ManagedBean
@SessionScoped
public class LoginDeviceBean implements Serializable {
    Logger logger = Logger.getLogger("callLogger");


    private String userName;
    private String password;
    private String deviceName;
    private String deviceIP;
    private String deviceKey;
    private String phoneNumber;
    private long userID;

    @Autowired
    private DeviceDAOImpl deviceDAOImpl;


    public LoginDeviceBean() {
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceIP() {
        return deviceIP;
    }

    public void setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }




    public String loginDevice() {
        try {

            System.out.println("====================================");
            Device device = getDeviceDAOImpl().validateDevice();
            System.out.println("====================================");
            if (device != null) {

                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                String msg = "device name = " + device.getDeviceName() + "is log in";
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("device", session);

                logger.log(Level.INFO, msg);
                return ("pages/DeviceInfo.xhtml");
            } else {
                return "login.xhtml";
            }
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(" Login error is = " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage("loginButton", message);
            //loginButton
            ex.printStackTrace();
            logger.log(Level.ERROR, ex.getMessage());
            return "login.xhtml";
        }

    }


    public void setDeviceDAOImpl(DeviceDAOImpl deviceDAOImpl) {
        this.deviceDAOImpl = deviceDAOImpl;
    }

    public DeviceDAOImpl getDeviceDAOImpl() {
        return deviceDAOImpl;
    }
}