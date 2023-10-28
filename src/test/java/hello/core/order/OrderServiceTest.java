package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {


    private OrderService orderService;
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.ordersErvice();
        memberService = appConfig.memberService();
    }


    @Test
    void createOrder(){
        //기초타입으로 할 때는 null을 넣을 수가 없다 하지만 여기에선 사용해도 무방
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
}
