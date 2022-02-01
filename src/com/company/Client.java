package com.company;

public class Client {
    private String nom;
    private Compte[] comptes = new Compte[100];
    private int nbComptes = 0;

    public Client() {
    }

    public Client(String nom) {
        this.nom = nom;
        comptes[0] = new Compte(1,0);
        nbComptes++;
    }

    public String getNom(){
        return nom;
    }

    public int getNbComptes() {
        return nbComptes;
    }

    public Compte[] getComptes(){
        return comptes;
    }

    float getSolde(){
        float solde = 0;
        for(Compte compte:comptes){
            if (compte!=null){
                solde+=compte.getSolde();
            }
        }
        return solde;
    }

    void afficherSolde(){
        System.out.println("solde des comptes de "+nom+" : "+this.getSolde());
    }

    void ajouterCompte(){
        for(int i = 0; i<100; i++){
            if (comptes[i]==null){
                comptes[i] = new Compte(i+1, 0);
                i=100;
            }
        }
        nbComptes++;
    }

    void renflouer(){
        if (comptes[0].getSolde()<0){
            for (int i = 1; i <100; i++){
                if (comptes[i]!=null){
                    boolean boucle = true;
                    //calcul de la différence pour arriver à 10
                    float diff = 10 - comptes[0].getSolde();
                    //si il y a assez pour couvrir la différence
                    if (comptes[i].getSolde() > diff){
                        comptes[i].virer(diff,comptes[0]);
                        boucle=false;
                    }
                    //si il n'y a pas assez -> tout virer
                    else{
                        comptes[i].virer(comptes[i].getSolde(),comptes[0]);
                        boucle=false;
                    }
                }
                if (comptes[0].getSolde()>0){
                    i=100;
                    System.out.println("compte courant du client "+nom+" renfloué");
                }
            }
        }else{
            System.out.println("renflouement du compte du client "+nom+" non nécessaire");
        }
    }

}
