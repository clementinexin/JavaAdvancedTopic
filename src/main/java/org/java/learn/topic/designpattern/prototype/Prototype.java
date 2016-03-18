package org.java.learn.topic.designpattern.prototype;

import java.io.*;

/**
 * ClassName: Prototype <br/>
 * Description: TODO <br/>
 * Date: 2016-03-18 10:09 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-18 jdai@ created. <br/>
 */
public class Prototype implements Cloneable,Serializable {

    int i;
    Integer I;

    public Prototype(int i, Integer i1) {
        this.i = i;
        I = i1;
    }

    public Object clone(Prototype prototype) throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    public Object deepClone(Prototype prototype) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(this);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);
        return (Prototype)ois.readObject();
    }

}
