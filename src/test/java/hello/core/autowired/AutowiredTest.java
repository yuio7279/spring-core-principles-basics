package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {


    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("member = " + member);
        }
        @Autowired
        public void setNoBean2(@Nullable Member member){
            //호출은 가능 하지만 null로 들어옴
            System.out.println("member = " + member);
        }
        @Autowired
        public void setNoBean3(Optional<Member> member){
            //값이 없으면 Optional.empty로 담긴다.
            System.out.println("member = " + member);
        }

    }
}
