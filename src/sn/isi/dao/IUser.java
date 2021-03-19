package sn.isi.dao;

import sn.isi.entité.User;

import java.util.List;

public interface IUser {
    public int add (User user) throws Exception;
    public int update (User user , String email) throws Exception;
    public  User get (String email) throws Exception;
    public List<User> getAll()throws Exception;
    public String equals(String email) throws Exception;
}
