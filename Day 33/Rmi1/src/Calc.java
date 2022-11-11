import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote  {

	String CalcImpl() throws RemoteException;

	int sum(int a, int b)throws RemoteException;
	int sub(int a, int b)throws RemoteException;
	int mult(int a, int b)throws RemoteException;
}