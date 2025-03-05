package DataBase;

import java.io.*;

public class DataBase {
    private DataMap dataUser;

    public DataBase(){
        loadData();
    }

    public DataBase(DataMap dataUser){
        this.dataUser = dataUser;
        saveData();

    }

    public DataMap getDataUser(){
        return this.dataUser;
    }

    private void loadData() {
        try (FileInputStream input = new FileInputStream("DataBase/datauser.dat");
                ObjectInputStream objinput = new ObjectInputStream(input);) {
                dataUser = (DataMap) objinput.readObject();
                objinput.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void saveData() {
        try (FileOutputStream output = new FileOutputStream("DataBase/datauser.dat");
                ObjectOutputStream objoutput = new ObjectOutputStream(output);) {
                objoutput.writeObject(dataUser);
                objoutput.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
