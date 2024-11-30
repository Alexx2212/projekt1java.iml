package projekt1java;

public class ScientificBook extends PaperBook implements Scientific{
     String domain;

    public ScientificBook(String title, String publisher, int resourceId, String author, int pages, String domain) {
        super(title, publisher, resourceId, author, pages);
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
