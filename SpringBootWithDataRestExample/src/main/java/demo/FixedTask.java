package demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by daijiajia on 2016/12/9.
 */
@Component
public class FixedTask {

    @Scheduled(fixedRate = 1000L)
    public void print() {
        System.out.println(Thread.currentThread().getName() + "\t" + new Date());
    }


}
