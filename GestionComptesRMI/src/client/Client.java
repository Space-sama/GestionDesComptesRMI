package client;

import java.rmi.Naming;
import java.util.Scanner;

import Server.Compte;
import Server.ICompteService;

public class Client {

	public static void main(String[] args) throws Exception{
		ICompteService stub = (ICompteService) Naming.lookup("rmi://localhost:8888/OD");
		
		int index = stub.findCompte("OKU87");
		Compte compte = stub.allComptes().get(index);
		if(index == -1) {
			System.out.println("This client is not found !");
		}
		else {
			System.out.println("Number of account :"+" "+compte.getNumero());
			System.out.println("Solde is :"+" "+compte.getSolde());
		}
		
		
		Scanner clavier = new Scanner(System.in);
		int sousMenu = 0;
		boolean stop = false;
		while(!stop) {
			System.out.println("---- BANK OF ISGA ------");
			System.out.println("1 --> Crediter");
			System.out.println("2 --> Debiter");
			System.out.println("3 --> Voir le solde");
			System.out.println("9 --> Quitter");
			
			int choice = clavier.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Montant ?");
				float montant = clavier.nextFloat();
				compte.crediter(montant);
				break;
				
			case 2:
				System.out.println("Montant ?");
				float montantD = clavier.nextFloat();
				compte.debiter(montantD);
				break;
				
			case 3:
				System.out.println("----- Informations ------");
				System.out.println("Number of the account is "+" "+compte.getNumero());
				System.out.println("Your Solde is :"+" "+compte.getSolde());
				break;
				
			case 9:
				stop = true;
				stub.set(index, compte);
				stop = true;
				break;

			default:
				System.out.println("Enter a number between 1 & 3 ....");
				break;
			}
		}
	}

}
