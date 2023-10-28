package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
/*        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        //스프링으로 전환하기 - Bean들을 관리하는 ApplicationContext
        //AnnotationConfigApplicationContext - 어노테이션으로 선언한 Bean을 관리
        //그냥 객체를 생성해서 넣는것과 AppConfig.class 이렇게 해서 넣는 것의 차이?
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //name = AppConfig안의 메서드명(객체 명)
        //두번째는 리턴 할 반환 타입
        MemberService memberService = ac.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}
