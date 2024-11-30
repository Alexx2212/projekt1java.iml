package projekt1java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

public class MethodsTests {
    private User[] users;
    private Resource[] resources;

    @BeforeEach
    public void setUp() {

        users = new User[5];
        users[0]=new Student("Jan","Kowalski",1,"Matematyki i Infromatyki","matematyka");
        users[1]=new Student("Anna", "Nowak", 2, "Matematyki i Informatyki", "informatyka");
        users[2]=new Student("Alicja", "Lis", 3, "Prawa i Administracji", "prawo");
        users[3]=new Teacher("Aleksandra", "Zakrzewska", 4, "Matematyki i Informatyki", "adiunkt");
        users[4]=new Teacher("Karol", "Przybylski", 5, "Prawa i Administracji", "profesor");

        resources = new Resource[19];
        resources[0]=new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        resources[1]=new PaperBook("Pan Tadeusz","GREG",2,"Adam Mickiewicz",334);
        resources[2]=new PaperBook("Pan Tadeusz","GREG",3,"Adam Mickiewicz",334);
        resources[3]=new ScientificBook("Thinking in Java", "Helion",4, "Bruce Eckel", 1248, "informatyka");
        resources[4]=new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer", 5, "Jarosław Warylewski",680,"prawo");
        resources[5]=new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer", 6, "Jarosław Warylewski",680,"prawo");
        resources[6]=new PaperBook("Hrabia Monte Cristo - I", "Świat Książki",7, "Aleksander Dumas", 672);
        resources[7]=new PaperBook("Hrabia Monte Cristo - I", "Świat Książki",8, "Aleksander Dumas", 672);
        resources[8]=new Audiobook("Pan Tadeusz", "Aleksandria", 9, "Adam Mickiewicz", 470);
        resources[9]=new Audiobook("Hobbit" , "Muza", 10, "J. R. R. Tolkien",636);
        resources[10]=new EBook("Hobbit", "Iskry", 11, "J. R. R. Tolkien", 3.1);
        resources[11]=new EBook("Lalka", "Agora", 12, "Bolesław Prus", 3.4);
        resources[12]=new Journal("Książki","Wyborcza",13, LocalDate.of(2024,9,01));
        resources[13]=new Journal("Książki","Wyborcza",14, LocalDate.of(2024,9,01));
        resources[14]=new Journal("Książki","Wyborcza",15, LocalDate.of(2024,9,01));
        resources[15]=new Journal("Książki","Wyborcza",16, LocalDate.of(2024,9,01));
        resources[16]=new Journal("Książki","Wyborcza",17, LocalDate.of(2024,9,01));
        resources[17]=new ScientificJournal("Państwo i Prawo","Wolters Kluwer",18,LocalDate.of(2024,8,1),"prawo");
        resources[18]=new ScientificJournal("Państwo i Prawo","Wolters Kluwer",18,LocalDate.of(2024,8,1),"prawo");


    }


    @Test
    public void testNumberOfResources() {
        User user1 = users[0]; // Student
        PaperBook book1 = (PaperBook) resources[0];
        PaperBook book2 = (PaperBook) resources[1];
        book1.rent(user1);
        book2.rent(user1);

        assertEquals(2, users[0].numberOfResources(resources));
    }

    @Test
    public void testNumberOfResourcesNull() {

        assertEquals(0, users[1].numberOfResources(resources));
    }


    @Test
    public void testGetFeeStudent() {
        PaperBook book1 = (PaperBook) resources[0];
        PaperBook book2 = (PaperBook) resources[1];
        PaperBook book3 = (PaperBook) resources[2];

        User user1 = users[0]; // Student

        book1.rent(user1);
        book2.rent(user1);
        book3.rent(user1);

        book1.dueDate = LocalDate.now().minusDays(5);  // 5 dni po terminie
        book2.dueDate = LocalDate.now().minusDays(2);  // 2 dni po terminie
        book3.dueDate = LocalDate.now().plusDays(1);

        // opłata 7zł
        assertEquals(7, user1.getFee(resources));
    }


    @Test
    public void testGetFeeTeacher() {
        PaperBook book2 = (PaperBook) resources[1];
        Journal journal1 = (Journal) resources[16];

        User user4 = users[3]; //Teacher

        book2.rent(user4);
        journal1.rent(user4);

        book2.dueDate = LocalDate.now();
        journal1.dueDate = LocalDate.now();

        // opłata 0
        assertEquals(0, user4.getFee(resources));
    }

    @Test
    public void testGetFeeTeacher1() {
        PaperBook book2 = (PaperBook) resources[1];
        Journal journal1 = (Journal) resources[16];

        User user4 = users[3]; //Teacher

            book2.rent(user4);
            journal1.rent(user4);

        book2.dueDate = LocalDate.now().minusMonths(2);
        journal1.dueDate = LocalDate.now().minusDays(12);

        assertTrue(user4.getFee(resources)>0);
    }


    @Test
    public void testIsTheSameBookTrue() {
        PaperBook book1 = (PaperBook) resources[0];
        PaperBook book3 = (PaperBook) resources[2];

        assertTrue(book1.isTheSameBook(book3));
    }

    @Test
    public void testIsTheSameBookFalse() {
        PaperBook book1 = (PaperBook) resources[0];
        PaperBook book2 = (ScientificBook) resources[3];

        assertFalse(book1.isTheSameBook(book2));
    }

    @Test
    public void testIsTheSameDomainFalse() {
        ScientificBook book4 = (ScientificBook) resources[3];
        ScientificBook book5 = (ScientificBook) resources[4];
        assertFalse(book4.isTheSameDomain(book5));
    }

    @Test
    public void testIsTheSameDomainTrue() {
        ScientificBook book5 = (ScientificBook) resources[4];
        ScientificBook book6 = (ScientificBook) resources[5];

        assertTrue(book5.isTheSameDomain(book6));
    }


    @Test
    public void testRentForStudent() {
        PaperBook book1 = (PaperBook) resources[0];
        Student student = (Student) users[0];

        book1.rent(student);
        assertEquals(student, book1.getUser());

    }

    @Test
    public void testRentForTeacher() {
        User user4 = users[3]; //Teacher
        PaperBook book2 = (PaperBook) resources[1];
        book2.rent(user4);
        assertEquals(Status.UNAVAILABLE, book2.getStatus());
    }

    @Test
    public void testRentStatus() {
        PaperBook book4 = (PaperBook) resources[5];
        assertEquals(Status.AVAILABLE, book4.getStatus());
    }




}
