package book;
    import java.util.Scanner;
    import java.util.ArrayList;
    public abstract class Book{
        private String name;
        private String author;
        public Book(){
        }
        public Book(String name,String author){
            this.name = name;
            this.author = author;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setAuthor(String author){
            this.author = author;
        }
        public String getAuthor(){
            return author;
        }
        public abstract void displayInfo();
        public abstract boolean isRecommendedForAge(int age);
        public static void main(String[] args) {
           ArrayList<Book> books = new ArrayList<Book>();
           //Fiction Books
           books.add(new FictionBook("The Fragile Threads of Power","V.E. Schwab","Fantasy"));
           books.add(new FictionBook("Dune","Frank Herbert","Science Fiction"));
           books.add(new FictionBook("The Hobbit","J.R.R Tolkien","Fantasy"));
           //Non Fiction Books
           books.add(new NonFictionBook("No Logo","Naomi Klein","Corporate Hegemony"));
           books.add(new NonFictionBook("The Right Stuff","Tom Wolfe","Space Exploration"));
           books.add(new NonFictionBook("Silent Spring","Rachel Carson","Environment"));
           
           System.out.println("Books in the ArrayList: ");
           for(Book b:books){
               b.displayInfo();
               System.out.println("Is this book recommended for someone who is 16 years old :"+b.isRecommendedForAge(16));
               System.out.println();
           }
        }
}
