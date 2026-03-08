package movie;

public class ActionMovie extends Movie implements ActionPreRequisites {
    private double intensityRating;
    private double boringRating;
    public ActionMovie(){
    }
    public ActionMovie(String name,String language,String leadActor){
        super(name,language,leadActor);
    }  
    @Override
    public void setIntensityRating(int rating) throws IllegalArgumentException {
        if(rating >= 0 && rating <= 10){
            this.intensityRating = rating;
        }
        else{
            throw new IllegalArgumentException("Intensity rating must be between 0 and 10");
        }
    }
    @Override
    public void setBoringRating(int rating) throws IllegalArgumentException {
        if(rating >= 0 && rating <= 10){
            this.boringRating = rating;
        }
        else{
            throw new IllegalArgumentException("Boring rating must be between 0 and 10");
        }
    }
    @Override
    public double getAverageRating(){
        return (intensityRating + boringRating)/2;
        
    }   
    @Override
    public void displayInfo() {
        System.out.println("Name :"+getName());
        System.out.println("Language :"+getLanguage());
        System.out.println("Lead Actor :"+getLeadActor());
        System.out.println("Intensity Rating :"+intensityRating);
        System.out.println("Boring Rating :"+boringRating);
        System.out.println("Average Rating :"+getAverageRating());
    }
}