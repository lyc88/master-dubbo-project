package com.softwore.zgd.dubbo.user.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author 风骚的GRE
 * @date 2018/1/29.
 */
public class JmsSender {
    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory
                ( "failover:(tcp://192.168.190.101:61616,tcp://192.168.190.102:61616)");
        Connection connection=null;
        try {
            //创建连接
            connection=connectionFactory.createConnection();

            connection.start();

            Session session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            //创建队列（如果队列已经存在则不会创建， first-queue是队列名称）
            //destination表示目的地
            Destination destination=session.createQueue("first-queue");
            //创建消息发送者
            MessageProducer producer=session.createProducer(destination);
            for(int i=0;i<10;i++) {
                TextMessage textMessage = session.createTextMessage("hello, ,我是骚骚的GRE:"+i);

                producer.send(textMessage);

            }
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
