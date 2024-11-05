package sample.cafekiosk.spring;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import sample.cafekiosk.spring.client.mail.MailSendClient;

@ActiveProfiles("test")
@SpringBootTest
// TODO: @MockBean 붙은 테스트 환경과 순수 테스트 환경으로 클래스 분리할 수도 있음
public abstract class IntegrationTestSupport {

    @MockBean
    protected MailSendClient mailSendClient;

}
