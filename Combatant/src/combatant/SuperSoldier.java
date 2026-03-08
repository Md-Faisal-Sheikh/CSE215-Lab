package combatant;
import java.util.*;

public class SuperSoldier extends Combatant{
    public SuperSoldier(){
    }
    public SuperSoldier(String name,int health){
        super(name,health);
    }
    @Override
    public void performSpecialMove(Combatant k){
        int base_damage = 8;
        int additional_damage = new Random().nextInt(11);
        int total_damage = base_damage + additional_damage;
        System.out.println(SuperSoldier.super.getName()+" has caused "+total_damage+" points to "+k.getName()+" by Jawan Punch");
        k.healthDeplete(total_damage);
    }
}