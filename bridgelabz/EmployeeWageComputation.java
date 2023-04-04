package com.bridgelabz;
interface IComputeEmpWage {
    public void addCompanyEmpWage(String company, int wagePerHour, int totalWorkingDays, int maxWorkingHour);

    public int computeEmpWage(CompanyEmpWage companyEmpWage);

    public void printTotalWage();
}
public class EmployeeWageComputation implements IComputeEmpWage{
  public static final int IS_PART_TIME = 1;
  public static final int IS_FULL_TIME = 2;
  private int numOfCompany = 0;
  private CompanyEmpWage[] companyEmpWageArray;
   public EmployeeWageComputation() {
        companyEmpWageArray = new CompanyEmpWage[5];
   }
   public void addCompanyEmpWage(String company, int emp_rate_per_hour, int num_of_working_days,
        int max_hours_in_month) {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, emp_rate_per_hour, num_of_working_days, max_hours_in_month);
        numOfCompany++;
   }
   public void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
        companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
        }
   }
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0;
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
        System.out.println("Day: " + totalWorkingDays + " EmpHr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.emp_rate_per_hour;
   }
    public void printTotalWage() {
        for (int i = 0; i < numOfCompany; i++) {
            System.out.println("Total salary for " + companyEmpWageArray[i].getCompany() + ": $"
                    + companyEmpWageArray[i].getTotalEmpWage());
        }
    }
public static void main(String[] args) {
    System.out.println("Welcome to Employee Wage Computation Program!");
    EmployeeWageComputation empWageBuilder = new EmployeeWageComputation();
    empWageBuilder.addCompanyEmpWage("Jio", 20, 25, 100);
    empWageBuilder.addCompanyEmpWage("Tata", 10, 23, 200);
    empWageBuilder.computeEmpWage();
    empWageBuilder.printTotalWage();
    }
}

