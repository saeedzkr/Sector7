package org.sector7.model.dao;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.sector7.model.entity.Device;

/**
 * Created by sector7 on 12/29/15.
 */
public class DeviceDAOImpl implements DeviceDAO {


    Logger logger = Logger.getLogger("callLogger");

    @Override
    public Device validateDevice() {
        try {
            Device device = new Device();


            String values = System.getProperty("org.sector7.security");

            String[] result = values.split(";");

            //dev001;989125763458;admin;123456;192.168.1.9
            device.setDeviceName(result[0]);
            device.setPhoneNumber(result[1]);
            device.setUsername(result[2]);
            device.setPassword(result[3]);
            device.setDeviceIP(result[4]);

            logger.log(Level.INFO, " validate DAO =" + device.toString());

            return device;
        } catch (Exception ex) {
            return null;

        }
    }
}
