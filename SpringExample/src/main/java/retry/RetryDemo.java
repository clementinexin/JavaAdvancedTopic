package retry;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * Created by daijiajia on 16/10/19.
 */
@Component
public class RetryDemo {

    @Retryable(value = {RemoteAccessException.class, RuntimeException.class},
            maxAttempts = 2,
            backoff = @Backoff(value = 2000))
    public void dosth() {

    }
}
