package DataBase;

import java.io.*;

public class DataBase {
    private DataUser dataUser;

    public DataBase(){
        loadData();
        if (dataUser == null) {
            dataUser = new DataUser();
        }
    }

    public DataBase(DataUser dataUser){
        this.dataUser = dataUser;
        saveData();
    }

    public DataUser getDataUser(){
        return this.dataUser;
    }

    private void loadData() {
        try (FileInputStream input = new FileInputStream("DataBase/datauser.dat");
                ObjectInputStream objinput = new ObjectInputStream(input);) {
                dataUser = (DataUser) objinput.readObject();
                objinput.close();
                System.out.println("LoadData");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void saveData() {
        try (FileOutputStream output = new FileOutputStream("DataBase/datauser.dat");
                ObjectOutputStream objoutput = new ObjectOutputStream(output);) {
                objoutput.writeObject(dataUser);
                objoutput.close();
                System.out.println("SaveData");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
