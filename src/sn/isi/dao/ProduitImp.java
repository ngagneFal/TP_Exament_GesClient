package sn.isi.dao;

import sn.isi.entité.Produit;
import sn.isi.entité.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduitImp implements IProduit{
    DB db = new DB();
    @Override
    public int add(Produit produit) throws Exception {
        User user =new User();
        db.open();
        String sql ="INSERT INTO produit VALUES(NULL,?,?,?)";
        db.init(sql);
        db.getPstm().setString(1,produit.getRef());
        db.getPstm().setString(2,produit.getNom());
        db.getPstm().setInt(2,produit.getUser().getId());
        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public int delete(int id) throws Exception {
        db.open();
        String sql ="DELETE FROM produit WHERE id=?";
        db.init(sql);
        db.getPstm().setInt(1,id);

        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public int update(Produit produit) throws Exception {
        this.db.open();
        String sql = "UPDATE produits SET ref= ?,nom= ? WHERE id= ?";
        this.db.init(sql);
        this.db.getPstm().setInt(1, produit.getId());
        this.db.getPstm().setString(2, produit.getRef());
        this.db.getPstm().setString(3, produit.getNom());

        int ok = this.db.executeUpdate();
        return ok;
    }

    @Override
    public List<Produit> getAll() throws Exception {
        List<Produit> produits = new ArrayList();
        this.db.open();
        String sql = "SELECT * FROM produits ";
        this.db.init(sql);
        ResultSet rs = this.db.executeSelect();

        while(rs.next()) {
            Produit produit = new Produit();
            produit.setId(rs.getInt(1));
            produit.setRef(rs.getString(2));
            produit.setNom(rs.getString(3));
            produits.add(produit);
        }

        return produits;
    }

    @Override
    public Produit get(int id) throws Exception {
        Produit produit = null;
        this.db.open();
        String sql = "SELECT * FROM produit WHERE nom LIKE ? ";
        this.db.init(sql);
        this.db.getPstm().setInt(1, id);
        ResultSet rs = this.db.executeSelect();
        if (rs.next()) {
            produit = new Produit();
            produit.setId(rs.getInt(1));
            produit.setRef(rs.getString(2));
            produit.setNom(rs.getString(3));
        }

        return produit;
    }
}
