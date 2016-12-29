package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daijiajia on 2016/12/12.
 */
@RestController
public class ConsumerController {

    @Autowired
    ClientInterface client;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return client.add(10, 40);
    }
}
