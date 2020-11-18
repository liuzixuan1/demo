package com.talkweb.demo;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author liuzixuan
 * @date 2020/10/16
 */
public class ConnectionUtil {


    public static Connection getConnection() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.146.19");
        factory.setPort(1883);
        factory.setVirtualHost("testMqtt");
        factory.setUsername("admin");
        factory.setPassword("talkweb_2020");
        Connection connection = factory.newConnection();
        return connection;
    }

}
