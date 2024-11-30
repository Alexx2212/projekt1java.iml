package projekt1java;

import java.time.LocalDate;

public class ScientificJournal extends Journal implements Scientific{
     String domain;

    public ScientificJournal(String title, String publisher, int resourceId, LocalDate publishDate, String domain) {
        super(title, publisher, resourceId, publishDate);
        this.domain = domain;
    }

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Domain: " + domain);
    }



}
