package player;

public class GoalKeeper extends Player {
    private int cleanSheets;
    private int goalsConceded;
    private int totalGoalsConceded;
    public GoalKeeper(){
        this.cleanSheets = 0;
        this.goalsConceded = 0;
        this.totalGoalsConceded = 0;
    }
    public GoalKeeper(String name,String club){
        super(name,club);
        this.cleanSheets = 0;
        this.goalsConceded = 0;
        this.totalGoalsConceded = 0;
    }
    public int getCleanSheets(){
        return cleanSheets;
    }
    public int getGoalsConceded(){
        return goalsConceded;
    }
    public void playMacth(int goalsConcededForMatch){
        if(goalsConcededForMatch == 0)
        {
            cleanSheets++;
        }
        else
        {
            goalsConceded += goalsConcededForMatch;
            totalGoalsConceded += goalsConcededForMatch;
        }
        super.playMatch();
    }
    public double getGoalsConcededPerMatch(){
        if(super.getMatches()==0)
        {
            return 0.0;
        }
        else
        {
            return (double)totalGoalsConceded/getMatches();
        }
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Total Goals Conceded: "+totalGoalsConceded);
        System.out.println("Clean Sheets: "+cleanSheets);
        System.out.println("Goals Conceded Per Match: "+getGoalsConcededPerMatch());
    }
}
