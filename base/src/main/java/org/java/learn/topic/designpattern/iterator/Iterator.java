package org.java.learn.topic.designpattern.iterator;

/**
 * ClassName: Iterator <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 14:53 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public interface Iterator<T> {

    public T next();

    public boolean hasNext();

}
