/**
 * This class builds an Author object that can have a first name, surname,
 *      birth year and death year
 * @author Jaeren W. Tredway
 * @version 1.0
 */
public class Author {

    //INSTANCE MEMBER VARIABLES: ****************************************
    private String givenName;
    private String surname;
    private int birth = AuthorBookConstants.UNKNOWN_YEAR;
    private int death = AuthorBookConstants.UNKNOWN_YEAR;


    //CLASS (STATIC) MEMBER VARIABLES:***********************************
    //None so far.


    //CONSTRUCTOR: ***********************************************
    /**
     * Constructor for Author objects.
     * @param givenName (String): author's first name
     * @param surname (String): author's last name
     */
    public Author(String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
    }


    //SETTERS: ****************************************************
    /**
     * Sets the author's birth year.
     * @param birth (int): author's birth year
     */
    public void setLifeRange(int birth) {
        if (birth > -2000 && birth < 2024) {
            this.birth = birth;
        } else {
            System.out.println("Invalid birth year");
        }
    }

    /**
     * Overloaded method that sets both author birth year and death year.
     * @param birth (int): author's birth year
     * @param death (int): author's death year
     */
    public void setLifeRange(int birth, int death) {
        if (    (birth > -2000 && birth < 2024) &&
                (death > -2000 && death < 2024) &&
                (birth < death)) {
            this.birth = birth;
            this.death = death;
        } else {
            System.out.println("Invalid birth and/or death year");
        }
    }


    //GETTERS: ****************************************************
    /**
     * Gets author's birth year.
     * @return (int): year of birth
     */
    public int getBirthYear() {
        return birth;
    }

    /**
     * Gets author's death year.
     * @return (int): year of death
     */
    public int getDeathYear() {
        return death;
    }


    //HELPER METHODS: *********************************************
    /**
     * Tests to see if this author name is the same as another author name.
     * @param other (Author object): author that you are comparing to this
     *      author
     * @return : (boolean) true if the authors are the same, even if one or
     *      both instances are using initials for the first name.
     */
    public boolean hasSameName(Author other) {
        boolean sameName = false;

        //test if first and last names match:
        if ((other.givenName.equals(this.givenName)) &&
            (other.surname.equals(this.surname))) {
            sameName = true;
        }

        //test if first initials (no period) and last names match:
        if (this.givenName.length() == 1 || other.givenName.length() == 1) {
            if (this.givenName.charAt(0) == other.givenName.charAt(0)) {
                if (this.surname.equals(other.surname)) {
                    sameName = true;
                }
            }
        }
        //test if first initials (followed by period) and last names match:
        if (this.givenName.length() > 1 && other.givenName.length() > 1) {
            if (
                (this.givenName.charAt(0) == other.givenName.charAt(0)) &&
                (this.givenName.charAt(1) == '.' || other.givenName.charAt(1)
                        == '.')) {
                if (this.surname.equals(other.surname)) {
                    sameName = true;
                }
            }
        }
        return sameName;
    }

    /**
     * Makes a String of the author's name.
     * @return (String): Last Name, First Name
     */
    public String toString() {
        return surname + ", " + givenName;
    }

    /**
     * Makes a String with all the available info on the author.
     * @return (String): Last Name, First Name and (birth-death) if available.
     */
    public String getInfoString() {
        if ((birth != AuthorBookConstants.UNKNOWN_YEAR) &&
                (death != AuthorBookConstants.UNKNOWN_YEAR)) {
            return surname + ", " + givenName + " (" + birth + "-" + death +
                    ")";
        } else if (birth != AuthorBookConstants.UNKNOWN_YEAR) {
            return surname + ", " + givenName + " (born " + birth + ")";
        } else {
            return surname + ", " + givenName;
        }
    }

    /**
     * main() used for preliminary testing of the Author class.
     * @param args (String[]): Ignores command line args.
     */
    public static void main(String[] args) {
        Author sciFi_1 = new Author("William", "Gibson");
        Author sciFi_2 = new Author("Isaac", "Azimov");
        Author sciFi_3 = new Author("W.", "Gibson");

        System.out.println(sciFi_1.givenName + " " + sciFi_1.surname);
        System.out.println(sciFi_2.givenName + " " + sciFi_2.surname);
        System.out.println(sciFi_3.givenName + " " + sciFi_3.surname);

        System.out.println(sciFi_1.hasSameName(sciFi_3));
        sciFi_1.setLifeRange(1960, 2020);
        System.out.println("birth = " + sciFi_1.birth);
        System.out.println("death = " + sciFi_1.death);
        System.out.println(sciFi_1.getInfoString());
    }//END main()

}//END Author class
