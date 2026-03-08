package hotelroom;

public class HotelRoom {   
    private String roomNumber;
    private double pricePerNight;
    private int numberofBeds;
    public HotelRoom(){
    }
    public HotelRoom(String roomNumber,double pricePerNight,int numberofBeds){
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.numberofBeds = numberofBeds;
    }
    public void setRoomNumber(String room){
        this.roomNumber = room;
    }
    public String getRoomNumber(){
        return roomNumber;
    }
    public void setPricePerNight(double price){
        this.pricePerNight = price;
    }
    public double getPricePerNight(){
        return pricePerNight;
    }
    public void setNumberofBeds(int beds){
        this.numberofBeds = beds;
    }
    public int getNumberofBeds(){
        return numberofBeds;
    }
    public void displayInfo(){
        System.out.println("Room Number: "+roomNumber);
        System.out.println("Price Per Night: "+pricePerNight);
        System.out.println("Number of Beds: "+numberofBeds);
    }
    public double calculateTotalPrice(int days){
        return pricePerNight * days;
    }
    public static void main(String[] args) {
        HotelRoom hotelroom = new HotelRoom("50",200,3);
        hotelroom.displayInfo();
        System.out.println("Total Price for 2 days: "+hotelroom.calculateTotalPrice(2));
        RegularHotelRoom regularhotelroom = new RegularHotelRoom("90",210,2,true,true);
        regularhotelroom.displayInfo();
        System.out.println("Total Price for 3 days: "+regularhotelroom.calculateTotalPrice(3));
    }   
}