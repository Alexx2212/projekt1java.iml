package projekt1java;

public class Audiobook extends Book implements Digital{
     int length;
     int numberOfDownloads;

    public Audiobook(String title, String publisher, int resourceId, String author, int length) {
        super(title, publisher, resourceId, author);
        this.length = length;
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
        System.out.print(" Length: " + length);
    }
}
