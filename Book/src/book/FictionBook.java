package book;

public class FictionBook extends Book{
    private String genre;
    public FictionBook(){
    }
    public FictionBook(String name,String author,String genre){
        super(name,author);
        this.genre = genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getGenre(){
        return genre;
    }
    @Override
    public void displayInfo() {
        System.out.println("Name :"+getName());
        System.out.println("Author :"+getAuthor());
        System.out.println("Genre :"+getGenre());
    }
    @Override
    public boolean isRecommendedForAge(int age) {
        if(age >= 14){
            return true;
        }
        else{
            return false;
        }
    }
}

