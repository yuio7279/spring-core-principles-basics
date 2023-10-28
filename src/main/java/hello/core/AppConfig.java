package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //메서드 명만 보았을 때 역할, 즉 주입관계를 한 눈에 볼 수 있다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService ordersErvice(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //설정정보를 한 눈에 들어오게 하기 위해 새로운 메서드로 정의하였다.
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
