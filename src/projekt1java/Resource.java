package projekt1java;

public abstract class Resource {
     String title;
     String publisher;
     int resourceId;
     Status status;

    public Resource(String title, String publisher, int resourceId) {
        this.title = title;
        this.publisher = publisher;
        this.resourceId = resourceId;
        this.status = Status.AVAILABLE;
    }
    public Status getStatus() {
        return status;
    }



    public void print() {
        System.out.println("Title: " + title + " Publisher: " + publisher + " Resource: " + resourceId + " Status: " + status);
    }

}
