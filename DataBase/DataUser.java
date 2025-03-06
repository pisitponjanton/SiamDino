package DataBase;

import java.io.*;
import java.util.ArrayList;

public class DataUser implements Serializable{
    private ArrayList<DataMap> dataUser;

    public DataUser(){
        dataUser = new ArrayList<>();
    }

    public ArrayList<DataMap> getDataUser(){
        return this.dataUser;
    }

    public void setDataUser(ArrayList<DataMap> dataUser){
        this.dataUser = dataUser;
    }
}
