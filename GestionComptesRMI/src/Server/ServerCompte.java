package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerCompte extends UnicastRemoteObject implements ICompteService{

	public List<Compte> Accounts;
	
	private static List<Compte> initListOfAccounts(){
		List<Compte> listOfAccounts = new ArrayList<Compte>();
		listOfAccounts.add(new Compte("AOKI", 26000));
		listOfAccounts.add(new Compte("OKU87", 28090));
		listOfAccounts.add(new Compte("M0OF", 60000));
		listOfAccounts.add(new Compte("5RFD3", 46000));
		listOfAccounts.add(new Compte("NB-4-G", 9000));
		return listOfAccounts;
	}
	
	
	
	
	
	
	protected ServerCompte(List<Compte> listOfAccount) throws RemoteException {
		super();
		this.Accounts = listOfAccount;
		
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException {
			ICompteService ICompteService;
			ICompteService = new ServerCompte(initListOfAccounts());
			LocateRegistry.createRegistry(7117);
			Naming.rebind("rmi://localhost:8888/OD", ICompteService);
			System.out.println(ICompteService.toString());
			ICompteService.allComptes().get(3).crediter(2000);
	}

	@Override
	public int findCompte(String numClient) throws RemoteException {
		for(Compte account : Accounts) {
			if(account.getNumero().equals(numClient)){
				return Accounts.indexOf(account);
			}
			else {System.out.println("Not Found !");} 
		}
		return -1;
		
	}






	@Override
	public List<Compte> allComptes() throws RemoteException {
		
		return this.Accounts;
	}






	@Override
	public void set(int index, Compte c) throws RemoteException {
		this.Accounts.set(index, c);
		
	}

}
