package com.bridgelabz;
public class EmployeeWageComputation {
    public static final int PART_TIME = 1;          // class constant
    public static final int FULL_TIME = 2;
    int companies = 0;                        // instance variables
    private CompanyEmpWage[] companyArray;
    public EmployeeWageComputation() {                  //Constructor of same class
        companyArray = new CompanyEmpWage[5];
    }
    private void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        companyArray[companies] = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
        companies++;
    }
    private void computeEmpWage() {
        for (int i = 0; i < companies; i++) {
            companyArray[i].setTotalEmployeeWage(this.computeEmpWage(companyArray[i]));
            System.out.println(companyArray[i]);
        }
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {           // Compute Wage method
        int empHrs;                                               // Local variables
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        while (totalEmpHrs <= companyEmpWage.MAX_WORKING_HRS && totalWorkingDays < companyEmpWage.MAX_WORKING_DAYS) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            // Case Checking
            switch (empCheck) {
                case PART_TIME:
                    empHrs = 4;
                    break;
                case FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
                    break;
            }// End Case
            totalEmpHrs += empHrs;
            System.out.println("Day: " + totalWorkingDays + "\tEmp Hr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.WAGE_PER_HR;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        System.out.println("************************************");
        EmployeeWageComputation empWageBuilder = new EmployeeWageComputation();                 //Object creation
        empWageBuilder.addCompany("Flipkart", 20, 20, 15);
        empWageBuilder.addCompany("Reliance", 15, 25, 20);
        empWageBuilder.addCompany("Tata", 17, 22, 18);
        empWageBuilder.computeEmpWage();         // Method calling
    }
}