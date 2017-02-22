package groovy;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dj on 2017/2/20.
 */
public class GroovyInJava {

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("groovy");
        System.out.println(engine.toString());
        Bindings bindings = engine.createBindings();
        Map<String, String> params = new HashMap<String, String>();
        params.put("cabinType", "NN");
        bindings.put("params", params);
        System.out.println(engine.eval(new FileReader("/Users/daijiajia/Project/JavaAdvancedTopic/GroovyExample/src/main/java/groovy/handle.groovy"), bindings).toString());

        //System.out.println(((Invocable) engine).invokeFunction("add", 1, 1));
    }
}
