package com.bridgelabz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
interface IComputeEmpWage {
    public   void addCompanyEmpWage(String company, int wagePerHour, int totalWorkingDays, int maxWorkingHour);
    public void computeEmpWage();
    public int getTotalWage(String company);
}
public class EmployeeWageComputation implements IComputeEmpWage {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    private int numOfCompany = 0;
    private final LinkedList<CompanyEmpWage> companyEmpWageList;
    private final Map<String, CompanyEmpWage> companyToEmpWageMap;
    public EmployeeWageComputation() {
        companyEmpWageList = new LinkedList<>();
        companyToEmpWageMap = new HashMap<>();
    }
    public void addCompanyEmpWage(String company, int emp_rate_per_hour, int num_of_working_days, int max_hours_in_month) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, emp_rate_per_hour, num_of_working_days, max_hours_in_month);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWageMap.put(company, companyEmpWage);
        numOfCompany++;
    }
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= companyEmpWage.max_hours_in_month
                && totalWorkingDays < companyEmpWage.num_of_working_days) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day: " + totalWorkingDays + " Emp Hr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.emp_rate_per_hour;
    }
    public int getTotalWage(String company) {
      return companyToEmpWageMap.get(company).totalEmpWage;
    }

public static void main(String[] args) {
    System.out.println("Welcome to Employee Wage Computation Program!");
    IComputeEmpWage empWageBuilder = new EmployeeWageComputation();
    empWageBuilder.addCompanyEmpWage("Jio", 20, 25, 100);
    empWageBuilder.addCompanyEmpWage("Tata", 10, 23, 200);
    empWageBuilder.computeEmpWage();
    System.out.println( empWageBuilder.getTotalWage("Jio"));
    System.out.println( empWageBuilder.getTotalWage("Tata"));
    }
}

