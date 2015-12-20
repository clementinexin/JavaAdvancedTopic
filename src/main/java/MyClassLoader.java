

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;

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
	
	public MyClassLoader(ClassLoader parent,String name) {
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
			return FileUtils.readFileToByteArray(new File(path + name.replace(".", "\\") + fileType));
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
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("D:\\classloader\\exercise\\lib1\\");
		
		MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
		loader2.setPath("D:\\classloader\\exercise\\lib2\\");
		
		MyClassLoader loader3 = new MyClassLoader(null, "loader3");
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
