package Task_3;

public class Book {

    private String book_id;//should be of 6 characters.
    private String book_name;
    private boolean availability;

    //constructor
    Book(String book_id, String book_name)
    {
        this.book_id = book_id;
        this.book_name = book_name;
        this.availability = true;
    }
    Book(String book_id, String book_name, boolean status)
    {
        this.book_id = book_id;
        this.book_name = book_name;
        this.availability = status;
    }

    //getters
    public String getBookId()
    {
        return this.book_id;
    }
    public String getNameName()
    {
        return this.book_name;
    }
    public boolean getBookStatus()
    {
        return this.availability;
    }

    //setters
    public void setBookId(String book_id)
    {
        this.book_id = book_id;
    }
    public void setBookName(String book_name)
    {
        this.book_name = book_name;
    }
    public void setBookStatus(boolean status)
    {
        this.availability = status;
    }

    @Override
    public String toString() {
        return "Book [book_id= " + book_id + ", book_name= " + book_name + ", availability= " + availability + "]";
    }


}
