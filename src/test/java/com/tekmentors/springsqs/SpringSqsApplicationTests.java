package com.tekmentors.springsqs;

import com.tekmentors.springsqs.publisher.MessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringSqsApplicationTests {
	@Autowired
	MessagePublisher messagePublisher;

	@Test
	void publishMessage() throws InterruptedException {
		log.info("test with message template.");
//		for (int i = 0; i <10; i++){
			messagePublisher.send("Test Message");
//			Thread.sleep(10000);
//		}

	}

}
