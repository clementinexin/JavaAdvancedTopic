
package groovy

import groovy.swing.SwingBuilder
import java.awt.BorderLayout

import groovy.swing.SwingBuilder

import java.awt.BorderLayout as BL

/**
 * ClassName: WindowInGroovy <br>
 * Description: TODO <br>
 * Date: 2015年11月26日 上午11:26:32 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

class WindowInGroovy {

    public static void main(def args){
        def swing = new SwingBuilder()
        def count = 0
        def textlabel
        def frame = swing.frame(title:'Frame', size:[300, 300]) {
            borderLayout()
            textlabel = label(text:"Clicked ${count} time(s).",
            constraints: BL.NORTH)
            button(text:'Click Me',
            actionPerformed: {
                count++; textlabel.text =
                "Clicked ${count} time(s)."; println "clicked"
            },
            constraints:BorderLayout.SOUTH)
        }
        frame.pack()
        frame.show()
    }
}



