package projekt1java;

import java.time.LocalDate;

public class Journal extends Resource implements Rentable {
     LocalDate publishDate;
     LocalDate rentDate;
     LocalDate dueDate;
     User user;

    public Journal(String title, String publisher, int resourceId, LocalDate publishDate) {
        super(title, publisher, resourceId);
        this.publishDate = publishDate;
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
        this.dueDate = currentDate.plusDays(10);

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
        System.out.println("Publish Date: " + publishDate);
    }



}
