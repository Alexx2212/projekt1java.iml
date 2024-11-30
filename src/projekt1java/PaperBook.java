package projekt1java;

import java.time.LocalDate;

public class PaperBook extends Book implements Rentable{
     int pages;
     LocalDate rentDate;
     LocalDate dueDate;
     User user;

    public PaperBook(String title, String publisher, int resourceId, String author, int pages) {
        super(title, publisher, resourceId, author);
        this.pages = pages;
        this.rentDate = null;
        this.dueDate = null;
        this.user = null;
    }


    @Override
    public void rent(User user) {
        if (this.status == Status.UNAVAILABLE) {
            throw new NoAvailableResourceException("Zasób '" + this.title + "' jest już wypożyczony.");
        }

        this.user = user;
        LocalDate currentDate = LocalDate.now();
        this.rentDate = currentDate;


        if (user instanceof Student) {
            this.dueDate = currentDate.plusMonths(1);
        } else if (user instanceof Teacher) {
            this.dueDate = currentDate.plusMonths(3);
        }

        user.rentResource(this);
        this.status = Status.UNAVAILABLE;
    }

    public void returnResource() {
        if (this.user != null) {
            this.user.returnResource(this);
            this.user = null;
            this.status = Status.AVAILABLE;
            this.rentDate = null;
            this.dueDate = null;
        }
    }


    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Pages: " + pages);
    }


}
