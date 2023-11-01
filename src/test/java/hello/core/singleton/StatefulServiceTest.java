package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefuleServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //상황 : A사용자가 10000원을 주문하고 주문 금액을 조회하려고 하는 중간에 B사용자가 20000원을 주문한 상황이다.

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //int price = statefulService1.getPrice();

        //사용자A가 주문한 금액은 10000원 이므로 price는 10000원이 찍혀야 하지만,,,,, 20000원이 출력되어 나온다.
        //System.out.println("price = " + price);

        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}