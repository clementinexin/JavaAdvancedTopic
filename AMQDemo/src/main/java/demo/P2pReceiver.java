package demo;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ClassName: P2pReceiver <br/>
 * Description: TODO <br/>
 * Date: 2016-04-20 14:18 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-04-20 jdai@ created. <br/>
 */
public class P2pReceiver {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://127.0.0.1:61616"
        );

        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("MessageQueue");
        MessageConsumer consumer = session.createConsumer(destination);
        while (true) {
            ObjectMessage message = (ObjectMessage) consumer.receive(1000);
            if (null != message) {
                System.out.println(message.getObject());
            } else {
                break;
            }
        }
    }
}
