package pirate;

public class Pirate {
    private String pirateName;
    private String country;
    public Pirate(){
    }
    public Pirate(String name,String country){
        this.pirateName = name;
        this.country = country;
    }
    public void SetPirateName(String pirateName){
        this.pirateName = pirateName;
    }
    public String GetPirateName(){
        return this.pirateName;
    }
    public void SetCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {  
            Ship ship1 = new Ship("Flying Dutchman");
            Ship ship2 = new Ship("Achille Lauro");
            Captain captain = new Captain("Christopher","Italian");
            captain.ownShip(ship1);
            captain.getShipDetails();;
            captain.disownShip();
            captain.getShipDetails();
            captain.ownShip(ship2);
            captain.getShipDetails();
   }   
}