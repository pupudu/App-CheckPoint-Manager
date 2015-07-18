/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkpoint;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Display main Menu*/
        displayMainMenu();
        int mainMenuOption=getUserOption(6);// possible options are from 1 to 6
        switch(mainMenuOption){
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
                displayDetail();
                break;
            case 6:
                displayAllDetails();
                break;
            default:
                System.out.println("Input Error. Program Will now Exit");
                System.exit(0);
                break;
        }
        
    }
    
    /**
     * @param limit - Maximum value possible to input as an option
     * @return user input as an integer
     */
    private static int getUserOption(int limit){
        /* Scanner to read inputs from keyboard*/
        Scanner sc=new Scanner(System.in);
        try{
            String optionStr=sc.nextLine();
            int option=Integer.parseInt(optionStr); 
            if(option<=limit){
                return option;
            }
        }catch(Exception e){
        }
        System.out.println("Invalid Input Try Again");
        return getUserOption(limit);
    }
    
    /**
     * Static method to Display main Menu
     */
    private static void displayMainMenu(){
        System.out.println("Menu: Please select Action");
        System.out.println("--------------------------");
        System.out.println("1. Add CheckPoint");
        System.out.println("2. Search CheckPoint");
        System.out.println("3. Modify CheckPoint");
        System.out.println("4. Delete CheckPoint");
        System.out.println("5. Display details of a CheckPoint");
        System.out.println("6. Display All details");
    }

    /**
     * Adds a new checkpoint to the log.txt file
     */
    private static void addCheckPoint() {
        displayAddCheckPointMenu();
        
        System.out.println("Please Enter Time as a number(-1 to get Current System Time)");
        long time = readTime(true); //allows system time as an option
        
        System.out.println("Enter Application State"
                + "\n1.on"
                + "\n2.off");
        int stateInt = getUserOption(2);
        String state = (stateInt==1)?"on":"off";
        
        int number = Checkpoint.getLastIndex();     //number of the last entry in the log.txt file
        
        Checkpoint.addCheckpoint(number, time, state);
        System.out.println("New Checkpoint Added Successfully");
        
    }

    private static void searchCheckPoint() {
        System.out.println("Select Search Method"
                + "\n1.Search By Number"
                + "\n2.Search By Time");
        int option=getUserOption(2);
        
        if(option==1){
            System.out.println("Enter entry Number:");
            int number = readNumber();
            String result = Checkpoint.searchCheckpoint(Integer.toString(number), 0); //searchCheckpoint method has search parameter as a String for easy processing
            if(result.equals("")){
                System.out.println("Checkpoint with given number not found");
            } else {
                System.out.println("Checkpoint Found:"+result);
            }
        }else{  //option can either be 1 or 2 (enforced by the getUserOption method)
            System.out.println("Enter entry timeStamp:");
            long time = readTime(false); //doesn't allow current system time
            String result = Checkpoint.searchCheckpoint(Long.toString(time), 0); //searchCheckpoint method has search parameter as a String for easy processing
            if(result.equals("")){
                System.out.println("Checkpoint with given timestamp not found");
            } else {
                System.out.println("Checkpoint Found:"+result);
            }
        }
        
    }

    private static void modifyCheckPoint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void deleteCheckPoint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void displayDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void displayAllDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void displayAddCheckPointMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return UserInput time as a Long or current System time if user input is negative
     */
    private static long readTime(boolean allowSysTime) {
        try{
            /* Scanner to read inputs from keyboard*/
            Scanner sc=new Scanner(System.in);
            String timeStr=sc.next();
            long time=Long.parseLong(timeStr);
            if(time<0 && allowSysTime)
                time=System.currentTimeMillis();  //return curret system time if negative input given and system time selection is allowed
            return time;
        }catch(Exception e){
        }
        System.out.println("Invalid Input Try Again");
        return readTime(allowSysTime); 
    }
    
    /**
     * Reads user input entry number
     * @return user input number as an Integer
     */
    private static int readNumber(){
        try{
            /* Scanner to read inputs from keyboard*/
            Scanner sc=new Scanner(System.in);
            String numberStr=sc.next();
            int number=Integer.parseInt(numberStr);
            return number;
        }catch(Exception e){
        }
        System.out.println("Invalid Input Try Again");
        return readNumber(); 
    }
    
    
}
