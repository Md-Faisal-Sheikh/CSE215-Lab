package pokemon;
import java.util.Random;

public class ElectricPokemon implements Pokemon {
    private String name;
    private int level;
    public ElectricPokemon(){
    }
    public ElectricPokemon(String name,int level){
        this.name = name;
        this.level = level;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public void attack() {
        int choice = (int)(Math.ceil(3*Math.random()));
        if(choice == 1){
            System.out.println(name+" has used Thunder Shock");
        }
        else if(choice == 2){
            System.out.println(name+" has used Shock Wave");
        }
        else if(choice == 3){
            System.out.println(name+" has used Charge Beam");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: "+name);
        System.out.println("Type: Electric");
        System.out.println("Level: "+level);
    }    
}
