/**
* View_Console.java
* Eder Martinez/ Thu 2:30 
*************extra credit included (2nd one)******************************
* a class that will hold and create an object that will represent an emploeyee. It will utilize the 
* yearly salary or pay rate depending on what type of employee means. able to return all the elements to be used 
* in the main
* based a little bit of my extension code from the zybook but did not copy paste :)
*/
import java.util.*;

//view console main class
public class View_Console
{
    private Scanner scnr;
    private String name = "";
    private String id = "";
    private char empType;
    private int yearlySal = -1;
    private double payRate = -1;
    private char tocontinue = 'q';

    //constructor for scanner
    /** 
    * Constructor of view console constucts scnr
    */
    public View_Console()
    {
        scnr = new Scanner(System.in);
    }
    //gets name of the employee
    /**
    * gets the name from the user of the employee
    * @return the name of the employee
    * @throws customThrowable a throwable that is used to check if a line is empty
    */
    public String setName()
    { 
        while(name.isEmpty())
        {
            try
            {
                System.out.print("Enter employee's name: ");
                name = scnr.nextLine();
                if(name.isEmpty())
                {
                    throw new customThrowable("Name is required. Please re-enter");
                }

            }
            catch(customThrowable nne)
            {
                System.out.println(nne.getMessage());
            }
        }
        return name;
    }
    //gets id for the user id from user
      /**
    * gets the id from the user of the employee
    * @return String that represents the id of the user
    * @throws customThrowable a throwable that is used to check if a line is empty
    */
    public String setID()
    {
        while(id.isEmpty())
        {
            try
            {
                System.out.print("Enter " + name + "'s ID #: ");
                id = scnr.nextLine();
                if(id.isEmpty())
                {
                    throw new customThrowable("ID is required. Please re-enter");
                }   
            }
            catch(customThrowable nie)
            {
                System.out.println(nie.getMessage());
            }
        }

        return id;
    }

    //gets type of employee from user
      /**
    * gets the type of employee from the user of the employee
    * @return char of the employee, type of employee
    * @throws customThrowable a throwable that is used to check and throw custom lines
    * @throws emptyLineException a throwable that is used to read empty lines 
    */
    public char setType()
    {
        String empTypeStr;
        while(empType != 's' || empType != 'h')
        {
            try
            {
                System.out.print("Is the employee S)alaried or H)ourly? ");
                empTypeStr = scnr.nextLine();
                if(empTypeStr.isEmpty())
                {
                    throw new emptyLineException("Employee Type is required. Please re-enter");
                }
                empTypeStr.toLowerCase();
                if(!(empTypeStr.equals("s")) && !(empTypeStr.equals("h")))
                {

                    throw new customThrowable("must be an 'H or 'S'");
                }
                else
                {
                    empType = empTypeStr.charAt(0);
                    break;
                }

            }
            catch(customThrowable ice)
            {
                System.out.println(ice.getMessage());
            }
            catch(emptyLineException ele)
            {
                System.out.println(ele.getMessage());
            }
        }
        return empType;

    }
    // gets yearly salary from user, runs while yearlysal is -1 (starts at -1)
      /**
    * gets the yearly salary from the user of the employee
    * @return int of the employee, 
    * @throws customThrowable a throwable that is used to check and throw custom lines
    * @throws emptyLineException a throwable that is used to read empty lines 
    * @throws InputMissmatchException checks if the input given is a the correct type
    */
    public int setyearlySal()
    {
        while(yearlySal == -1)
        {

            try
            {
                System.out.print("Enter " + name + "'s yearly salary: ");
                String yearlySalStr = scnr.nextLine();
                if(yearlySalStr.isEmpty())
                {
                    throw new emptyLineException("Line is empty, try again.");
                }
                yearlySal = Integer.parseInt(yearlySalStr);
            
            }
            catch(InputMismatchException ime)
            {
                System.out.println("No chars or decimals allowed. Enter integers only");
            }
            catch(emptyLineException ele)
            {
                System.out.println(ele.getMessage());
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("An integer value is required");
            }
        }
        return yearlySal;
    }   

