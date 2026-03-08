package pirate;

public class Captain extends Pirate{
    private boolean ownsShip = false;
    private Ship ownedShip;
    
    public Captain(){
    }
    public Captain(String name,String country){
        super(name,country);
    }
    public void ownShip(Ship ship){
        this.ownsShip = true;
        this.ownedShip = ship;
    }
    public void disownShip(){
        this.ownsShip = false;
        this.ownedShip = null;
    }
    public void getShipDetails(){
        if(this.ownsShip){
            ownedShip.displayDetails();
        }
        else{
            System.out.println("The pirate captain does not own a ship");
        }
    }
}
