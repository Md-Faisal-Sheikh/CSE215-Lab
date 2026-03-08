package book;

public class NonFictionBook extends Book{
    private String subject;
    public NonFictionBook(){
    }
    public NonFictionBook(String name,String author,String subject){
        super(name,author);
        this.subject = subject;
    }
    public void setSubject(String genre){
        this.subject = subject;
    }
    public String getSubject(){
        return subject;
    }
    @Override
    public void displayInfo() {
        System.out.println("Name :"+getName());
        System.out.println("Author :"+getAuthor());
        System.out.println("Subject :"+getSubject());
    }
    @Override
    public boolean isRecommendedForAge(int age) {
        if(age >= 18){
            return true;
        }
        else{
            return false;
        }
    }
}
