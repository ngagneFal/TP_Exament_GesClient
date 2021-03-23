package main;

import sn.isi.dao.*;
import sn.isi.entité.Client;
import java.util.List;
import java.util.Scanner;

public class Main {
public  static void main (String [] args) throws Exception {


 DB db = new DB();

    Scanner scan = new Scanner(System.in);
    int menuChoice;
    String mainMenu = ("Select un choix : \n"
            + "1. Creation client\n"
            + "2. Edition \n"
            + "3. Visualisation\n"
            + "4. Recherche\n"
            + "5. Exit");

    do {
        String rep = null;
        System.out.println(mainMenu);
        menuChoice = scan.nextInt();


        switch (menuChoice)
        {
            case 1:


                    IClient userdao = new ClientImp();
                    Client client = new Client();
                    userdao.add(client);
                    System.out.print(":---------- Informations CLIENT  --------------\n,:");
                    System.out.println(" Le prénom du client  : "+ client.getPrenom());
                    System.out.println(" Le nom est du client  : "+ client.getNom());
                    System.out.println(" l'adresse email du client  : "+ client.getEmail());
                    System.out.println(" le téléphone du client  : "+ client.getTel());


                break;

            case 2 :
                Client client21 = new Client();
                IClient userdao12 = new ClientImp();
                userdao12.update(client21, client21.getEmail());
                List<Client> users =userdao12.getAll();
                for (Client u : users) {
                    if (u.getEmail().equals(client21.getEmail())) {
                        System.out.println(" nom : " + u.getNom() + "\n prenom : " + u.getPrenom() + " \n email : " + u.getEmail());
                    }
                }
                List<Client> userss =userdao12.getAll();
                for (Client u1 : userss){
                    System.out.println("nom : "+u1.getNom()+" prenom : "+u1.getPrenom()+" Email : "+u1.getEmail()+" Téléphone : "+u1.getTel());
                }
                break;

            case 3 :
                IClient userdao1 = new ClientImp();
                List<Client> clients =userdao1.getAll();
                for (Client u1 : clients){
                    System.out.println(" nom : "+u1.getNom()+"  prenom : "+u1.getPrenom()+" Tel   : "+u1.getTel()+" email : "+u1.getEmail());
                }
                break;

            case 4:
                Client client23 = new Client();
                IClient user32 = new ClientImp();
                user32.equals(client23.getEmail());
                break;
            default:
                System.out.print("Choix non disponible ");

        }


    } while (menuChoice != 5);

      }

}
