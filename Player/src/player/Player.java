package player;

public class Player {
    private String name;
    private String club;
    private int matches;
    public Player(){
    }
    public Player(String name,String club){
        this.name = name;
        this.club = club;
        this.matches = 0;
    }
    public void setName(String name){
        this.name =name;
    }
    public String getName(){
        return name;
    }
    public void setClub(String club){
       System.out.println(name+" from "+this.club+" to "+club+", here we go confirmed!");
    }
    public String getClub(){
        return club;
    }
    public void playMatch(){
        matches++;
    }
    public int getMatches(){
        return matches;
    }
    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Club: "+club);
        System.out.println("Number of Matches: "+matches);
    }
    public static void main(String[] args) {
        GoalKeeper AlissonBecker = new GoalKeeper("Alisson Becker","Liverpool");
        AlissonBecker.playMacth(2);
        AlissonBecker.playMacth(0);
        AlissonBecker.displayInfo();
        Defender LisandroMartinez = new Defender("Lisandro Martinez","Manchester United");
        LisandroMartinez.playMatch(3,2);
        LisandroMartinez.playMatch(2,1);
        LisandroMartinez.playMatch(4,3);
        LisandroMartinez.playMatch(5,2);
        LisandroMartinez.displayInfo();
    }  
}