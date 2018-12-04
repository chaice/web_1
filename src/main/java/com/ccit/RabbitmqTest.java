package com.ccit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class RabbitmqTest {

    //exchange type
    public enum XT {
        DEFAULT, FANOUT, DIRECT, TOPIC, HEADERS
    }

    private final static String QUEUE_NAME = "test";

    private final static String EXCHANGE_NAME = "test_exchange";

    private static Scanner scanner = new Scanner(System.in);

    private static String message = "";

    private static boolean getInputString() {
        message = scanner.nextLine();
        if (message.length() == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("118.89.141.11");

        //声明一个连接
        Connection connection = connectionFactory.newConnection();
        //声明消息通道
        Channel channel = connection.createChannel();

        XT xt = XT.HEADERS;

        switch (xt) {
            //默认,向指定的队列发送消息,消息只会被一个consumer处理,多个消费者消息会轮询处理,消息发送时没有consumer,消息不会丢失
            case DEFAULT:
                //为消息通道绑定一个队列,队列的相关参数需要与第一次定义该队列时相同,否则会出错
                //参数1:队列名称;
                //参数2:为true时server重启队列不会消失;
                //参数3:队列是否是独占的,如果为true只能被connection使用,其他连接建立时会抛出异常;
                //参数4:队列不再使用时是否自动删除(没有连接,并且没有未处理的消息);
                //参数5:建立队列时的其他参数
                channel.queueDeclare(QUEUE_NAME, true, false, true, null);

                while (getInputString()) {
                    //向server发布一条消息
                    //参数1:exchange名字,若为空则使用默认的exchange
                    //参数2:routing key
                    //参数3:其他的属性
                    //参数4:消息体
                    //rabbitmq 默认有一个exchange,叫做default exchange,它用一个空字符串表示,它是direct exchange类型
                    //设置消息为持久化,服务器重启不会丢失
                    channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());

                    System.out.println("Send Message:" + message);
                }
                break;
            case FANOUT:
                //广播给所有队列,接收方也必须通过fanout交换机获取消息,所有连接到该交换机的consumer均可获取消息,如果producer在发布消息时没有consumer在监听,消息将被丢弃
                //定义一个交换机
                //参数1:交换机名称
                //参数2:交换机类型
                //参数3:交换机持久性,如果为true则服务器重启时不会丢失
                //参数4:交换机在不被使用时是否删除
                //参数5:交换机的其他属性
                channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true, true, null);

                while (getInputString()) {
                    //发送一条广播消息,参数2此时无意义
                    channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());

                    System.out.println("Send Message:" + message);
                }

                break;
            case DIRECT:
                //向所有绑定了相应routing key的队列发送消息,如果producer在发布消息时没有consumer在监听,消息将被丢弃,如果有多个consumer监听了相同的routing key则他们都会收到消息
                while (getInputString()) {
                    String[] temp = message.split(" ");
                    channel.basicPublish(EXCHANGE_NAME, temp[0], null, temp[1].getBytes());

                    System.out.println("Send Message:" + message);
                }

                break;
            case TOPIC:

        }

    }
}
