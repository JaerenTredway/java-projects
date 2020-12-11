public class Library {

    /** Unique books in the library. */
    private Book[] books;

    /** Number of copies for each book. */
    private int[] copies;

    /** Number of copies currently on the shelf (checked in) for each book. */
    private int[] checkedIn;

    /** Number of unique books in the library. */
    private int numBooks;

    /** Construct a new empty Library. */
    public Library(int librarySize) {
        books = new Book[librarySize];
        copies = new int[librarySize];
        checkedIn = new int[librarySize];
        numBooks = 0;
    }

    /**
     * Get the number of total copies of all books that exist in the
     * library.
     * @return Total number of copies in the library.
     */
    public int getTotalCopies() {
        int totalCopies = 0;

        for (int i = 0; i < copies.length; i++) {
            totalCopies += copies[i];
        }
        return totalCopies;
    }

    /**
     * Get the number of copies currently checked out.
     * @return Total number of copies checked out.
     */
    public int getNumCheckedOut() {
        int totalCopies = getTotalCopies();
        int totalCheckedIn = 0;

        for (int i = 0; i < checkedIn.length; i++) {
            totalCheckedIn += checkedIn[i];
        }

        return totalCopies - totalCheckedIn;
    }

    /**
     * Get a String representing the status of the library.
     * @return Status string.
     */
    public String getStatus() {
        String result =
                "Total unique books: " + numBooks + "\n" +
                "Total number of copies: " + getTotalCopies() + "\n" +
                "Total checked out: " + getNumCheckedOut();

        return result;
    }


    /**
     * Add a single book to the library, on the shelf.
     *
     * If the book is already present, adds another copy.
     * If the book is new, add it after the existing books.
     * @param b Book to add.
     */
    public void addBook( Book b ) {
        boolean alreadyInLibrary = false;

        //search if you already have this book:
        for (int i = 0; i < books.length; i++) {
            //if you reached the end of the books, stop looking:
            if (books[i] == null) {
                break;
            //if you already have this book in your library, add a copy:
            } else if (b.equals(books[i])) {
                copies[i]++;
                checkedIn[i]++;
                //don't numBooks++ ,this is not a new title
                alreadyInLibrary = true;
                break;
            }
        }

        //if you don't have this book yet, add it to the first available
        // space in your library:
        if (!alreadyInLibrary) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = b;
                    copies[i] = 1;
                    checkedIn[i] = 1;
                    numBooks++;
                    break;
                }
            }
        }
    }//END of addBook()


    /**
     * Add all the books in the array to the library. Adds one copy of
     * each book.
     * @param newBooks Books to add.
     */
    public void addBooks( Book[] newBooks ) {
        //find first empty position on bookshelf:
        int startPosition = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                startPosition = i;
                break;
            }
        }
        //add the newBooks starting at startPosition:
        for (int i = startPosition; i < startPosition + newBooks.length; i++) {
            addBook(newBooks[i-startPosition]);
        }
    }//END of addBooks()


    /**
     * Checks out a book from the library if possible.
     * @param b Book to check out.
     * @return String denoting success or failure.
     */
    public String checkOut ( Book b ) {
        String action = "Book not found.";

        for (int i = 0; i < numBooks; i++) {
            //eject out of this method if either book involved is null:
            if (books[i] == null) {
                System.out.println("One or more books are missing, action " +
                        "terminated");
                //eject:
                return action;
            }

            if (books[i].equals(b)) {
                if (checkedIn[i] >= 1) {
                    action = "Checked out!";
                    checkedIn[i] = checkedIn[i] - 1;
                } else {
                    action = "All out of copies.";
                }
            }
        }
        return action;
    }


    /**
     * Checks in a book to the library if possible.
     * @param b Book to check in.
     * @return String denoting success or failure.
     */
    public String checkIn ( Book b ) {
        String action = "";

        for (int i = 0; i < numBooks; i++) {

            if (books[i].equals(b) && checkedIn[i] < copies[i]) {
                checkedIn[i]++;
                action = "Checked in!";
                break;
            } else if (books[i].equals(b) && (checkedIn[i] == copies[i])) {
                action = "All of our copies are already checked in.";
                break;
            } else {
                action = "Book not found.";
            }
        }

        return action;
    }


    /**
     * Get string representation of entire library collection and status.
     * @return String representation of library.
     */
    public String toString() {
        String output = "";

        for (int i = 0; i < numBooks; i++) {
            output += i + ". " +
                    books[i].getTitle() +
                    ". " + books[i].getAuthor() + ". : " +
                    checkedIn[i] + "/" + copies[i] + "\n";
        }
        output +=   "\nTotal unique books: " + numBooks +
                    "\nTotal number of copies: " + getTotalCopies() +
                    "\nTotal checked out: " + getNumCheckedOut();

        return output;
    }


    /**
     * Get number of unique books that exist for a given author.
     * @param a The author to check.
     * @return Number of books by the author.
     */
    public int numBooksByAuthor( Author a ) {
        int counter = 0;

        for (int i = 0; i < numBooks; i++) {
            if (books[i].getAuthor().hasSameName(a)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns a String that lists the unique books which exist for a
     * given author, in standard book format, with a newline after
     * each.  If no books are found for the author, returns string
     * that says so.
     *
     * @param a The author in question.
     * @return String listing books by the author.
     */
    public String listBooksByAuthor( Author a ) {
        String output = "";
        boolean hasSomeBooks = false;

        for (int i = 0; i < numBooks; i++) {
            String targetAuthor = books[i].getAuthor().toString();

            if (targetAuthor.equals(a.toString())) {
                output += books[i].getTitle() + ". " +
                        books[i].getAuthor() + ".\n";
                hasSomeBooks = true;
            }
        }

        if (!hasSomeBooks) {
            output = "No books by " + a.toString() + ".";
        }

        return output;

    }//END listBooksByAuthor()


    /**
     * Returns string that lists the unique books which contain the
     * given string within their titles, without regard for case, with
     * a newline after each.  If no books are found containing the
     * string, returns string that says so.
     * @param s The string to look for in the titles.
     * @return String listing books that contain given string in titles.
     */
    public String listBooksByTitle( String s ) {
        String output = "";
        boolean foundSomeBooks = false;

        for (int i = 0; i < numBooks; i++) {
            String targetBook = books[i].getTitle().toLowerCase();

            if (targetBook.contains(s.toLowerCase())) {
                output += books[i].getTitle() +
                        ". " + books[i].getAuthor() + ".\n";
                foundSomeBooks = true;
            }
        }

        if (!foundSomeBooks) {
            output = "No books with \"" + s + "\" in the title.";
        }

        return output;
    }


    /**
     * method to delete a book from the library:
     * @param (Book) b: the Book to remove.
     * @return (String) output: a message saying if successfully deleted or not.
     */
    public String deleteBook( Book b ) {
        String output = "";
        int flaggedForDeletion = -1;
        boolean foundBook = false;

        //search to find the book that is to be deleted:
        for (int i = 0; i < numBooks; i++) {
            if (books[i].equals(b)) {
                flaggedForDeletion = i;
                foundBook = true;
                break; //book is found so stop searching
            }
        }
        //report for book not found:
        if (!foundBook) {
            output = "Book not found.";
        }
        //clean up all arrays by overwriting the deleted book, shift remaining books 1 to the left:
        if (foundBook) {
            for (int i = flaggedForDeletion; i < numBooks; i++) {
                books[i] = books[i+1];
                copies[i] = copies[i+1];
                checkedIn[i] = checkedIn[i+1];
            }
            numBooks--;
            output = "Book removed.";
        }
        //print out what was done: 
        return output;
    }

}//END of class Library
