import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableCallable;

/**
 * Created by daijiajia on 16/8/15.
 */
public class HelloQuasar {

    static void m1() throws SuspendExecution, InterruptedException {
        String m = "m1";
        System.out.println("m1 begin");
        m = m2();
        m = m3();
        System.out.println("m1 end");
        System.out.println(m);
    }

    static String m2() throws SuspendExecution, InterruptedException {
        return "m2";
    }

    static String m3() throws SuspendExecution, InterruptedException {
        return "m3";
    }

    public static void main(String[] args) {
        new Fiber<Void>("Caller", new SuspendableCallable() {
            @Override
            public Object run() throws SuspendExecution, InterruptedException {
                m1();
                return null;
            }
        }).start();
    }
}
