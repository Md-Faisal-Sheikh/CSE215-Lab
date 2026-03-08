package pokemon;
import java.util.Random;

public class WaterPokemon implements Pokemon {
    private String name;
    private int level;
    public WaterPokemon(){
    }
    public WaterPokemon(String name,int level){
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
            System.out.println(name+" has used Water Gun");
        }
        else if(choice == 2){
            System.out.println(name+" has used Bubble");
        }
        else if(choice == 3){
            System.out.println(name+" has used Aqua Jet");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: "+name);
        System.out.println("Type: Water");
        System.out.println("Level: "+level);
    }    
}