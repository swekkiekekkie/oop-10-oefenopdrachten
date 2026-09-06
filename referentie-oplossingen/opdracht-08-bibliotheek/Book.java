public class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Boek markeert zichzelf als uitgeleend
    public boolean lend() {
        // EDGE CASE: Al uitgeleend
        if (!available) {
            return false;
        }
        available = false;
        return true;
    }

    // Boek markeert zichzelf als teruggebracht
    public void returnBook() {
        available = true;
    }
}
