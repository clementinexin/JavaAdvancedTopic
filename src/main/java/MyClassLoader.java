import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MyClassLoader extends ClassLoader {

    private String name;

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String fileType = ".class";

    public MyClassLoader(String name) {
        super();
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        try {
            return Files.readAllBytes(Paths.get(path + name.replace(".", "\\") + fileType));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyClassLoader [name=" + name + "]";
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        System.out.println(MyClassLoader.class.getClassLoader());
        System.out.println(MyClassLoader.class.getClassLoader().getParent());
        System.out.println(MyClassLoader.class.getClassLoader().getParent().getParent());
        MyClassLoader loader1 = new MyClassLoader("loader1");
        System.out.println(loader1.getClass().getClassLoader());
        loader1.setPath("D:\\classloader\\exercise\\lib1\\");

        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        System.out.println(loader2.getClass().getClassLoader());
        loader2.setPath("D:\\classloader\\exercise\\lib2\\");

        MyClassLoader loader3 = new MyClassLoader(null, "loader3");
        System.out.println(loader3.getClass().getClassLoader());
        loader3.setPath("D:\\classloader\\exercise\\otherlib\\");

        Class clazz = loader1.loadClass("Sample1");

        Object object = clazz.newInstance();
        System.out.println(object.hashCode());

        object = null;
        clazz = null;
        loader1 = null;

        loader1 = new MyClassLoader("loader1");
        loader1.setPath("D:\\classloader\\exercise\\lib1\\");
        clazz = loader1.loadClass("Sample1");
        object = clazz.newInstance();
        System.out.println(object.hashCode());


//		Sample1 sample1 = (Sample1) object;
//		System.out.println(sample1.v1);
        // 反射可以跨越loader域隔离的限制

//		Field field = object.getClass().getField("v1");
//		System.out.println(field.getInt(object));
//		test(loader2);
//		test(loader3);
    }


    private static String printClassLoader(ClassLoader classLoader) throws IOException {
        StringBuilder classLoaderDetail = new StringBuilder();
        if (classLoader != null) {
            classLoaderDetail.append("-----------------------\n");
            classLoaderDetail.append(String.format("ClassLoader:%s\n", classLoader.toString()));
            if (classLoader instanceof URLClassLoader) {
                URLClassLoader loader = (URLClassLoader) classLoader;
                for (URL url : loader.getURLs()) {
                    classLoaderDetail.append(String.format("[%s]加载的包:%s\n", classLoader.toString(), url));
                }
            }
            classLoaderDetail.append("-----------------------\n");
            classLoaderDetail.append(printClassLoader(classLoader.getParent()));
        }
        return classLoaderDetail.toString();
    }

    public static void test(ClassLoader loader) {

        try {
            Class clazz = loader.loadClass("Sample1");
            Object object = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
