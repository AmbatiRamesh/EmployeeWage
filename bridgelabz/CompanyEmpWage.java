package com.bridgelabz;

public class CompanyEmpWage {
    public final String COMPANY_NAME;
    public final int WAGE_PER_HR;
    public final int MAX_WORKING_DAYS;
    public final int MAX_WORKING_HRS;
    // instance variable
    public int totalEmpWage;
    /*Constructor of same class*/
    public CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        this.COMPANY_NAME = companyName;
        this.WAGE_PER_HR = wagePerHr;
        this.MAX_WORKING_DAYS = maxWorkingDays;
        this.MAX_WORKING_HRS = maxWorkingHrs;
        this.totalEmpWage = 0;
    }
    public void setTotalEmployeeWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }
    @Override
    public String toString() {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "The total employee wage of " + COMPANY_NAME + " is " + totalEmpWage + "\n";
    }
}


