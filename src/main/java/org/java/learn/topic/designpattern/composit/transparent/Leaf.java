package org.java.learn.topic.designpattern.composit.transparent;

/**
 * ClassName: Leaf <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 10:11 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println(this.getName());
    }

    @Override
    @Deprecated
    public void add(Component component) {
        throw new UnsupportedOperationException("leaf can not support this operation");
    }

    @Override
    @Deprecated
    public void remove(Component component) {
        throw new UnsupportedOperationException("leaf can not support this operation");
    }
}
