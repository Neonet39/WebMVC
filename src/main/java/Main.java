import com.config.DataConfig;
import com.services.BooksService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DataConfig.class);
        BooksService booksServices = (BooksService) ctx.getBean("booksServiceImpl");
        System.out.println(booksServices.getListBooks());
    }
}
