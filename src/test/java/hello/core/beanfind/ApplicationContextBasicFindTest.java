package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //isInstanceOf - 객체 인스턴스를 확인 할 수 있다.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구현체 타입으로 조회")
    void findBeanByName2(){
        //추천하지 않는 방법이다.
        //역할에 의존해야 하지만 이것은 구현에 의존하였기 때문
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //테스트는 항상 실패테스트를 만들어야 한다.
    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameX(){
        //JUnit 라이브러리 Assertions의 assertThrows 메서드를 이용,
        //빈을 가져오는 과정에서 해당 예외가 터지는지 검증할 수 있다.
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xx",MemberService.class));

    }
}
