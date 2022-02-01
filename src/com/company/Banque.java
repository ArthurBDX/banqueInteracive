package com.company;

public class Banque {
    private String nom;
    private Client[] clients = new Client[100];

    public Banque() {
    }

    public Banque(String nom) {
        this.nom = nom;
    }

    public Client[] getClients(){
        return clients;
    }

    void ajouterClient(String nom){
        for(int i = 0; i <100; i++){
            if (clients[i]==null){
                clients[i]=new Client(nom);
                i=100;
            }
        }
    }

    void bilanClient(Client client){
        for(Compte compte: client.getComptes()){
            if (compte!=null){
                compte.afficherSolde();
            }
        }
    }

    void afficherBilan(){
        for(Client client: clients){
            if (client != null) {
                client.afficherSolde();
            }
        }
    }

    void renflouer(){
        for(int i = 0; i<100; i++){
            if (getClients()[i]!=null){
                getClients()[i].renflouer();
            }
        }
    }

}
