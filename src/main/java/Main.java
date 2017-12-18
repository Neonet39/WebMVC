import com.config.AppSecurityConfig;
import com.config.DataConfig;
import com.config.WebConfig;
import com.security.test4.TokenUtils;
import com.services.BooksService;
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
