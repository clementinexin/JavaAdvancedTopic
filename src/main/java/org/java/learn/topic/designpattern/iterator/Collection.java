package org.java.learn.topic.designpattern.iterator;

/**
 * ClassName: Collection <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 14:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public interface Collection<T> {

    public int size();

    public boolean isEmpty();

    public T get(int i);

    public Iterator<T> iterator();
}
