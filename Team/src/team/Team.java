package team;

public class Team {
        private String Teamname;
        private String Coachname;
        private String Homecountry;
        private final String[] Players;
        private int Currentnumofplayers;
        private final int MAX_PLAYERS = 7;
        
        public Team (String Teamname ,String Coachname,String Homecountry){
            this.Teamname = Teamname;
            this.Coachname = Coachname;
            this.Homecountry = Homecountry;
            this.Players = new String[MAX_PLAYERS];
            this.Currentnumofplayers = 0;        
        }
        public void setTeamname(String Teamname){
            this.Teamname = Teamname;
        }  
        public void setCoachname(String Coachname){
            this.Coachname = Coachname;
        }  
        public void setHomecountry(String Homecountry){
            this.Homecountry = Homecountry;
        }  
        public String getTeamname(){
            return this.Teamname;
        }  
        public String getCoachname(){
            return this.Coachname;
        }  
        public String getHomecountry(){
            return this.Homecountry;
        }
        public void addPlayer(String Playername)
        {
            if(Currentnumofplayers < MAX_PLAYERS)
            {
                Players[Currentnumofplayers] = Playername;
                Currentnumofplayers++;
            }
            else
            {
                System.out.println("Cannot add more players , maximum number of players reached.");
            }
        }
        public void removePlayer(String Playername)
        {
            for(int i=0;i<Currentnumofplayers;i++)
            {
                if(Players[i].equals(Playername))
                {
                    for(int j=i;j<Currentnumofplayers-1;j++)
                    {
                        Players[j] = Players[j+1];
                        Currentnumofplayers--;
                        break;
                    }
                }
            }
        }
        
       public void printTeamDetails(){
       System.out.println("Team name : "+Teamname);
       System.out.println("Coach name : "+Coachname);
       System.out.println("Home Country : "+Homecountry);
       System.out.println("Players : ");
       for(int i=0;i<Currentnumofplayers;i++)
       {
           System.out.println(Players[i]);
       }
       }
    public static void main(String args[])
    {
           Team myteam = new Team("Sydney Sixers","Greg Shipperd","Australia");
           myteam.addPlayer("Dan Christian");
           myteam.addPlayer("Mickey Edwards");
           myteam.addPlayer("Jackson Bird");
           myteam.addPlayer("Chris Jordan");
           myteam.addPlayer("Nathan Lyon");
           myteam.addPlayer("James Vince");
           myteam.addPlayer("Moises Henriques");
           myteam.printTeamDetails();
    }
}