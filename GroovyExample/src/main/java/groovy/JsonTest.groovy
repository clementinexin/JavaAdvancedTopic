package groovy

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

/**
 * Created by dj on 2017/2/21.
 */
class JsonTest {

    public static void main(String[] args) {
        //构建json
        def json = new JsonBuilder()
        json.state {
            capital "Denver"
            majorCities "Denver", "Colorado Springs", "Fort Collins"
        }
        //转字符串
        println json.toPrettyString()

        //从json解析为对象
        def jsonSlurper = new JsonSlurper();
        def obj = jsonSlurper.parseText(json.toString());
        println obj.state.capital
        println obj.state.majorCities[1]
    }
}
