package combatant;
import java.util.*;

public class MartialArtist extends Combatant{
    public MartialArtist(){
    }
    public MartialArtist(String name,int health){
       super(name,health);
    }  
    @Override
    public void performSpecialMove(Combatant k){
        int base_damage = 10;
        int additional_damage = new Random().nextInt(6);
        int total_damage = base_damage + additional_damage;
        System.out.println(MartialArtist.super.getName()+" has performed the Majhi Smacker to "+k.getName()+ " by "+total_damage+ " points");
        k.healthDeplete(total_damage);
    }
}