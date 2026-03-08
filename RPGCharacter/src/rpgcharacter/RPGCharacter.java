package rpgcharacter;

public class RPGCharacter {
    static String name;
    static int level;
    static int healthPoints;
    public RPGCharacter(){
        this.name = "NPC";
        this.level = 1;
        this.healthPoints = 10;
    }
    public RPGCharacter(String name,int level,int healthPoints){
        this.name = name;
        this.level =level;
        this.healthPoints = healthPoints;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
    public void sethealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }
    public int gethealthPoints(){
        return healthPoints;
    }
    public static class Archer extends RPGCharacter {
        private int accuracy;
        public Archer(String name,int level,int healthPoints,int accuracy){
            super(name,level,healthPoints);
            this.accuracy = accuracy;
        }
        public void shootEnemy(){
            System.out.println(this.getName()+" has shot an arrow to the enemy");
        }
        public void increaseAccuracy(){
            this.accuracy += 10+this.getLevel()*2;
            System.out.println("Accuracy Increment is Successful for "+this.getName());
        }
    }
    public static class Wizard extends RPGCharacter {
        private int magicPoints;
        public Wizard(String name,int level,int healthPoints,int magicPoints){
             super(name,level,healthPoints);
             this.magicPoints = magicPoints;
        }
             public void castSpells(int choice){
                 if(choice == 1){
                     castFire();           
                 }
                 else if(choice == 2){
                     castIce();
                 }
                 else if(choice == 3){
                     castThunder();
                 }
             }
             private void castFire(){
                 System.out.println(this.name+" has used fire magic towards an enemy");
             }
             private void castIce(){
                 System.out.println(this.name+" has used ice magic towards an enemy");
             }
             private void castThunder(){
                 System.out.println(this.name+" has used thunder magic towards an enemy");
             }
        }
    public static class Gunner extends RPGCharacter {
        private int precision;
          public Gunner(String name,int level,int healthPoints,int precision){
             super(name,level,healthPoints);
             this.precision = precision;
    }
        public void shootEnemy(){
            System.out.println(this.getName()+" has shot a bullet to the enemy");
        }
        public void increasePrecision(){
            this.precision += 5+this.level;
            System.out.println("Precision Increment is Successful for "+this.getName());
        }
    }  
    public static class Warrior extends RPGCharacter {
        private int attackPoints;
           public Warrior(String name,int level,int healthPoints,int attackPoints){
             super(name,level,healthPoints);
             this.attackPoints = attackPoints;
    }
        public void attackEnemy(){
            System.out.println(this.getName()+" has attacked an enemy");
        }
        public void partyAttack(){
            System.out.println(this.getName()+" has parried an attack");
        }
        public void boostAttack(){
            this.attackPoints += 10;
            System.out.println("Attack Point Increment is Successful for "+this.getName());
        }
    }
    public static void main(String[] args) {
       Archer archer = new Archer("Archer",2,5,9);
       archer.shootEnemy();
       archer.increaseAccuracy();
       
       Wizard wizard = new Wizard("Wizard",2,5,9);
       wizard.castSpells(1);
       wizard.castSpells(2);
       wizard.castSpells(3);
       
       Gunner gunner = new Gunner("Gunner",2,5,9);
       gunner.shootEnemy();
       gunner.increasePrecision();
       
       Warrior warrior = new Warrior("Warrior",2,5,9);
       warrior.attackEnemy();
       warrior.partyAttack();
       warrior.boostAttack();
    }
}