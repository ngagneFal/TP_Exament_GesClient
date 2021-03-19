package sn.isi.dao;

import sn.isi.entité.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImp  implements IUser {
    DB db = new DB();
    Scanner scan = new Scanner(System.in);
    String input;



    @Override
    public int add(User user) throws Exception {

        System.out.println("entrer les informations du Client : ");
        System.out.print("entrer le nom du client : ");
        user.setNom(scan.nextLine());
        System.out.print("entrer le prénom de client ");
        user.setPrenom(scan.nextLine());
        System.out.print("entrer l'email du client");
        user.setEmail(scan.nextLine());
        System.out.print("entrer le téléphone du client");
        user.setTel(scan.nextLine());
        db.open();
        String sql = "INSERT INTO client VALUES(NULL,?,?,?,?)";
        db.init(sql);
        db.getPstm().setString(1, user.getNom());
        db.getPstm().setString(2, user.getPrenom());
        db.getPstm().setString(3, user.getEmail());
        db.getPstm().setString(4, user.getTel());

        int ok = db.executeUpdate();
        return ok;


    }

    @Override
    public int update(User user , String email) throws Exception {

        IUser userdao1 = new UserImp();
        List<User> users =userdao1.getAll();
        for (User u : users){
            if (u.getEmail().equals(user.getEmail())){
                System.out.println(" nom : "+u.getNom()+"\n prenom : "+u.getPrenom()+" \n email : "+u.getEmail());
                System.out.print("-----------------MODIFICATION CLIENT------------\n ");
                System.out.println("------------------------------------------ : \n ");
                System.out.println("----Entrer les informations du client---- : \n ");
                System.out.print("entrer le nom du client : ");
                u.setNom(scan.nextLine());
                System.out.print("entrer le prénom de client  ");
                u.setPrenom(scan.nextLine());
                System.out.print("entrer le téléphone du client: ");
                u.setTel(scan.nextLine());
                db.open();
                String sql = "UPDATE client SET " + " nom= ?,prenom= ?,tel= ? WHERE email=?";
                db.init(sql);
                db.getPstm().setString(1, u.getNom());
                db.getPstm().setString(2, u.getPrenom());
                db.getPstm().setString(3, u.getTel());
                db.getPstm().setString(4, u.getEmail());
                int ok = db.executeUpdate();
            }

        }
        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public User get(String email) throws Exception {
        IUser userdao = new UserImp();
        User user = new User();
        user = null;
        db.open();
        String sql = "SELECT * FROM client";
        db.init(sql);
        db.getPstm().setString(4, email);
        ResultSet rs = db.executeSelect();
        if (rs.next()) {
            user = new User();
            user.setNom(rs.getString(2));
            user.setPrenom(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setTel(rs.getString(5));

        }

        return user;
    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<User>();
        db.open();
        String sql = "SELECT * FROM client ";
        db.init(sql);
        ResultSet rs = db.executeSelect();
        while (rs.next()) {
            User user = new User();
            user.setNom(rs.getString(2));
            user.setPrenom(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setTel(rs.getString(5));
            user.setEmail(rs.getString(4));
            users.add(user);
        }
        return users;
    }

    @Override
    public String equals(String email) throws Exception {

        User user = new User();

        System.out.print("entrer l'email du client");
        user.setEmail(scan.nextLine());
        IUser userdao1 = new UserImp();
        List<User> users =userdao1.getAll();
        for (User u : users){
             if (u.getEmail().equals(user.getEmail())){
                System.out.println(" nom : "+u.getNom()+" prenom : "+u.getPrenom()+" email : "+u.getEmail());
            }
        }
        return email;
    }


}
