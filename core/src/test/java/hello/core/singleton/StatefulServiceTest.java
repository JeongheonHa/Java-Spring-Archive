package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class StatefulServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    @Test
    void statefulServiceSingleton() {


        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        int price1 = statefulService1.order("userA", 10000);
        int price2 = statefulService2.order("userB", 20000);

        System.out.println("price of userA = " + price1);

        // 20000원이 나오면 실패
        assertThat(price1).isEqualTo(10000);
    }



    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
