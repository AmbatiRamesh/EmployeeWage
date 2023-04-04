package com.bridgelabz;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
public class EmployeeWageComputation implements EmployeeWageBuilder {
    public static final int PART_TIME = 1;          // class constant
    public static final int FULL_TIME = 2;
    private LinkedList<CompanyEmpWage> companyEmpWageList;                        // instance variables
    private HashMap<String,CompanyEmpWage> companyEmpWageHashMap;
    public EmployeeWageComputation(int n) {                  //Constructor of same class
        companyEmpWageList = new LinkedList<>();             //using arraylist
        companyEmpWageHashMap = new HashMap<>();             //using hashmap
    }
    public void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
        companyEmpWageList.add(companyEmpWage);
        companyEmpWageHashMap.put(companyName,companyEmpWage);
    }
    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmployeeWage(this.computeEmpWage(companyEmpWage));
            companyEmpWage.storeDailyWage();
            System.out.println(companyEmpWage);
        }
    }
    public int getTotalWage(String company){                           //method to get total wage when asked by company
        return companyEmpWageHashMap.get(company).totalEmpWage;
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {           // Compute Wage method
        int empHrs;                                                      // Local variables
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        companyEmpWage.dailyWage = new  int[companyEmpWage.MAX_WORKING_DAYS];
        System.out.println("Calculating Wage for Company: " + companyEmpWage.COMPANY_NAME);
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
            }
            totalEmpHrs += empHrs;
            companyEmpWage.dailyWage[totalWorkingDays-1] = empHrs * companyEmpWage.WAGE_PER_HR;
            System.out.println("Day: " + totalWorkingDays + "\tEmployee Hour: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.WAGE_PER_HR;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        System.out.println("************************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of companies: ");
        int number = scanner.nextInt();
        EmployeeWageBuilder empWageBuilder = new EmployeeWageComputation(number);                 //Object creation
        for (int i = 0; i < number; i++) {
            System.out.println("Enter Company Details as given:\n1. CompanyName\t2. EmployeeRatePerHour\t3. NoOfWorkingDays\n4. MaxHoursPerMonth");
            empWageBuilder.addCompany(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        empWageBuilder.computeEmpWage();                 // Method calling
        System.out.println("Enter the company name: ");
        /*The total wage will be shown after being asked to enter the company name*/
        System.out.println("The total employee wage is " + empWageBuilder.getTotalWage(scanner.next()));
    }
}