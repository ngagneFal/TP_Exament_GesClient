package sn.isi.dao;

import sn.isi.entité.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientImp implements IClient {
    DB db = new DB();
    Scanner scan = new Scanner(System.in);
    String input;



    @Override
    public int add(Client client) throws Exception {

        System.out.println("entrer les informations du Client : ");
        System.out.print("entrer le nom du client : ");
        client.setNom(scan.nextLine());
        System.out.print("entrer le prénom de client ");
        client.setPrenom(scan.nextLine());
        System.out.print("entrer l'email du client");
        client.setEmail(scan.nextLine());
        System.out.print("entrer le téléphone du client");
        client.setTel(scan.nextLine());
        db.open();
        String sql = "INSERT INTO client VALUES(NULL,?,?,?,?)";
        db.init(sql);
        db.getPstm().setString(1, client.getNom());
        db.getPstm().setString(2, client.getPrenom());
        db.getPstm().setString(3, client.getEmail());
        db.getPstm().setString(4, client.getTel());

        int ok = db.executeUpdate();
        return ok;


    }

    @Override
    public int update(Client client, String email) throws Exception {
        IClient userdao1 = new ClientImp();
        List<Client> users =userdao1.getAll();
      Client u = new Client();
        System.out.print("entrer l'email du client que tu veux modifiier : ");
        u.setEmail(scan.nextLine());

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

        return ok;
    }

    @Override
    public Client get(String email) throws Exception {
        IClient userdao = new ClientImp();
        Client client = new Client();
        client = null;
        db.open();
        String sql = "SELECT * FROM client";
        db.init(sql);
        db.getPstm().setString(4, email);
        ResultSet rs = db.executeSelect();
        if (rs.next()) {
            client = new Client();
            client.setNom(rs.getString(2));
            client.setPrenom(rs.getString(3));
            client.setEmail(rs.getString(4));
            client.setTel(rs.getString(5));

        }

        return client;
    }

    @Override
    public List<Client> getAll() throws Exception {
        List<Client> clients = new ArrayList<Client>();
        db.open();
        String sql = "SELECT * FROM client ";
        db.init(sql);
        ResultSet rs = db.executeSelect();
        while (rs.next()) {
            Client client = new Client();
            client.setNom(rs.getString(2));
            client.setPrenom(rs.getString(3));
            client.setEmail(rs.getString(4));
            client.setTel(rs.getString(5));
            client.setEmail(rs.getString(4));
            clients.add(client);
        }
        return clients;
    }

    @Override
    public String equals(String email) throws Exception {

        Client client = new Client();

        System.out.print("entrer l'email du client");
        client.setEmail(scan.nextLine());
        IClient userdao1 = new ClientImp();
        List<Client> clients =userdao1.getAll();
        for (Client u : clients){
             if (u.getEmail().equals(client.getEmail())){
                System.out.println(" nom : "+u.getNom()+" prenom : "+u.getPrenom()+" email : "+u.getEmail());
            }
        }
        return email;
    }


}
