package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BanqueInteractive {

    public BanqueInteractive() {
    }

    Banque banqueTest = new Banque("Banque Test");
    Scanner scan = new Scanner(System.in);

    public void interaction(){
        System.out.println("\nQuelle opération voulez-vous effectuer ?");
        System.out.println("1) Ajouter un client");
        System.out.println("2) Effectuer une opération sur un client");
        System.out.println("3) Afficher un bilan général");
        System.out.println("4) Renflouement de tous les comptes");
        int scannInt = scan.nextInt();
        if(scannInt == 1){
            interactionAjoutClient();
        }
        if(scannInt == 2){
            interactionOperationClient();
        }
        if(scannInt == 3){
            banqueTest.afficherBilan();
        }
        if(scannInt == 4){
            banqueTest.renflouer();
            interaction();
        }
    }

    void interactionAjoutClient(){
        System.out.println("\nEntrez le nom du client :");
        String nom = scan.next();
        banqueTest.ajouterClient(nom);
        System.out.println("Le client "+nom+" a été créé.\n");
        interaction();
    }

    void interactionOperationClient(){
        System.out.println("\nQuel client ?");
        for(int i = 0; i <100; i++){
            if(banqueTest.getClients()[i] != null){
                System.out.println(i+1+") "+banqueTest.getClients()[i].getNom());
            }else{
                i=100;
            }
        }
        int numClient = scan.nextInt()-1;
        Client selected = banqueTest.getClients()[numClient];

        System.out.println("Quelle opération voulez-vous effectuer sur le client "+selected.getNom()+" ?");
        System.out.println("1) Afficher un bilan");
        System.out.println("2) Faire un retrait");
        System.out.println("3) Faire un dépôt");
        System.out.println("4) Faire un virement");
        System.out.println("5) Ajouter un compte");
        System.out.println("6) Renflouer le compte courant");
        int scannInt = scan.nextInt();
        if (scannInt == 1){
            banqueTest.bilanClient(banqueTest.getClients()[numClient]);
        }
        if (scannInt == 2){
            interactionRetrait(selected);
        }
        if (scannInt == 3){
            interactionDepot(selected);
        }
        if (scannInt == 4){
            interactionVirement(selected);
        }
        if (scannInt == 5){
            selected.ajouterCompte();
            System.out.println("compte ajouté");
        }
        if (scannInt == 6){
            selected.renflouer();
        }

        interaction();
    }

    void interactionDepot(Client client){
        System.out.println("Sur quel compte ?");
        for(int i = 0; i<100; i++){
            if (client.getComptes()[i]!=null){
                client.getComptes()[i].afficherSolde();
            }else{
                i=100;
            }
        }
        int numCompte = scan.nextInt()-1;
        System.out.println("Combien ?");
        float montant = scan.nextFloat();
        client.getComptes()[numCompte].depot(montant);
        System.out.println(montant+" ajouté sur le compte "+(numCompte+1));
        interaction();
    }

    void interactionRetrait(Client client){
        System.out.println("Sur quel compte ?");
        for(int i = 0; i<100; i++){
            if (client.getComptes()[i]!=null){
                client.getComptes()[i].afficherSolde();
            }else{
                i=100;
            }
        }
        int numCompte = scan.nextInt()-1;
        System.out.println("Combien ?");
        float montant = scan.nextFloat();
        client.getComptes()[numCompte].retrait(montant);
        System.out.println(montant+" retiré sur le compte "+(numCompte+1));
        interaction();
    }

    void interactionVirement(Client client){
        System.out.println("Depuis quel compte ?");
        for(int i = 0; i<100; i++){
            if (client.getComptes()[i]!=null){
                client.getComptes()[i].afficherSolde();
            }else{
                i=100;
            }
        }
        int numCompte = scan.nextInt()-1;
        System.out.println("Combien ?");
        float montant = scan.nextFloat();

        System.out.println("\nSur le compte de quel client ?");
        for(int i = 0; i <100; i++){
            if(banqueTest.getClients()[i] != null){
                System.out.println(i+1+") "+banqueTest.getClients()[i].getNom());
            }else{
                i=100;
            }
        }
        int numClient = scan.nextInt()-1;
        Client beneficiaire = banqueTest.getClients()[numClient];

        System.out.println("sur quel compte ?");
        for(int i = 0; i<100; i++){
            if (beneficiaire.getComptes()[i]!=null){
                beneficiaire.getComptes()[i].afficherSolde();
            }else{
                i=100;
            }
        }
        int numCompteBeneficiaire = scan.nextInt()-1;

        client.getComptes()[numCompte].virer(montant, beneficiaire.getComptes()[numCompteBeneficiaire]);
        System.out.println(montant+" transféré du compte n°"+(numCompte+1)+" de "+client.getNom()+" sur le compte n°"+(numCompteBeneficiaire+1)+" de "+beneficiaire.getNom());
        interaction();
    }
}
