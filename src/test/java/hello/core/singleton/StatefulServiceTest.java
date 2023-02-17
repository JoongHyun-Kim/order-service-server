package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A: 사용자 A 10000원 주문
        statefulService1.order("userA", 10000);
        // Thread B: 사용자 B 20000원 주문
        // 사용자 A가 주문하던 중 사용자 B가 주문
        statefulService2.order("userB", 20000);

        // Thread A: 사용자 A 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price); // 사용자 B가 주문한 20000이 조회. 같은 객체를 사용하기 때문

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    // 테스트용 config
    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}