package scheduled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by daijiajia on 16/8/25.
 */
@Component
public class ScheduledExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    }

    int i = 0;
    
    @Scheduled(fixedRate = 1000l)
    public void test() {


        System.out.println(i++);
    }
}
