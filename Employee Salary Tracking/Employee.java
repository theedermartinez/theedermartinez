/**
* Employee.java
* Eder Martinez/ Thu 2:30 
* a class that will hold and create an object that will represent an emploeyee. It will utilize the 
*************extra credit included (2nd one)******************************
* yearly salary or pay rate depending on what type of employee means. able to return all the elements to be used 
* in the main
*/
public class Employee
{
    private String name;
    private String idNumber;
    private char employeeType;
    private double payRate;
    private int yearlySalary;
    private final int WEEKS_IN_YEAR = 52;

    //contructor for hourly
/** 
*Constructor for employee class yearly
* @param n string that takes in the name of the employee
* @param id String that sets the id of the employee
* @param et Char representing employee type 
* @param hr double represents the hours worked
*/
    public Employee(String n, String id, char et, double hr)
    {
        name = n;
        idNumber = id;
        employeeType = et;
        payRate = hr;
        yearlySalary = -1;
    }
/** 
*Constructor for employee class salaried
* @param n string that takes in the name of the employee
* @param id String that sets the id of the employee
* @param et Char representing employee type 
* @param ys yearly salary
*/
    //constructor for salaried 
    public Employee(String n, String id, char et, int ys)
    {
        name = n;
        idNumber = id;
        employeeType = et;
        yearlySalary = ys;
        payRate = -1;
    }
//+++++++++++++++++++++++++++++++++++++++end of contructors++++++++++++++++++++++++++++++++++++//
    
/**
* calculates gross pay from hour worked
* @param hw hours worked used to calculate
* @return gross pay
*/
    public double getGrossPay(double hw)
    {
        if(hw > 40)
        {
            double overTimeHours = hw - 40;
            double overtimeRate = (payRate * 1.5) + payRate;
            double overTimeMoney = overTimeHours * overtimeRate;
            return overTimeMoney * (40 * payRate);                              
        }
        else
        {
            return hw * payRate;
        }

    }
    

//for salaried employees (returns weekly salary)
/**
gets grosspay (yearly salady divided by weeks)
* @return gross pay yearly
*/
    public double getGrossPay()
    {
        return yearlySalary/WEEKS_IN_YEAR;
    }
    
//to return a string to print 
/**
* returns a string that can be used.
* @return string that can be used
*/
    public String toString()
    {
        return (name + "\n" + "ID #"+ idNumber);
    }
    //tests the value of two employees and checks for equality
    public boolean equals(Employee person)
    {
        if(person.getIdNumber().equals(idNumber))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //+++++++++++added methods++++++++++++++++++++

/**
* returns id number as a string
* @return String current id number 
*/
public String getIdNumber()
    {
        return idNumber;
    }
/**
* returns type of employee as employeetype
* @return String current id number 
*/
    public char getEmployeeType()
    {
        return employeeType;
    }
/**
* returns name of employee as a string
* @return name 
*/
    public String getEmployeeSName()
    {
        return name;
    }
/**
* returns get pay rate as a double
* @return double to repreent payrate 
*/

    public double getPayRate()
    {
        return payRate;
    }
/**
* returns employee name number as a string
* @return String current id number 
*/
    public String getName()
    {
        return name;
    }




}