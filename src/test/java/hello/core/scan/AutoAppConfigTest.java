package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    @DisplayName("component scan 동작 확인")
    void basicScan(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService bean = ac.getBean(MemberService.class);

        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
    }
}
