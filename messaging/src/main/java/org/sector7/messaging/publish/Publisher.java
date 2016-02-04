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


    public static final String BROKER_URL = "tcp://0.0.0.0:1883";
    public static final String TOPIC_REPORT = "sector7/REPORTMSG";


    private MqttClient client;


    public Publisher() {

        //We have to generate a unique Client id.
        String clientId = Utils.getMacAddress() + "-pub";


        try {

            client = new MqttClient(BROKER_URL, clientId);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void start(String msg , String reciver) {

        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setWill(client.getTopic("home/LWT"), "This is Test".getBytes(), 0, false);

            client.connect(options);

            final MqttTopic temperatureTopic = client.getTopic(TOPIC_REPORT);

            temperatureTopic.publish(new MqttMessage(msg.getBytes()));

            System.out.println("Published data. Topic: " + temperatureTopic.getName() + "  Message: " + msg);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void send(String reciver, String msg) {

        start(msg , reciver);

    }

}
