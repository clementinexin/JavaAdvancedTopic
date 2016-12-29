package org.java.learn.topic.designpattern.iterator;

/**
 * ClassName: MyIterator <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:07 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class MyIterator implements Iterator<String> {

    private Collection<String> collection;

    public MyIterator(Collection<String> collection) {
        this.collection = collection;
    }

    private int pos = -1;

    @Override
    public String next() {
        if (pos < collection.size() - 1) pos++;
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if (pos < collection.size() - 1) return true;
        else return false;
    }
}
