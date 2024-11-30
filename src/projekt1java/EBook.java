package projekt1java;


public class EBook extends Book implements Digital{
     double size;
     int numberOfDownloads;

    public EBook(String title, String publisher, int resourceId, String author, double size) {
        super(title, publisher, resourceId, author);
        this.size = size;
        this.numberOfDownloads = 0;
        this.status = Status.DIGITAL;
    }

    @Override
    public void download() {
        numberOfDownloads++;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Size: " + size);
    }

}
