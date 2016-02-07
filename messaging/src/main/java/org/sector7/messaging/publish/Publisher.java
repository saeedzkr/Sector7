package org.sector7.messaging.publish;

import org.eclipse.paho.client.mqttv3.*;
import org.sector7.messaging.util.Utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by sector7 on 2/4/16.
 */
public class Publisher {

    public static final String TOPIC_MSG = "home/MSG";


    private MqttClient _MqttClient;


    public static final String BROKER_URL = "tcp://192.168.1.6:1883";
    public static final String TOPIC_REPORT = "sector7/REPORTMSG";


    private MqttClient client;

    private static Publisher _Instance;


    private Publisher() {

        //We have to generate a unique Client id.
        String clientId = Utils.getMacAddress() + "-pub";


        try {

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            client = new MqttClient(BROKER_URL, clientId);
            client.connect(options);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Publisher getInstance() {
        if (_Instance != null)
            return _Instance;
        else
            _Instance = new Publisher();
            return _Instance;
    }

    private void start(String reciver, String msg) {

        try {

            //options.setWill(client.getTopic("home/LWT"), "This is Test".getBytes(), 0, false);

            String subscriber = TOPIC_REPORT + "/" + reciver;
            System.out.println(subscriber);
            final MqttTopic temperatureTopic = client.getTopic(subscriber);

            temperatureTopic.publish(new MqttMessage(msg.getBytes()));

            System.out.println("Published data. Topic: " + temperatureTopic.getName() + "  Message: " + msg);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void send(String reciver, String msg) {

        start(reciver, msg);

    }

}