      /**
    * gets the pay rate from the user of the employee
    * @return double salary of the employee, 
    * @throws customThrowable a throwable that is used to check and throw custom lines
    * @throws emptyLineException a throwable that is used to read empty lines 
    * @throws InputMissmatchException checks if the input given is a the correct type
    */
    public double setPayRate()
    {
        while(payRate == -1)
        {
            try
            {
                System.out.print("Enter " + name + " 's pay rate: ");
                String payRateStr = scnr.nextLine();
                if(payRateStr.isEmpty())
                {
                    throw new emptyLineException("Line is empty, try again.");
                }
                payRate = Double.parseDouble(payRateStr);

            }
            catch(InputMismatchException ime)
            {
                System.out.println("No chars allowed. Enter doubles only");
            }
            catch(emptyLineException ele)
            {
                System.out.println(ele.getMessage());
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("NO chars allowed. Enter doubles only");
            }
        }
        return payRate;

    }

      /**
    * gets the option to continue from the user to continue
    * @return char that represents the option to continue 
    * @throws customThrowable a throwable that is used to check and throw custom lines
    * @throws emptyLineException a throwable that is used to read empty lines 
    * @throws InputMissmatchException checks if the input given is a the correct type
    */
    public char setToContinue()
    {
        while(tocontinue == 'q')
        {
            try
            {
                String choose;
                System.out.print("Would you like to enter another employee? (Y/N): ");
                choose = scnr.nextLine().toLowerCase();
                if(choose.isEmpty())
                {
                    throw new emptyLineException("Enter pressed - Try again.");
                }
                tocontinue = choose.charAt(0);
                if(tocontinue != 'y' && tocontinue != 'n')
                {
                    tocontinue = 'q';
                    throw new customThrowable("Only Y/N allowed");
                }
                
            }
            catch(InputMismatchException ime)
            {
                System.out.println("Only characters allowed");
            }
            catch(customThrowable nie)
            {
                System.out.println(nie.getMessage());
            }
            catch(emptyLineException ele)
            {
                System.out.println(ele.getMessage());
            }
        }
        return tocontinue;
    }

      /**
    * gets hour worked when called upon
    * @param toDisplay is the string to display
    * @return double of the employee, hours worked 
    * @throws emptyLineException a throwable that is used to read empty lines 
    * @throws InputMissmatchException checks if the input given is a the correct type
    */
    public double getHourWorked(String toDisplay)
    {
        double hoursWorked = -1.1;
        while(hoursWorked == -1.1)
        {
            try
            {
            System.out.print(toDisplay);
            hoursWorked = Double.parseDouble(scnr.nextLine());
            }
            catch(InputMismatchException ime)
            {
                System.out.println("Input must be a number");
            }
            catch( NumberFormatException nfe)
            {
                System.out.println("Hours cannot be empty");
            }
        }
        return hoursWorked;

    }

      /**
    * gets the id to delete from input
    * @return string of the employee, to delete 
    * @throws emptyLineException a throwable that is used to read empty lines 
    */
    public String getIdToDelete()
    {
        String idToDelete = "";
        while(idToDelete.isEmpty())
        {
            try
            {
                System.out.println("enter an ID number to delete employee: ");
                idToDelete = scnr.nextLine();
                if(idToDelete.isEmpty())
                {
                    throw new emptyLineException("Error - blank line detected");
                }

            }
            catch(emptyLineException ele)
            {
                System.out.println(ele.getMessage());
            }
        }
        return idToDelete;
        
    } //delete id to delete

      /**
    * fatal error display 
    * @param display will be used to display error
    */
    public void fatalError(String display)
    {
        System.out.println(display);
    }

    /**
    * duplicate error display 
    * @param display will be used to display error
    */
    public void duplicateError(String display)
    {
        System.out.println(display);
    }

    /**
    * spacing used for the program 
    */
    public void spacing()
    {
        System.out.println("\n");
    }

    /**
    * display 
    * @param str string to display simple messsage
    */
    public void displayer(String str)
    {
        System.out.println(str);
    }

    /**
    * display for doubles 
    * @param str will be used to display message
    * @param num number to display
    */
    public void displayer(String str, double num)
    {

        System.out.printf(str +"%.2f",num);
    }

}

//custom exceptions (learned from zybook optional section 11.6)
//extends the exception class to use my new customThrowable and use it to display problems

class customThrowable extends Exception
{
    /**
    * makes a new custom throwable exception class extention
    * @param display will be used to display error
    */
    public customThrowable(String msgPassed)
    {
        super(msgPassed);
    }
}

class emptyLineException extends Exception
{
    /**
    * makes a new custom throwable exception class extention
    * @param display will be used to display error
    */
    public emptyLineException(String msgPassed)
    {
        super(msgPassed);
    }
}