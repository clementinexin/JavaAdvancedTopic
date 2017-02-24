package reflections;

import com.google.inject.Module;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import javax.annotation.PostConstruct;
import javax.ws.rs.PathParam;
import java.lang.reflect.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static org.reflections.ReflectionUtils.*;

/**
 * Created by dj on 2017/2/24.
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException {

        //scan urls that contain 'my.package', include inputs starting with 'my.package', use the default scanners
        Reflections reflections = new Reflections("my.package");

        //or using ConfigurationBuilder
        new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("my.project.prefix"))
                //.setScanners(new SubTypesScanner(),
                //        new TypeAnnotationsScanner().filterResultsBy(optionalFilter))
                .filterInputsBy(new FilterBuilder().includePackage("my.project.prefix")));

        //SubTypesScanner
        Set<Class<? extends Module>> modules = reflections.getSubTypesOf(com.google.inject.Module.class);
        //TypeAnnotationsScanner
        Set<Class<?>> singletons = reflections.getTypesAnnotatedWith(javax.inject.Singleton.class);
        //ResourcesScanner
        Set<String> properties = reflections.getResources(Pattern.compile(".*\\.properties"));
        //MethodAnnotationsScanner
        Set<Method> resources = reflections.getMethodsAnnotatedWith(javax.ws.rs.Path.class);
        Set<Constructor> injectables = reflections.getConstructorsAnnotatedWith(javax.inject.Inject.class);
        //FieldAnnotationsScanner
        Set<Field> ids = reflections.getFieldsAnnotatedWith(javax.persistence.Id.class);
        //MethodParameterScanner
        Set<Method> someMethods = reflections.getMethodsMatchParams(long.class, int.class);
        Set<Method> voidMethods = reflections.getMethodsReturn(void.class);
        Set<Method> pathParamMethods = reflections.getMethodsWithAnyParamAnnotated(PathParam.class);
        //MethodParameterNamesScanner
        List<String> parameterNames = reflections.getMethodParamNames(Main.class.getMethod("main", Array.class));
        //MemberUsageScanner
        Set<Member> usages = reflections.getMethodUsage(Main.class.getMethod("main", Array.class));

        Set<Method> getters = getAllMethods(Main.class,
                withModifier(Modifier.PUBLIC), withPrefix("get"), withParametersCount(0));

        Set<Method> listMethodsFromCollectionToBoolean =
                getAllMethods(List.class, withParametersAssignableTo(Collection.class), withReturnType(boolean.class));

        Set<Field> fields = getAllFields(Main.class, withAnnotation(PostConstruct.class), withTypeAssignableTo(List.class));

    }
}
