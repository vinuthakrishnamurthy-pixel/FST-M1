package activites;

//abstract class Book
abstract class Book {
    String title;
    //abstract method
    abstract void setTitle(String s);
    //concrete method
    String getTitle() {
        return title;
    }
}
//abstract class MyBook extend Book
class MyBook extends Book{
    public void setTitle(String s){
        title = s;
    }
}

public class Activity5 {
    public static void main(String[] args) {
         //Initialize title of the book
        String  title= "Harry Potter";
        //Create object for MyBook
        Book newBook = new MyBook();
        //Set title
        newBook.setTitle(title);
     
        //Print result
        System.out.println("The New Book title is: " + newBook.getTitle());   
    }
    
    }