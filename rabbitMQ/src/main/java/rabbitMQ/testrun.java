package rabbitMQ;

import java.io.IOException;
import java.util.Date;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class testrun {
	public static void main(String[] args) {
	    Publisher(); // ������Ϣ

	    Consumer(); // ������Ϣ
	}

	/**
	 * ������Ϣ
	 */
	public static void Publisher() {
	    // ����һ������
	    Connection conn = ConnectionFactoryUtil.GetRabbitConnection2();
	    if (conn != null) {
	        try {
	            // ����ͨ��
	            Channel channel = conn.createChannel();
	            // �������С�����˵��������һ���������ƣ����������Ƿ�־û������������Ƿ��ռģʽ�������ģ������߶Ͽ�����ʱ�Ƿ�ɾ�����У������壺��Ϣ����������
	            channel.queueDeclare(Config.QueueName, false, false, false, null);
	            String content = String.format("��ǰʱ�䣺%s", new Date().getTime());
	            // �������ݡ�����˵��������һ�����������ƣ����������������ƣ�����������Ϣ����������-routing headers��������ΪMessageProperties.PERSISTENT_TEXT_PLAIN�������ô��ı���Ϣ�洢��Ӳ�̣������ģ���Ϣ���塿
	            channel.basicPublish("", Config.QueueName, null, content.getBytes("UTF-8"));
	            System.out.println("�ѷ�����Ϣ��" + content);
	            // �ر�����
	            channel.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	/**
	 * ������Ϣ
	 */
	public static void Consumer() {
	    // ����һ������
	    Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
	    if (conn != null) {
	        try {
	            // ����ͨ��
	           final Channel channel = conn.createChannel();
	            // �������С�����˵��������һ���������ƣ����������Ƿ�־û������������Ƿ��ռģʽ�������ģ������߶Ͽ�����ʱ�Ƿ�ɾ�����У������壺��Ϣ����������
	            channel.queueDeclare(Config.QueueName, false, false, false, null);

	            // ��������������������Ϣ
	            channel.basicConsume(Config.QueueName, false, "", new DefaultConsumer(channel) {
	                @Override
	                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
	                        byte[] body) throws IOException {
	                    String routingKey = envelope.getRoutingKey(); // ��������
	                    String contentType = properties.getContentType(); // ��������
	                    String content = new String(body, "utf-8"); // ��Ϣ����
	                    System.out.println("��Ϣ���ģ�" + content);
	                    channel.basicAck(envelope.getDeliveryTag(), false); // �ֶ�ȷ����Ϣ������˵��������һ������Ϣ��index�����������Ƿ�����Ӧ��true����ȷ��С��index����Ϣ��
	                }
	            });

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
