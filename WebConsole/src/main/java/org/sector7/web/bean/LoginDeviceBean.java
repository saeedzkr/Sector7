package org.console.bean;

import org.apache.log4j.Logger;
import org.model.dao.DeviceDAOImpl;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by sector7 on 12/29/15.
 */
@ManagedBean
@SessionScoped
public class LoginDeviceBean implements Serializable
{
    Logger logger = Logger.getLogger("callLogger");


    private String userName;
    private String password;
    private String deviceName;
    private String deviceIP;
    private String deviceKey;
    private String phoneNumber;
    private long userID;
    private DeviceDAOImpl deviceDAO;


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

    public void loginDevice()
    {


    }

    public void setDeviceDAO(DeviceDAOImpl DeviceDAO) {
        deviceDAO = DeviceDAO;
    }

    public DeviceDAOImpl getDeviceDAO() {
        return deviceDAO;
    }
}
