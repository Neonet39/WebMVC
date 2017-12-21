import com.config.WebConfig;
import com.config.security.token.TokenUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(WebConfig.class);
        UserDetailsService userDetailsService = (UserDetailsService) ctx.getBean("userDetailisServiceImpl");
        UserDetails userDetails = userDetailsService.loadUserByUsername("user");
        String token = TokenUtils.createToken(userDetails);
        System.out.println(token);

    }
}
