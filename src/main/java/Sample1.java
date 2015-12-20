

public class Sample1 {

	public int v1 =1;
	
	public Sample1() {
		System.out.println("calss " + this.getClass().getSimpleName() + " load by :" + this.getClass().getClassLoader());
		new Sample2();
	}
}
