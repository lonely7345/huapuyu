package 适配器模式.对象的适配器模式;

public class Adapter implements Target
{
	private Adaptee adaptee;

	public Adapter(Adaptee adaptee)
	{
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void sampleOperation1()
	{
		this.adaptee.sampleOperation1();
	}

	@Override
	public void sampleOperation2()
	{
		System.out.println("Adapter sampleOperation2");
	}
}