package projekt1java;

public class Book extends Resource{
     String author;

    public Book(String title, String publisher, int resourceId, String author) {
        super(title, publisher, resourceId);
        this.author = author;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Author: " + author);
    }


    public boolean isTheSameBook(Book book1) {
        if (book1 == null) {
            return false;
        }
        return this.title.equalsIgnoreCase(book1.title) && this.author.equalsIgnoreCase(book1.author);
    }

}
