package showroom;
import java.util.ArrayList;

public class JewelryShowroom extends Showroom {
    private String jewelryMaterial;
    private ArrayList<String> jewelryItems = new ArrayList<String>();
    private static final String[] authorizedJewelryItems = {"Necklaces","Rings","Earrings","Bracelets"};
    public JewelryShowroom(){
    }
    public JewelryShowroom(String name,String location,double rent,String jewelryMaterial){
        super(name,location,rent);
        this.jewelryMaterial = jewelryMaterial;
    }
    public void setMaterial(String jewelryMaterial){
        this.jewelryMaterial = jewelryMaterial;
        jewelryItems.clear();
    }
    public String getMaterial(){
        return jewelryMaterial;
    }
    public void addItem(String item) throws UnapprovedItemException {
        for(String authorizedJewelryItem : authorizedJewelryItems){
            if(item.equals(authorizedJewelryItem)){
                if(!jewelryItems.contains(item)){
                    jewelryItems.add(item);
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
        return super.calculateYearlyRent() + (jewelryItems.size()*250);
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Material: "+jewelryMaterial);
        System.out.println("Jewelry Items: ");
        for(String item:jewelryItems){
            System.out.println("- "+item);
        }
    }
}
