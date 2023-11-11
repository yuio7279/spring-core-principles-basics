package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest(){

        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean("networkClient", NetworkClient.class);

        /**
         * ApplicationContext를 (빈들의 생명주기를 확인하기 위해) 닫아야한다.
         * 하지만 기본적으로 제공해주지 않는다. 따라서 구체인 AnnotationConfigApplicationContext 로 바꾸거나
         * ConfigurableApplicationContext를 사용한다.
         * 스프링 컨테이너를 종료한 것
         */
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
