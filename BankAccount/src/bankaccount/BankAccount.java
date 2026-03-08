package bankaccount;

public class BankAccount {
    private String name;
    private String branch;
    private double bankBalance;
    private static int numberofAccounts = 0;
    private static double totalAmount = 0;
    private static double avgAmount = 0;
    public BankAccount(String name,String branch,double bankBalance){
        this.name = name;
        this.branch = branch;
        this.bankBalance = bankBalance;
        numberofAccounts++;
        totalAmount += bankBalance;
        avgAmount = totalAmount / numberofAccounts;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getname(){
        return name;
    }
      public void setBranch(String branch){
        this.branch = branch;
    }
    public String getBranch(){
        return branch;
    }
      public void setBankBalance(double bankBalance){
        totalAmount -= this.bankBalance;
        this.bankBalance = bankBalance;
        totalAmount += bankBalance;
        avgAmount = totalAmount / numberOfAccounts;
    }
    public String getBankBalance(){
        return bankBalance;
    }
    public static double getTotalAmount(){
        return totalAmount;
    }
    public static double getAvgAmount(){
        return avgAmount;
    }
    public static void main(String[] args) {
           BankAccount client1 = new BankAccount("Mehrab","Dhaka",2000);
           BankAccount client2 = new BankAccount("Fahim","Faridpur",1000);
           BankAccount client3 = new BankAccount("Sakib","Dinajpur",3000);
           BankAccount client4 = new BankAccount("Nazmus","Sylhet",5000);
           BankAccount client5 = new BankAccount("Nihal","Sunamganj",4000);
           System.out.println("Total amount is : "+BankAccount.getTotalAmount());
           System.out.println("Average amount is : "+BankAccount.getAvgAmount());
    }   
}