package main;

import sn.isi.dao.*;
import sn.isi.entité.User;
import java.util.List;
import java.util.Scanner;

public class Main {
public  static void main (String [] args) throws Exception {


 DB db = new DB();
        int menuAccueil = 4;
        String rep = null;
      Scanner scan = new Scanner(System.in);
      System.out.print(": ---------1 CRÉATION  ---------------\n,");
      System.out.print(":----------2 ÉDITION ------------------ \n,:");
      System.out.print(":----------3 VISUALISATIOION ----------\n,:");
      System.out.print(":----------4 RECHERCHE   --------------\n,:");

      menuAccueil  = Integer.parseInt(scan.nextLine());
      switch (menuAccueil)
      {
       case 1:
           do {

               IUser userdao = new UserImp();
               User user= new User();
               userdao.add(user);
               System.out.print(":---------- Informations CLIENT  --------------\n,:");
               System.out.println(" Le prénom du client  : "+user.getPrenom());
               System.out.println(" Le nom est du client  : "+user.getNom());
               System.out.println(" l'adresse email du client  : "+user.getEmail());
               System.out.println(" le téléphone du client  : "+user.getTel());
               System.out.println(" voulez vous saisir");
               rep=scan.nextLine();

           }while(rep.equalsIgnoreCase("oui"));
        break;

        case 2 :
        User user21= new User();
        System.out.print("entrer l'email du client que tu veux modifiier : ");
        user21.setEmail(scan.nextLine());
        IUser userdao12 = new UserImp();
        userdao12.update(user21, user21.getEmail());
        List<User> userss =userdao12.getAll();
        for (User u1 : userss){

            System.out.println("nom : "+u1.getNom()+" prenom : "+u1.getPrenom()+" Email : "+u1.getEmail()+" Téléphone : "+u1.getTel());
        }
        break;

        case 3 :
        IUser userdao1 = new UserImp();
         List<User> users =userdao1.getAll();
         for (User u1 : users){
          System.out.println(" nom : "+u1.getNom()+" / prenom : "+u1.getPrenom()+" Tel  / : "+u1.getTel()+" email /: "+u1.getEmail());
         }
        break;

        case 4:
        User user23= new User();
        IUser user32 = new UserImp();
        user32.equals(user23.getEmail());
        break;
              default:
                  System.out.print("Choix non disponible ");

              }

      }

}
