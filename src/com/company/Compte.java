package com.company;

public class Compte {

    private int numero;
    private float solde;

    public Compte() {
    }

    public Compte(int numero, float solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public float getSolde(){
        return solde;
    }

    public int getNumero(){
        return numero;
    }

    void depot(float valeur){
        solde += valeur;
    }

    void retrait(float valeur){
        solde -= valeur;
    }

    void afficherSolde(){
        System.out.println("solde du compte n°"+numero+" : "+solde+" €");
    }

    void virer(float valeur, Compte destinataire){
        destinataire.depot(valeur);
        this.retrait(valeur);
    }
}
