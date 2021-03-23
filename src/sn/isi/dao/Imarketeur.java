package sn.isi.dao;

import sn.isi.entité.Client;
import sn.isi.entité.Marketeur;

import java.util.List;

public interface Imarketeur {
    public int add (Marketeur marketeur) throws Exception;
    public int update (Marketeur marketeur, String email) throws Exception;
    public Marketeur get (String email) throws Exception;
    public List<Marketeur> getAll()throws Exception;
    public String equals(String email) throws Exception;
}
