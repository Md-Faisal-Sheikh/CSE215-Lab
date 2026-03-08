package movie;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Movie> movie = new HashMap<String, Movie>();
        ActionMovie actionMovie1 = new ActionMovie("ActionMovie1","English","LeadActor1");
        ActionMovie actionMovie2 = new ActionMovie("ActionMovie2","Spanish","LeadActor2");
        ActionMovie actionMovie3 = new ActionMovie("ActionMovie3","Portuguese","LeadActor3");
        ComedyMovie comedyMovie1 = new ComedyMovie("ComedyMovie1","English","LeadActor1");
        ComedyMovie comedyMovie2 = new ComedyMovie("ComedyMovie2","Spanish","LeadActor2");
        ComedyMovie comedyMovie3 = new ComedyMovie("ComedyMovie3","Portuguese","LeadActor3");
        try{
            actionMovie1.setIntensityRating(9);
            actionMovie1.setBoringRating(7);
            actionMovie2.setIntensityRating(7);
            actionMovie2.setBoringRating(5);
            actionMovie3.setIntensityRating(9);
            actionMovie3.setBoringRating(5);
            comedyMovie1.setHumourRating(9);
            comedyMovie1.setCringeRating(7);
            comedyMovie2.setHumourRating(7);
            comedyMovie2.setCringeRating(5);
            comedyMovie3.setHumourRating(9);
            comedyMovie3.setCringeRating(5);
        }
        catch(IllegalArgumentException e){
            System.out.println("Error :"+e.getMessage());
        }
        movie.put(actionMovie1.getName(), actionMovie1);
        movie.put(actionMovie2.getName(), actionMovie2);
        movie.put(actionMovie3.getName(), actionMovie3);
        movie.put(comedyMovie1.getName(), comedyMovie1);
        movie.put(comedyMovie2.getName(), comedyMovie2);
        movie.put(comedyMovie3.getName(), comedyMovie3);
        for(Movie movies : movie.values()){
            if(movies instanceof ActionMovie){
                ((ActionMovie)movies).displayInfo();
            }
            else if(movies instanceof ComedyMovie){
                ((ComedyMovie)movies).displayInfo();
            }
            System.out.println();
        }
   }
}