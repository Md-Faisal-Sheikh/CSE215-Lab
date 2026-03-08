package movie;

public class ComedyMovie extends Movie implements ComedyPreRequisites {
    private double humourRating;
    private double cringeRating;
    public ComedyMovie(){
    }
    public ComedyMovie(String name,String language,String leadActor){
        super(name,language,leadActor);
    }  
    @Override
    public void setHumourRating(int rating) throws IllegalArgumentException {
        if(rating >= 0 && rating <= 10){
            this.humourRating = rating;
        }
        else{
            throw new IllegalArgumentException("Humour rating must be between 0 and 10");
        }
    }
    @Override
    public void setCringeRating(int rating) throws IllegalArgumentException {
        if(rating >= 0 && rating <= 10){
            this.cringeRating = rating;
        }
        else{
            throw new IllegalArgumentException("Cringe rating must be between 0 and 10");
        }
    }
    @Override
    public double getAverageRating(){
        return (humourRating + cringeRating)/2;
        
    }   
    @Override
    public void displayInfo() {
        System.out.println("Name :"+getName());
        System.out.println("Language :"+getLanguage());
        System.out.println("Lead Actor :"+getLeadActor());
        System.out.println("Humour Rating :"+humourRating);
        System.out.println("Cringe Rating :"+cringeRating);
        System.out.println("Average Rating :"+getAverageRating());
    }
}