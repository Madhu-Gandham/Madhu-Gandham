import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImpl extends UnicastRemoteObject implements Calc {

	 protected CalcImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



		@Override
		public int sum(int a, int b) throws RemoteException{
			// TODO Auto-generated method stub
			return a+b;
		}

		@Override
		public int sub(int a, int b)throws RemoteException {
			// TODO Auto-generated method stub
			return a-b;
		}

		@Override
		public int mult(int a, int b) throws RemoteException{
			// TODO Auto-generated method stub
			return a*b;
		}



		@Override
		public String CalcImpl() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}






		

	}