package rabbitMQ;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionFactoryUtil {
	public static Connection GetRabbitConnection() {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setUsername(Config.UserName);
	    factory.setPassword(Config.Password);
	    factory.setVirtualHost(Config.VHost);
	    factory.setHost(Config.Host);
	    factory.setPort(Config.Port);
	    Connection conn = null;
	    try {
	        conn = factory.newConnection();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static Connection GetRabbitConnection2() {
	    ConnectionFactory factory = new ConnectionFactory();
	    // ���Ӹ�ʽ��amqp://userName:password@hostName:portNumber/virtualHost
	    String uri = String.format("amqp://%s:%s@%s:%d%s", Config.UserName, Config.Password, Config.Host, Config.Port,
	            Config.VHost);
	    Connection conn = null;
	    try {
	        factory.setUri(uri);
	        factory.setVirtualHost(Config.VHost);
	        conn = factory.newConnection();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
}
