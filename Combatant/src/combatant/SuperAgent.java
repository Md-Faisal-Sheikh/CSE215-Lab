package combatant;
import java.util.*;

public class SuperAgent extends Combatant{
    public SuperAgent(){    
    }
    public SuperAgent(String name,int health){
        super(name,health);
    }
    @Override
    public void performSpecialMove(Combatant k){
        int base_damage = 9;
        int additional_damage = new Random().nextInt(9);
        int total_damage = base_damage + additional_damage;
        System.out.println(SuperAgent.super.getName()+" has struck "+k.getName()+" with the Tiger Drive Shot and caused "+total_damage+" points.");
        k.healthDeplete(total_damage);
    }
}
