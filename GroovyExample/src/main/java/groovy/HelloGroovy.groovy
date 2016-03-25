
package groovy

 /**
 * ClassName: HelloGroovy <br>
 * Description: TODO <br>
 * Date: 2015年11月26日 上午11:04:32 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

class HelloGroovy{
    /**
     * @param args
     */
    public static void main(def args){
        // TODO Auto-generated method stub
        def xml = new XmlBuilder (new StringBuilder());
        xml.html{
            head{
                title "Hello World"
            }
            body{
                p "Welcome!"
            }
        }
        println xml.out;
    }
}
