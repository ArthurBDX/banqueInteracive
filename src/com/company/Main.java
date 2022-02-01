package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Test Class
        /*
        //Compte
        Compte c1 = new Compte(1, 100);
        Compte c2 = new Compte(2, 200);

        System.out.println("\n### valeurs initiales ###");
        c1.afficherSolde();
        c2.afficherSolde();
        System.out.println("\n### getSolde compte 1 ###");
        System.out.println(c1.getSolde());
        System.out.println("\n### +25 -> compte 1 ###");
        c1.depot(25);
        c1.afficherSolde();
        c2.afficherSolde();
        System.out.println("\n### -5 -> compte 1 ###");
        c1.retrait(5);
        c1.afficherSolde();
        c2.afficherSolde();
        System.out.println("\n### compte 1 -> 100 -> compte 2 ###");
        c1.virer(100, c2);
        c1.afficherSolde();
        c2.afficherSolde();

        Compte[] comptes = new Compte[100];
        comptes[0] = c1;
        comptes[1] = c2;
        System.out.println(comptes.length);

        //Client
        Client client1 = new Client("Arthur");
        System.out.println("\ncomptes client 1 : ");
        for(Compte compte: client1.getComptes()){
            if (compte!=null){
                compte.afficherSolde();
            }
        }
        client1.ajouterCompte();
        client1.getComptes()[0].depot(50);
        client1.getComptes()[1].depot(100);
        System.out.println("\ncomptes client 1 : ");
        for(Compte compte: client1.getComptes()){
            if (compte!=null){
                compte.afficherSolde();
            }
        }
        client1.afficherSolde();

        //Banque
        System.out.println("");
        Banque banque1 = new Banque("banque");
        banque1.ajouterClient("Arthur2");
        banque1.getClients()[0].ajouterCompte();
        banque1.getClients()[0].getComptes()[1].depot(120);
        banque1.ajouterClient("Arthur3");

        System.out.println("détails compte Arthur2");
        banque1.bilanClient(banque1.getClients()[0]);
        System.out.println("détails tous comptes");
        banque1.afficherBilan();

         */


        //BanqueInteractive

        BanqueInteractive bi = new BanqueInteractive();
        bi.interaction();

        //renflouer()
        /*
        Client client1 = new Client("Arthur");
        client1.ajouterCompte();
        client1.ajouterCompte();
        client1.getComptes()[0].retrait(15);
        client1.getComptes()[1].depot(200);
        client1.getComptes()[2].depot(0);

        System.out.println("### avant renflouement ###");
        for (int i = 0; i<100; i++){
            if (client1.getComptes()[i]!=null){
                client1.getComptes()[i].afficherSolde();
            }
        }

        client1.renflouer();

        System.out.println("### après renflouement ###");
        for (int i = 0; i<100; i++){
            if (client1.getComptes()[i]!=null){
                client1.getComptes()[i].afficherSolde();
            }
        }

         */

    }
}
