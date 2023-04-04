package com.bridgelabz;
public class EmployeeWageComputation {
    public static final int IS_ABSENT= 0;
    public static final int IS_PRESENT = 1;
    public static final int IS_PART_TIME = 2;
    public static final int FULL_TIME_WORKING_HRS = 8;
    public static final int PART_TIME_WORKING_HRS = 4;

    private final  String companyName;
    private final int totalWorkingHrsInMonth;
    private final int workingDaysInMonth;
    private final int empWagePerHour;
    private int totalMonthlyWageOfEmp;
    public EmployeeWageComputation(String companyName, int totalWorkingHrsInMonth, int workingDaysInMonth, int empWagePerHour) {
        this.companyName = companyName;
        this.totalWorkingHrsInMonth = totalWorkingHrsInMonth;
        this.workingDaysInMonth = workingDaysInMonth;
        this.empWagePerHour = empWagePerHour;
    }
    public void empWageComputation() {
        int totalEmpWagePerDay = 0, totalNoOfHrsWorked = 0, totalNoOfDaysWorked = 0;
        while (totalNoOfDaysWorked <= workingDaysInMonth && totalNoOfHrsWorked <= totalWorkingHrsInMonth) {
            double empCheck = Math.floor(Math.random() * 10) % 3;
            int empSwitchCheck = (int) empCheck;
            switch (empSwitchCheck) {
                case IS_PRESENT:
                    totalNoOfHrsWorked = totalNoOfHrsWorked + FULL_TIME_WORKING_HRS;
                    totalNoOfDaysWorked = totalNoOfDaysWorked + 1;
                    totalEmpWagePerDay = FULL_TIME_WORKING_HRS * empWagePerHour;
                    totalMonthlyWageOfEmp = totalMonthlyWageOfEmp + totalEmpWagePerDay;
                    break;
                case IS_PART_TIME:
                    totalNoOfHrsWorked = totalNoOfHrsWorked + PART_TIME_WORKING_HRS;
                    totalNoOfDaysWorked = totalNoOfDaysWorked + 1;
                    totalEmpWagePerDay = PART_TIME_WORKING_HRS * empWagePerHour;
                    totalMonthlyWageOfEmp = totalMonthlyWageOfEmp + totalEmpWagePerDay;
                    break;
                default:
                    totalNoOfDaysWorked = totalNoOfDaysWorked + 1;
            }
        }
    }
    @Override
    public String toString() {
        return "EmpWageComputation [companyName=" + companyName + ", totalEmpWage=" + totalMonthlyWageOfEmp + "]";
    }
    public static void main(String[] args) {
        EmployeeWageComputation jio = new EmployeeWageComputation("jio",100,25,20);
        EmployeeWageComputation mart = new EmployeeWageComputation("dmart",80,25,20);
        EmployeeWageComputation bigC = new EmployeeWageComputation("bigC",90,25,20);
        jio.empWageComputation();
        mart.empWageComputation();
        bigC.empWageComputation();
        System.out.println(jio);
        System.out.println(mart);
        System.out.println(bigC);
    }
}