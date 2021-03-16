package main;

import sn.isi.dao.*;
import sn.isi.entité.Produit;
import sn.isi.entité.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
public  static void main (String [] args) throws Exception {
   DB db = new DB();
  //AJOUT utilisateur
   /* db.open();
    String sql ="INSERT INTO user VALUES(NULL,?,?,?,?)";
    db.init(sql);
    db.getPstm().setString(1,"Diallo");
    db.getPstm().setString(2,"Diallo");
    db.getPstm().setString(3,"Diallo123");
    db.getPstm().setString(4,"Alioune");
    int ok = db.executeUpdate();
    System.out.println(ok);*/

    System.out.println("*********************Delete - Utilisateur***************************");

    db.open();
    /* String sql ="DELETE FROM user WHERE id=?";
    db.init(sql);
    db.getPstm().setInt(1,1);
    ok = db.executeUpdate();*/


    System.out.println("*********************Update - Utilisateur***************************");
    /*IUser userdao = new UserImp();
    User user= new User();
    user.setId(1);
    user.setNom("Assane");  
    user.setPrenom("Fall");
    user.setEmail("Ngagne3");
    user.setPassword("Ngagne@gm");
    int ok= userdao.update(user);*/
   // System.out.println(ok);

    System.out.println("*********************Lister - UTILSATEUR***************************");
    /*IUser userdao = new UserImp();
    List<User> users =userdao.getAll();
    for (User u : users){
        System.out.println("id :"+u.getId() +", nom : "+u.getNom()+", prenom : "+u.getPrenom()+", email : "+u.getEmail());
    }*/


    System.out.println("*********************PRODUIT***************************");

    System.out.println("*********************AJOUT - PRODUIT***************************");
   /* Produit produit = new Produit();
    db.open();
    String sql ="INSERT INTO produits VALUES(NULL,?,?,?)";
    db.init(sql);

    db.getPstm().setString(1,"lait");
    db.getPstm().setString(2,"gloria");
    db.getPstm().setInt(3,12233);
    int ok = db.executeUpdate();*/
    /*
    System.out.println("*********************Delete - PRODUIT***************************");
    db.open();
    String  sql ="DELETE FROM produits WHERE id=?";
    db.init(sql);
    db.getPstm().setInt(1,2);
    int ok = db.executeUpdate();
*/
    System.out.println("*********************UPDATE - PRODUIT***************************");
    /*IProduit userdao1 = new ProduitImp();
    Produit produit = new Produit();
    produit.setId(3);
    produit.setRef("riz");
    int ok= userdao1.update(produit);*/

   /* IProduit userdao = new ProduitImp();
    List<Produit> produits = userdao.getAll();
    for (Produit u : produits){
        System.out.println("id :"+u.getId() +", referent : "+u.getRef()+", nom : "+u.getNom());
    }*/
}
}
