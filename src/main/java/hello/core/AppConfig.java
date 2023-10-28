package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//스프링으로 전환하기 - 어노테이션 사용
//Configuration 구성정보를 담당 한다는 의미
@Configuration
public class AppConfig {

    //메서드 명만 보았을 때 역할, 즉 주입관계를 한 눈에 볼 수 있다.

    //스프링 컨테이너에 Bean으로써 등록 됨
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService ordersErvice(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //설정정보를 한 눈에 들어오게 하기 위해 새로운 메서드로 정의하였다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        //정책변경
        return new RateDiscountPolicy();
    }


}
