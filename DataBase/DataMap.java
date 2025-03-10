package DataBase;

import java.io.*;
import java.util.*;

public class DataMap  implements Serializable{
    private String name;
    private int max_character = 5;
    private double money = 10000;
    private int level = 1;
    private int exp = 0;
    private HashMap<String, Object> animal;
    private Integer[] animal_cage;
    private HashMap<String, Object> market;

    public DataMap(String name){
        this.name = name;

        animal = new HashMap<>();
        for (int i = 0; i < 7 ;i++) {
            String str = "Animal_"+(i+1);
            HashMap<String, Object> animal_new = new HashMap<>();
            if(i == 0){
                animal_new.put("Level", 1);
            }else{
                animal_new.put("Level", 0);
            }
            animal_new.put("Evo", 0);
            animal.put(str, animal_new);
        }

        animal_cage = new Integer[7];
        for(int i = 0; i < animal_cage.length ; i++){
            animal_cage[i] = 1;
        }

        market = new HashMap<>();
        for (int i = 0; i < 3 ;i++) {
            String str = "Market_"+(i+1);
            HashMap<String, Integer> market_new = new HashMap<>();
            market_new.put("Level", 0);
            market_new.put("Evo", 1);
            market_new.put("Profit", 150);
            market.put(str, market_new);
        }
    }

    public HashMap<String, Object> getAnimal(){
        return this.animal;
    }

    public void setAnimal(HashMap<String, Object> animal){
        this.animal = animal;
    }

    public Integer[] getAnimal_Cage(){
        return this.animal_cage;
    }

    public void setAnimal_Cage(Integer[] animal_cage){
        this.animal_cage = animal_cage;
    }

    public HashMap<String, Object> getMarket(){
        return this.market;
    }

    public void setMarket(HashMap<String, Object> market){
        this.market = market;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getMax_Character(){
        return this.max_character;
    }

    public void setMax_Character(int max_character){
        this.max_character = max_character;
    }

    public double getMoney(){
        return this.money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getExp(){
        return this.exp;
    }

    public void setExp(int exp){
        this.exp = exp;
    }
}
