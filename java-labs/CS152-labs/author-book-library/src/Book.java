/**
 * This class builds an Book object that can have a publication date, title,
 * ISBN and author
 * @author Jaeren W. Tredway
 * @version 1.0
 */
public class Book {
    //INSTANCE MEMBER VARIABLES: ***************************
        private int date = AuthorBookConstants.UNKNOWN_YEAR;
        private String title = AuthorBookConstants.UNKNOWN_TITLE;
        private String isbn = AuthorBookConstants.UNKNOWN_ISBN;
        private Author author = AuthorBookConstants.UNKNOWN_AUTHOR;


    //CLASS (STATIC) MEMBER VARIABLES: *********************
    //none so far


    //CONSTRUCTORS: *****************************************
    /**
     *  This is the constructor if no arguments are provided.
     */
    public Book() {
        this.date = AuthorBookConstants.UNKNOWN_YEAR;
        this.title = AuthorBookConstants.UNKNOWN_TITLE;
        this.isbn = AuthorBookConstants.UNKNOWN_ISBN;
        this.author = AuthorBookConstants.UNKNOWN_AUTHOR;
    }

    /**
     * This is the constructor if the book name is provided.
     * @param title (String): The name of the book.
     */
    public Book(String title) {
        this.date = AuthorBookConstants.UNKNOWN_YEAR;
        this.title = title;
        this.isbn = AuthorBookConstants.UNKNOWN_ISBN;
        this.author = AuthorBookConstants.UNKNOWN_AUTHOR;

    }

    /**
     * This is the constructor if both book name and author name are provided.
     * @param title (String): The name of the book.
     * @param author (String): The name of the author.
     */
    public Book(String title, Author author) {
        this.date = AuthorBookConstants.UNKNOWN_YEAR;
        this.title = title;
        this.isbn = AuthorBookConstants.UNKNOWN_ISBN;
        this.author = author;
    }


    //SETTERS: **********************************************
    /**
     * This sets a name for the book.
     * @param title (String): The name of the book.
     */
    public void setTitle(String title) {
        if (title == null) {
            System.out.println("Null name was ignored.");
        } else if (title.isEmpty()) {
            System.out.println("Empty name was ignored.");
        } else this.title = title;
    }

    /**
     * This sets the author's name.
     * @param author (String): The name of the author.
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * This sets the publication date.
     * @param year (int): The year of publication.
     */
    public void setPubYear(int year) {
        if (year > -2000 && year < 2024 && year != 0) {
            this.date = year;
        } else {
            System.out.println("Invalid publication date.");
        }
    }

    /**
     * This sets an ISBN for the book.
     * @param isbn (String): The book's ISBN.
     */
    public void setIntStdBookNum( String isbn) {
        if (isbn.length() == 10 || isbn.length() == 13) {
            this.isbn = isbn;
        } else {
            System.out.println("Invalid ISBN ignored.");
        }
    }

    //GETTERS: ************************************************
    /**
     * Get the book's title
     * @return (String): The book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the author's name
     * @return (String): The author's name
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Get the date of publication.
     * @return (int): The year of publication.
     */
    public int getPubYear() {
        return date;
    }

    /**
     * Gets the book's ISBN.
     * @return (String): The book's ISBN.
     */
    public String getIntStdBookNum() {
        return isbn;
    }

    //HELPER METHODS: *****************************************
    /**
     * Checks to see if this book's author is the same as the other
     * book's author.
     * @param other (Book object): the other book you are comparing this
     *      book to
     * @return (boolean): returns true if the authors are the same, false
     *      otherwise
     */
    public boolean sameAuthor(Book other) {
        if (this.author.hasSameName(other.author)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks to see if the ISBN's are the same
     * @param other (Book object): The book you are comparing this book to.
     * @return (boolean): Returns true if the ISBN's are the same, false
     *      otherwise.
     */
    public boolean equals(Book other) {
        //filter out failures caused by no ISBN having been assigned to one
        //or both books:
        if (this.isbn.equals(AuthorBookConstants.UNKNOWN_ISBN) ||
            other.isbn.equals(AuthorBookConstants.UNKNOWN_ISBN)) {
            System.out.println("Error: One or more books in your search have " +
                    "no ISBN assigned.");
            return false;
        }
        return this.isbn.equals(other.isbn);
    }

    /**
     * This builds a String with the book's info.
     * @return (String): returns book info as available
     */
    public String toString() {
        if (author != AuthorBookConstants.UNKNOWN_AUTHOR &&
            date != AuthorBookConstants.UNKNOWN_YEAR) {
            return title + " (" + date + "). " + author.toString() + ".";
        } else if (author != AuthorBookConstants.UNKNOWN_AUTHOR) {
            return title + ". " + author.toString() + ".";
        } else {
            return title + ".";
        }
    }

    /**
     * This main() is used for preliminary testing of the class methods.
     * @param args (String[]): Command line args are ignored.
     */
    public static void main(String[] args) {
        Author sciFi_1 = new Author("William", "Gibson");
        Author sciFi_2 = new Author("Isaac", "Azimov");
        Author sciFi_3 = new Author("W.", "Gibson");
        Book book_1 = new Book("Neuromancer", sciFi_1);
        Book book_2 = new Book("Count Zero", sciFi_3);
        Book book_3 = new Book("I, Robot", sciFi_2);
        System.out.println(sciFi_1.hasSameName(sciFi_3));
        sciFi_1.setLifeRange(1960, 2020);
        System.out.println(sciFi_1.getInfoString());
        System.out.println(book_1.toString());
        System.out.println(book_1.sameAuthor(book_2));
    }//END of main()

}//END of class Book
