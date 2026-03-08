package movie;

public abstract class Movie {
    private String name;
    private String language;
    private String leadActor;  
    public Movie(){
    }
    public Movie(String name,String language,String leadActor){
        this.name = name;
        this.language = language;
        this.leadActor = leadActor;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return language;
    }
    public void setLeadActor(String leadAction){
        this.leadActor = leadAction;
    }
    public String getLeadActor(){
        return leadActor;
    }
}