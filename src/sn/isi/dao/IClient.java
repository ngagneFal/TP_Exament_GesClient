package sn.isi.dao;

import sn.isi.entité.Client;

import java.util.List;

public interface IClient {

    public int add (Client client) throws Exception;
    public int update (Client client, String email) throws Exception;
    public Client get (String email) throws Exception;
    public List<Client> getAll()throws Exception;
    public String equals(String email) throws Exception;

}
