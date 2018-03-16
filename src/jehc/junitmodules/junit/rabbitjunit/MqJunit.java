package jehc.junitmodules.junit.rabbitjunit;

import jehc.xtmodules.xtcore.base.BaseJunit;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
public class MqJunit extends BaseJunit{
	@Autowired
	AmqpTemplate rabbitTemplate;
	@Test
	public void rabbit(){
//		ApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath*:/jehc/xtmodules/xtcore/sources/mq/rabbit.xml");
		rabbitTemplate.convertAndSend("queue1k", "生产者发送一条紧急通知任务");
	}
}
