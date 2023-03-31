package com.bridgelabz;
public class EmployeeWageComputation {
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 4;
    static final int FULL_TIME = 1;
    static final int PART_TIME = 2;
    static void computeEmpWage(int workingDayPerMonth,int totalWorkingHours,int wagePerHour){
        int empwage = 0, workingday = 1, totalempwage = 0, workinhHrs=0;//local variable computeEmpWage Block
        while (workingday <= workingDayPerMonth && workinhHrs<=totalWorkingHours) {
            double empcheck = (int) Math.floor(Math.random() * 10) % 3;
            switch ((int) empcheck) {
                case FULL_TIME:
                    System.out.println("Employee is Present");
                    empwage = wagePerHour * FULL_DAY_HOUR;
                    System.out.println("working days: " + workingday);
                    System.out.println("EmpWage: " + empwage);
                    totalempwage = empwage + totalempwage;
                    workinhHrs = workinhHrs + FULL_DAY_HOUR;
                    break;
                case PART_TIME:
                    System.out.println("Employee is Part-time");
                    empwage = wagePerHour * PART_TIME_HOUR;
                    System.out.println("working days: " + workingday);
                    System.out.println("EmpWage: " + empwage);
                    totalempwage = empwage + totalempwage;
                    workinhHrs = workinhHrs + PART_TIME_HOUR;
                    break;
                default:
                    System.out.println("Employee is Absent");
                    System.out.println("working days: " + workingday);
                    System.out.println("EmpWage: " + empwage);
                    break;
            }
            workingday++;
        }
        System.out.println("--------------");
        System.out.println("Total Working Hrs:>" + workinhHrs + "\n-------------- \nTotal Wage:>" + totalempwage);
    }
    public static void main(String[] args) {
        computeEmpWage(26,150,15);
    }
}