
package vertx;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Verticle;

import java.util.concurrent.ConcurrentMap;

/**
 * ClassName: WorkerVerticle <br>
 * Description: TODO <br>
 * Date: 2015年11月25日 下午5:28:27 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 */

public class WorkerVerticle extends Verticle {

    @Override
    public void start() {
        // Register a listener
        EventBus eb = vertx.eventBus();
        Handler<Message> workerHandler = new Handler<Message>() {
            @Override
            public void handle(Message message) {
                Logger logger = container.logger();
                logger.info("MyWorkerVerticle just received a request for: " + message.body());

                // Examine our shared map
                ConcurrentMap<String, String> map = vertx.sharedData().getMap("mymap");
                logger.info("Shared data: " + map.get("mykey"));

                message.reply("<html><head><title>Worker Response</title></head><body>Hello, from the worker verticle</body></html>");
            }
        };
        eb.registerHandler("request.worker", workerHandler);

    }
}
