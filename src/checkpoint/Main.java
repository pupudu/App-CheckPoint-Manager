package checkpoint;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Display main Menu*/
        displayMainMenu();
        int mainMenuOption = getUserOption(6);// possible options are from 1 to 6
        switch (mainMenuOption) {
            case 1:
                addCheckPoint();
                break;
            case 2:
                searchCheckPoint();
                break;
            case 3:
                modifyCheckPoint();
                break;
            case 4:
                deleteCheckPoint();
                break;
            case 5:
                displayDetails();
                break;
            case 6:
                System.out.println("Program Will exit now");
                System.exit(0);
                break;
            default:
                System.out.println("Input Error. Program Will now Exit");
                System.exit(0);
                break;
        }
        main(args);
    }

    /**
     * Static method to Display main Menu
     */
    private static void displayMainMenu() {
        System.out.println("\n--------------------------");
        System.out.println("Menu: Please select Action");
        System.out.println("--------------------------");
        System.out.println("1. Add CheckPoint");
        System.out.println("2. Search CheckPoint");
        System.out.println("3. Modify CheckPoint");
        System.out.println("4. Delete CheckPoint");
        System.out.println("5. Display details of a CheckPoints");
        System.out.println("6. Exit System");
    }
    
    /**
     * @param limit - Maximum value possible to input as an option
     * @return user input as an integer
     */
    private static int getUserOption(int limit) {
        /* Scanner to read inputs from keyboard*/
        Scanner sc = new Scanner(System.in);
        try {
            String optionStr = sc.nextLine();
            int option = Integer.parseInt(optionStr);
            if (option <= limit) {
                return option;
            }
        } catch (Exception e) {
        }
        System.out.println("Invalid Input Try Again");
        return getUserOption(limit);
    }

    /**
     * Adds a new checkpoint to the log.txt file
     */
    private static void addCheckPoint() {
        System.out.println("Please enter details of the new checkpoint");
        long time = readTime(true); //allows system time as an option
        String state = readState();
        int number = Checkpoint.getLastIndex();     //number of the last entry in the log.txt file

        Checkpoint.addCheckpoint(number, time, state);
        System.out.println("New Checkpoint Added Successfully");
    }

    /**
     * search and print matching checkpoints(if any) based on checkpoint number
     */
    private static void searchCheckPoint() {
        System.out.println("Select Search Method"
                + "\n1.Search By Number"
                + "\n2.Search By Time");
        int option = getUserOption(2);

        if (option == 1) {
            int number = readNumber();
            String result = Checkpoint.searchCheckpoint(Integer.toString(number), 0); //searchCheckpoint method has search parameter as a String for easy processing
            if (result.equals("")) {
                System.out.println("Checkpoint with given number not found");
            } else {
                System.out.println("Checkpoint Found:" + result);
            }
        } else {  //option can either be 1 or 2 (enforced by the getUserOption method)
            long time = readTime(false); //doesn't allow current system time
            String result = Checkpoint.searchCheckpoint(Long.toString(time), 0); //searchCheckpoint method has search parameter as a String for easy processing
            if (result.equals("")) {
                System.out.println("Checkpoint with given timestamp not found");
            } else {
                System.out.println("Checkpoint Found:" + result);
            }
        }
    }

    /**
     * Modifies checkpoint(if exists) based on existing checkpoint number
     */
    private static void modifyCheckPoint() {
        int number = readNumber();
        String oldCheckPoint = Checkpoint.searchCheckpoint(number + "", 0);
        long time;
        String state;

        System.out.println("CheckPoint TimeStamp"
                + "\n1.Keep Existing Time"
                + "\n2.Update TimeStamp");
        int timeOption = getUserOption(2);
        time = (timeOption == 2) ? readTime(true) : Long.parseLong(oldCheckPoint.split(";")[1]); //allow current system time, new input or old value

        System.out.println("CheckPoint State"
                + "\n1.Keep Existing State"
                + "\n2.Update State");
        int stateOption = getUserOption(2);
        state = (stateOption == 2) ? readState() : oldCheckPoint.split(";")[2];//allow old value or new input value

        boolean isModified = Checkpoint.modifyCheckpoint(number, time, state);
        if(isModified)
            System.out.println("Log File Updated with given details successfully");
        else
            System.out.println("No match found. Checkpoint not updated");
        
    }

    /**
     * Deletes a checkpoint entry based on given number
     */
    private static void deleteCheckPoint() {
        int number = readNumber();  //number of the checkpoint to be deleted
        if(Checkpoint.deleteCheckpoint(number))
            System.out.println("Checkpoint with given number was deleted");
        else
            System.out.println("No match with given number was found");
    }

    /**
     * Displays details of a checkpoint based on number or details of all
     * checkpoints
     */
    private static void displayDetails() {
        System.out.println("Select option"
                + "\n1.Display All Details"
                + "\n2.Display Details of one Checkpoint");
        int option = getUserOption(2);
        if (option == 1) {
            System.out.println(Checkpoint.getAllDetails());
        } else {
            int number = readNumber(); //number of the entry of which details should be displayed
            if(Checkpoint.searchCheckpoint(Integer.toString(number), 0).equals(""))
                System.out.println("Cannot display details - No match found for given checkpoint number");
            else
                System.out.println(Checkpoint.getDetail(number));
        }
    }

    /**
     * @return UserInput time as a Long or current System time if user input is
     * negative
     */
    private static long readTime(boolean allowSysTime) {
        System.out.println("Enter entry timeStamp(-1 to get current system time):");
        try {
            /* Scanner to read inputs from keyboard*/
            Scanner sc = new Scanner(System.in);
            String timeStr = sc.next();
            long time = Long.parseLong(timeStr);
            if (time < 0 && allowSysTime) {
                time = System.currentTimeMillis();  //return curret system time if negative input given and system time selection is allowed
            }
            return time;
        } catch (Exception e) {
        }
        System.out.println("Invalid Input Try Again");
        return readTime(allowSysTime);
    }

    /**
     * Reads user input entry number
     *
     * @return user input number as an Integer
     */
    private static int readNumber() {
        System.out.println("Enter entry Number:");
        try {
            /* Scanner to read inputs from keyboard*/
            Scanner sc = new Scanner(System.in);
            String numberStr = sc.next();
            int number = Integer.parseInt(numberStr);
            return number;
        } catch (Exception e) {
        }
        System.out.println("Invalid Input Try Again");
        return readNumber();
    }

    /**
     * @return user input application state
     */
    private static String readState() {
        System.out.println("Enter Application State"
                + "\n1.on"
                + "\n2.off");
        int stateInt = getUserOption(2);
        return (stateInt == 1) ? "on" : "off";
    }
}
