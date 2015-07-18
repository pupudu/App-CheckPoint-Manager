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

    private static void addCheckPoint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void searchCheckPoint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
