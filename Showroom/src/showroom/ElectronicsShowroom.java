package showroom;
import java.util.ArrayList;

public class ElectronicsShowroom extends Showroom {
    private String electronicsBrand;
    private ArrayList<String> electronicsItems = new ArrayList<String>();
    private static final String[] authorizedElectronicsItems = {"Television","Refrigerator","Microwave Oven","Rice Cooker","Toaster"};
    public ElectronicsShowroom(){
    }
    public ElectronicsShowroom(String name,String location,double rent,String electronicsBrand){
        super(name,location,rent);
        this.electronicsBrand = electronicsBrand;
    }
    public void setElecBrand(String electronicsBrand){
        this.electronicsBrand = electronicsBrand;
        electronicsItems.clear();
    }
    public String getElecBrand(){
        return electronicsBrand;
    }
    public void addItem(String item) throws UnapprovedItemException {
        for(String authorizedElecItem : authorizedElectronicsItems){
            if(item.equals(authorizedElecItem)){
                if(!electronicsItems.contains(item)){
                    electronicsItems.add(item);
                    return;
                }
                else{
                      throw new UnapprovedItemException("Item already exists in the showroom");
                }
            }
        }
        throw new UnapprovedItemException("Item is not authorized for an electronics showroom.");
    }
    @Override
    public double calculateYearlyRent(){
        return super.calculateYearlyRent() + (electronicsItems.size()*750);
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Electronics Brand: "+electronicsBrand);
        System.out.println("Electronics Items: ");
        for(String item:electronicsItems){
            System.out.println("- "+item);
        }
    }
}
