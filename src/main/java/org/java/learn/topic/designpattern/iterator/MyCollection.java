package org.java.learn.topic.designpattern.iterator;

/**
 * ClassName: MyCollection <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:06 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class MyCollection implements Collection<String> {

    private String[] strings = new String[] {"A","B","C","D","E"};

    @Override
    public int size() {
        return strings.length;
    }

    @Override
    public boolean isEmpty() {
        return strings.length<=0;
    }

    @Override
    public String get(int i) {
        return strings[i];
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator(this);
    }
}
