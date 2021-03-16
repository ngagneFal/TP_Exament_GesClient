package sn.isi.dao;

import sn.isi.entité.Produit;
import sn.isi.entité.User;

import java.util.List;

public interface IProduit {
    public  int add (Produit produit) throws Exception;
    public int delete (int id) throws Exception;
    public int update (Produit produit) throws Exception;
    public List<Produit> getAll()throws Exception;
    public  Produit get (int id) throws Exception;

}
