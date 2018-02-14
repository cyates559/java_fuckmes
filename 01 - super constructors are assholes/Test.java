public class Test
{
	public static class A
	{
		public A()
		{
			System.out.println("Called A() constructor");
			initTest();
			System.out.println("Finished A()");
		}
		public void initTest()
		{
			// Essentially this method is abstract
		}
	}
	public static class B extends A
	{
		protected String test = null;

		public B()
		{
			super();
			// Abra-kadabra, because we initialized test to null, it is set back to
			// null directly after the super call.
			// Lesson learned, the " = null" initialization of test is not only
			// unneccesary, but it causes problems
			if (test == null)
			{
				System.out.println("Fail: Test was null");
			}
			else
			{
				System.out.println(test);
			}
		}
		@Override
		public void initTest()
		{
			test = "Test successfully initialized";
		}
	}
	public static void main(String[]args)
	{
		new B();
	}
}
