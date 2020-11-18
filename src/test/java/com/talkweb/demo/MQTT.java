package com.talkweb.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author liuzixuan
 * @date 2020/10/16
 */
public class MQTT {

    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] args)  throws  Exception{

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String message = "Hello,world!";

        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        System.out.println("[x] Sent '" + message + "'");

        channel.close();

        connection.close();

    }



}
