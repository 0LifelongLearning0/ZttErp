package jehc.xtmodules.xtcore.mq.rabbit.interfac.impl;

import jehc.xtmodules.xtcore.mq.rabbit.interfac.RabbitProducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 生产者发送
 * @author dengcj
 *
 */
public class RabbitProducerImpl implements RabbitProducer {

	@Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
        }

    }

}
