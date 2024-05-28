/**
* Proj9.java
* Eder Martinez/ Thu 2:30 
* Proj 8 is the main brains of the project. It calls the employee class and view console to be used to
* display. It will continually ask if they want to add more employees. Allows the user to info and delete too
*/
import java.util.ArrayList;

public class Proj9
{
    public static void main(String[]args)
    {
        //
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        //call for input and validate then add to list
        char flag = 'y';
        while(flag == 'y')
        {
            int yearlySal = -1;
            double setPayRate = -1;
            String name = "";
            String idNum = "";
            char sortEmp;

            //information getter prompts user to give info
            View_Console getter = new View_Console();

            getter.spacing();
            name = getter.setName();
            idNum = getter.setID();
            sortEmp = getter.setType();
            if(sortEmp == 's')
            {
                yearlySal = getter.setyearlySal();
            }
            else if(sortEmp =='h')
            {
                setPayRate = getter.setPayRate();
            }
            else
            {
                getter.fatalError("Fatal error... exiting the application");
                flag = 'd';
                break;
            }
            //checks if the curring id is in the list returns to beggining if it is in
            


            //checks if the employee is in the list 
            int resetIfInList = 0; //0 is do not reset
            for(int i = 0; i<employeeList.size(); i++)
            {
                if(employeeList.get(i).getIdNumber().equals(idNum))
                {
                    getter.duplicateError("Duplicate employee - not added to the list");
                    resetIfInList = 1;;
                }
            }
            if(resetIfInList ==1)
            {
                flag =getter.setToContinue();
                if(flag == 'y')
                {
                    continue;
                }
                else
                {
                    break;
                }
            }   

            //asks if we will continue
            flag = getter.setToContinue();

  
            //as long as everything checks out it will be added. chooses which one to add depending on which one is not touched
            if(yearlySal!= -1)
            {
                employeeList.add(new Employee(name, idNum, sortEmp, yearlySal));
            }
            else if(setPayRate != -1.0)
            {
                employeeList.add(new Employee(name,idNum, sortEmp, setPayRate));
            }

        }
        //final part. printing
        View_Console printer = new View_Console();

        printer.displayer("Current contents of ArrayList:\n");

        for(int i = 0; i<employeeList.size(); i++)
        {
            printer.displayer(employeeList.get(i).toString());

            if(employeeList.get(i).getEmployeeType() == 's')
            {
                double salGP = employeeList.get(i).getGrossPay();
                printer.displayer("Weekly Gross Pay - $", salGP);
            }
            else if(employeeList.get(i).getEmployeeType() == 'h')
            {
                double getHours = printer.getHourWorked("Enter hours " + employeeList.get(i).getName() + " worked: ");
                //gotta get payrate too
                double getPayRate = employeeList.get(i).getPayRate();
                printer.displayer("Weekly Gross Pay - $", getPayRate*getHours);

            }
            printer.displayer("\n");
        }

        int flagToDelete = 1;
        while(flagToDelete == 1)
        {
            String idToDelete = printer.getIdToDelete();
            for(int y = 0; y<employeeList.size(); y++)
            {
                if(employeeList.get(y).getIdNumber().equals(idToDelete))
                {
                    flagToDelete = 0;
                    printer.displayer("Employee with ID #" + employeeList.get(y).getIdNumber() + " removed from ArrayList");
                    employeeList.remove(y);
                } //if the match is positive
            }
            if(flagToDelete == 1)
            {
                printer.displayer("ERROR - ID # not found. Please try again");
            }
            

        }

        printer.displayer("Final Contents of the ArrayList: ");

        for(int i = 0; i<employeeList.size(); i++)
        {
            printer.displayer(employeeList.get(i).toString());
        }
        
        
        
    }
}