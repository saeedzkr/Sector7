package org.sector7.model.dao;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.sector7.model.entity.Device;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by sector7 on 12/29/15.
 */

@Repository
@Transactional
public class DeviceDAOImpl implements DeviceDAO {

    Logger logger = Logger.getLogger("callLogger");

    public DeviceDAOImpl() {

        logger.log(Level.INFO , "logger has been initialized");
        System.out.println("------------------------------" + this.getClass().getName());
    }



    @Override
    public Device validateDevice() {
//        try {
            Device device = new Device();
            System.out.println("------------------------------ 001" );

            String values = System.getProperty("org.sector7.security");
            System.out.println("------------------------------ 002" );

            String[] result = values.split(";");
            System.out.println("------------------------------ 003" );
            //dev001;989125763458;admin;123456;192.168.1.9
            device.setDeviceName(result[0]);
            device.setPhoneNumber(result[1]);
            device.setUsername(result[2]);
            device.setPassword(result[3]);
            device.setDeviceIP(result[4]);

            logger.log(Level.INFO, " validate DAO =" + device.toString());

            return device;
//        } catch (Exception ex) {
//
//            logger.log(Level.ERROR , ex.getStackTrace().toString());
//            return null;
//
//        }
    }
}
