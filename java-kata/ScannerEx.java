/**
* @version 1.0
* @author Jaeren W. Tredway
*/

import java.util.*;

class ScannerEx {
    /**
    * This class builds a scanner to take user input.
    * @param args Command line arguments are ignored.
    */
    public static void main(String args[]) {
    	System.out.println("\nEnter your username: ");
    	Scanner scanner = new Scanner(System.in);
    	String username = scanner.nextLine();

    	if (username.equals("jwt")) {
    		System.out.println("\nYour username " + username + " is authorized" );
    		access();
    	} else {
    		System.out.println("\nYour username " + username + " is not authorized, security protocols initiated." );
    	}
    } //end of main()

    public static void access() {
    	System.out.print("\nEnter access code: ");
    	Scanner scanner2 = new Scanner(System.in);
    	int code = scanner2.nextInt();
    	if (code == 1234) {
    		System.out.println("\nAccess granted");
    	} else {
    		System.out.println("\nAccess denied");
    	}
    	int x = 2, y = 7, z;
    } //end of access()

} //end of class Main