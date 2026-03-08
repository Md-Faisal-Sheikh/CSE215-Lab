package hotelroom;

public class RegularHotelRoom extends HotelRoom {
    private boolean hasWifi;
    private boolean hasAC;
    public RegularHotelRoom(){
    }
    public RegularHotelRoom(String roomNumber,double pricePerNight,int numberofBeds,boolean hasWifi,boolean hasAC){
         super(roomNumber,pricePerNight,numberofBeds);
         this.hasWifi = hasWifi;
         this.hasAC = hasAC;
    }
    public String getHasWifi(){
        return hasWifi ? "Yes":"No";
    }
    public String getHasAC(){
        return hasAC ? "Yes":"No";
    }
    @Override
    public void displayInfo(){
        super.displayInfo();;
        System.out.println("Has WiFi: "+getHasWifi());
        System.out.println("Has AC: "+getHasAC());
    }
    @Override
    public double calculateTotalPrice(int days){
        double totalPrice = super.calculateTotalPrice(days);
        if(hasWifi && hasAC){
            totalPrice += 1000 * days;
        }
        else if(hasWifi){
            totalPrice += 300 * days;
        }
         else if(hasAC){
            totalPrice += 700 * days;
        }
        return totalPrice;
    }
}
