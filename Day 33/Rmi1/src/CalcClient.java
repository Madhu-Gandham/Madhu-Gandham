import java.rmi.Naming;

public class CalcClient {
	public static void main(String[] args) {
		try
		{
			Calc h = (Calc)Naming.lookup("localhost");
			System.out.println("Client Program");
			System.out.println("Server :  " + h.sub(12,5));
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
	}
}