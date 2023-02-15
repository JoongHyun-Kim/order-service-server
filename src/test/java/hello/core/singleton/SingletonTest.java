package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 1. 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 호출할 때마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        // memberService1 객체와 membeService2 객체의 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2면 통과
        assertThat(memberService1).isNotSameAs(memberService2);
    }
}
