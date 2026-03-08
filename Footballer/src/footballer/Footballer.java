package footballer;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Footballer {
    String name;
    String team;
    String position;
    int[] goals;
    int[] assists;
    
    public Footballer() {
        goals = new int[5];
        assists = new int[5];
    }
    
    public double averageGoalsPerMatch(){
        double sum = 0;
        for(int i=0;i<goals.length;i++){
            sum += goals[i];
        }
        return round(sum / goals.length);
    }
    public double averageAssistsPerMatch(){
        double sum = 0;
        for(int i=0;i<assists.length;i++){
            sum += assists[i];
        }
        return round(sum / assists.length);
    }
    public double averageGoalContributionsPerMacth(){
        return round(averageGoalsPerMatch() + averageAssistsPerMatch());
    }
    public double goalsToAssistRatio(){
        double avgGoals = averageGoalsPerMatch();
        double avgAssists = averageAssistsPerMatch();
        if(avgAssists == 0){
            return 0;
        }
        else
        {
            return round(avgGoals / avgAssists);
        }
    }
    private double round(double value){
        DecimalFormat df = new DecimalFormat("0.00");
        String roundedValue = df.format(value);
        return Double.parseDouble(roundedValue);
    }
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Footballer[] footballers = new Footballer[5];
      for(int i=0;i<footballers.length;i++){
          footballers[i] = new Footballer();
          System.out.print("Enter the name of player "+(i+1)+": ");
          footballers[i].name = input.nextLine();
          System.out.print("Enter the team of player "+(i+1)+": ");
          footballers[i].team = input.nextLine();
          System.out.print("Enter the position of player "+(i+1)+": ");
          footballers[i].position = input.nextLine();
          System.out.print("Enter the goals scored by player "+(i+1)+" in each match: ");
          for(int j=0;j<5;j++){
              footballers[i].goals[j] = input.nextInt();
          }
          System.out.print("Enter the assists scored by player "+(i+1)+" in each match: ");
          for (int j = 0; j<5; j++) {
                  footballers.assists[j] = input.nextInt();
          }
    }
        System.out.println("Total Matches | Goals Per Match | Assists Per Match | Goal Contribution Per Match | Goals to Assist Ratio");
              for(int i=0;i<footballers.length;i++) {
            System.out.println(footballer.name + " | " + "5" + " | " + footballer.averageGoalsPerMatch() + " | " + footballer.averageAssistsPerMatch() + " | " + footballer.averageGoalContributionsPerMacth() + " | " + footballer.goalsToAssistRatio());
        }
    }
}