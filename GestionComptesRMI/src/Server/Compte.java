package Server;

import java.io.Serializable;

public class Compte implements Serializable{
	private String numero;
    private float solde;
    public Compte(String numero, float solde )  {

        this.numero = numero;
        this.solde = solde;
    }
    public void crediter( float montant ){
        solde = solde + montant;
    }
    public void debiter( float montant ){
        solde = solde - montant;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getNumero() {
        return numero;
    }

    public float getSolde() {
        return solde;
    }

  //  public float quelSolde(){ return solde; }


    public String quelSolde() {
        return "Compte{" +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                '}';
    }

    // on se limite à ces méthodes
}
