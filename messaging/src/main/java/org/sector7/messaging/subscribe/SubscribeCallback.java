package org.sector7.messaging.subscribe;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by sector7 on 2/6/16.
 */
public class SubscribeCallback implements MqttCallback{

    public void connectionLost(Throwable cause) {
        //This is called when the connection is lost. We could reconnect here.
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Message arrived. Topic: " + topic + "  Message: " + message.toString());

        if ("sector7/REPORTMSG".equals(topic)) {
            System.err.println("Sensor gone!");
        }
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        //no-op
    }
}
