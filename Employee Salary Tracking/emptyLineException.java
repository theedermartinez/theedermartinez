import java.util.*;
//custom exceptions (learned from zybook optional section 11.6)
//extends the exception class to use my new customThrowable and use it to display problems
public class customThrowable extends Exception
{
    public customThrowable(String msgPassed)
    {
        super(msgPassed);
    }
}

public class emptyLineException extends Exception
{
    public emptyLineException(String msgPassed)
    {
        super(msgPassed);
    }
}
//view console main class
public class View_Console
{
    private Scanner scnr;
    private String name;
    private String id;
    private char empType;
    private int yearlySal = -1;
    private double payRate = -1;
    private char tocontinue = 'q';

    //constructor for scanner
    public View_Console()
    {
        scnr = new Scanner(System.in);
    }
    //gets name of the employee
    public String setName()
    { 
        while(name.isEmpty())
        {
            try
            {
                System.out.println("Enter employee's name: ");
                name = scnr.nextLine();
                if(name.isEmpty())
                {
                    throw new customThrowable("Mame is required. Please re-enter");
                }

            }
            catch(customThrowable nne)
            {
                System.out.println(nne.getMessage());
            }
        }
        return name;
    }
    //gets id for the userid from user
    public String setID()
    {
        while(id.isEmpty())
        {
            try
            {
                System.out.println("Enter " + name + "'s ID #:");
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
    public char setType()
    {
        String empTypeStr;
        while(empType != 's' || empType != 'h')
        {
            try
            {
                System.out.println("Is the employee S)alaried or H)ourly");
                empTypeStr = scnr.nextLine();
                if(empTypeStr.isEmpty())
                {
                    throw new customThrowable("Employee Type is required. Please re-enter");
                }
                
                empType = Character.toLowerCase(empTypeStr.charAt(0));
                if(empType != 's' || empType != 'h')
                {
                    throw new customThrowable("must be an 'H or 'S'");
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
            return empType;
        }
    }
    // gets yearly salary from user, runs while yearlysal is -1 (starts at -1)
    public int setyearlySal()
    {
        while(yearlySal == -1)
        {

            try
            {
                System.out.println("Enter" + name + "'s yearly salary: ");
                yearlySal = Integer.parseInt(scnr.nextLine());
            }
            catch(InputMismatchException ime)
            {
                System.out.println("No chars or decimals allowed. Enter integers only");
            }
        }
        return yearlySal;
    }   

    public double setPayRate()
    {
        while(payRate == -1)
        {
            try
            {
                System.out.println("Enter " + name + " 's pay rate");
                payRate = Integer.parseInt(scnr.nextLine());

            }
            catch(InputMismatchException ime)
            {
                System.out.println("No chars allowed. Enter doubles only");
            }
        }
        return payRate;

    }

    public char setToContinue()
    {
        while(tocontinue == 'q')
        {
            try
            {
                System.out.println("Would you like to enter another employee? (Y/N):");
                String choose = scnr.nextLine().toLowerCase();
                tocontinue = choose.charAt(0);
                if(choose != 'y' || choose != 'n')
                {
                    choose =  'q';
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
        }
        return tocontinue;
    }

    public void fatalError(String display)
    {
        System.out.println(display);
    }

    public String duplicateError(String display)
    {
        System.out.println(display);
    }

    public String spacing()
    {
        System.out.println("\n");
    }

}