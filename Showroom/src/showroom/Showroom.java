package showroom;

public class Showroom {
    private String name;
    private String location;
    private double rent;
    public Showroom(){
    }
    public Showroom(String name,String location,double rent){
        this.name = name;
        this.location = location;
        this.rent = rent;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
    public void setRent(double rent){
        this.rent = rent;
    }
    public double getRent(){
        return rent;
    }
    public double calculateYearlyRent(){
        return rent*12;
    }
   
    public void displayInfo(){
        System.out.println("Name: "+getName());
        System.out.println("Location: "+getLocation());
        System.out.println("Yearly Rent: "+calculateYearlyRent());
    }
    public static void main(String[] args) {
          try{
              ElectronicsShowroom electronicsShowroom = new ElectronicsShowroom("bestelectronics","Mall",2000,"LG");
              electronicsShowroom.addItem("Television");
              electronicsShowroom.addItem("Refrigerator");
              electronicsShowroom.addItem("Microwave Oven");
              electronicsShowroom.displayInfo();
              System.out.println();
              JewelryShowroom jewelryShowroom = new JewelryShowroom("Aftab Jewellers","Panthapath",5000,"Gold");
              jewelryShowroom.addItem("Rings");
              jewelryShowroom.addItem("Earrings");
              jewelryShowroom.addItem("Necklaces");
              jewelryShowroom.displayInfo();
              }
              catch(UnapprovedItemException e){
                  System.out.println("Error: "+e.getMessage());
              }
    }
}