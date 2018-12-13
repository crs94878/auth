package famaly.people.auth;

import famaly.people.auth.bd.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
@EnableWs
@EnableAutoConfiguration
@ComponentScan("famaly.people.auth")
public class AuthApplication {

    public static void main(String[] args) {
       SpringApplication.run(AuthApplication.class, args);
    }
}
