package combatant;
import java.util.*;

public class Combatant {
    private String name;
    private int health;
    public Combatant(){
    }
    public Combatant(String name,int health){
        this.name = name;
        this.health = health;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public void recover(){
        this.health = 100;
    }
    public void displayDetails(){
        System.out.println("Name :"+name);
        System.out.println("Health :"+health);
    }
    public void performSpecialMove(Combatant k){
        System.out.println("Run it from the instance of the Child Class!");
    }
    public void healthDeplete(int damage){
        this.health -= damage;
        if(this.health < 0){
            this.health = 0;
        }
    }
    public static void main(String[] args) {
        Combatant k1 = new MartialArtist("Sujon Majhi",100);
        Combatant k2 = new SuperSoldier("Vikram Rathore",100);
        Combatant tiger = new SuperAgent("Tiger",100);
        int choice = (int)(Math.ceil(Math.random()*2));
        while(k1.getHealth() > 0 && k2.getHealth() > 0){
            if(choice == 1){
                k1.performSpecialMove(k2);
            }
            else if(choice == 2){
                k2.performSpecialMove(k1);
            }
            choice = (int)(Math.ceil(Math.random()*2));
        }
        Combatant kw = (k1.getHealth() > 0) ? k1:k2;
        kw.recover();
        choice = (int)(Math.ceil(Math.random()*2));
        while(kw.getHealth() > 0 && tiger.getHealth() > 0){
            if(choice == 1){
                 kw.performSpecialMove(tiger);
            }
            else if(choice == 2){
                 tiger.performSpecialMove(tiger);
            }
            choice = (int)(Math.ceil(Math.random()*2));
        }
        Combatant winner = (kw.getHealth() > 0) ? kw : tiger;
        System.out.println(winner.getName()+" wins!");
    }
}
            