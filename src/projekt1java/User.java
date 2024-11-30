package projekt1java;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class User {
     String name;
     String surname;
     int IdUser;
     String department;
     final List<Resource> rentedResources;

    public User(String name, String surname, int IdUser, String department) {
        this.name = name;
        this.surname = surname;
        this.IdUser = IdUser;
        this.department = department;
        this.rentedResources = new ArrayList<>();
    }

    public void rentResource(Resource resource) {
        rentedResources.add(resource);

    }

    public void returnResource(Resource resource) {
        rentedResources.remove(resource);
    }

    public int numberOfResources(Resource[] resources) {
        return rentedResources.size();
    }


    public int getFee(Resource[] resources) {
        int fee = 0;

        for (Resource resource : rentedResources) {

            if (resource instanceof PaperBook book) {
                if (book.dueDate != null && LocalDate.now().isAfter(book.dueDate)) {
                    long overdueDays = ChronoUnit.DAYS.between(book.dueDate, LocalDate.now());
                    if (overdueDays > 0) {
                        fee += overdueDays;
                    }
                }
            }
            else if (resource instanceof Journal journal) {
                if (journal.dueDate != null && LocalDate.now().isAfter(journal.dueDate)) {
                    long overdueDays = ChronoUnit.DAYS.between(journal.dueDate, LocalDate.now());
                    if (overdueDays > 0) {
                        fee += overdueDays;
                    }
                }
            }
        }

        return Math.max(fee, 0);
    }






}
