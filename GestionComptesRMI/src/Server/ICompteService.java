package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICompteService extends Remote{

	int findCompte(String num) throws RemoteException;
    List<Compte> allComptes() throws RemoteException;
    void set(int index, Compte c) throws RemoteException;
}
