package com.bridgelabz;
import java.util.ArrayList;
import java.util.List;
public class CompanyEmpWage {
    public final String company;
    public final int emp_rate_per_hour;
    public final int num_of_working_days;
    public final int max_hours_in_month;
    public int totalEmpWage;
    private List<Integer> dailyWages;
    public CompanyEmpWage(String company, int emp_rate_per_hour, int num_of_working_days, int max_hours_in_month) {
        this.company = company;
        this.emp_rate_per_hour = emp_rate_per_hour;
        this.num_of_working_days = num_of_working_days;
        this.max_hours_in_month = max_hours_in_month;
        totalEmpWage = 0;
        this.dailyWages = new ArrayList<Integer>();
    }
    public String getCompany() {
        return company;
    }
    public int getEmp_rate_per_hour() {
        return emp_rate_per_hour;
    }
    public int getNum_of_working_days() {
        return num_of_working_days;
    }
    public int getMax_hours_in_month() {
        return max_hours_in_month;
    }
    public int getTotalEmpWage() {
        return totalEmpWage;
    }
    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }
    public void addDailyWage(int dailyWage) {
        this.dailyWages.add(dailyWage);
    }
    public List<Integer> getDailyWages() {
        return dailyWages;
    }
    @Override
    public String toString() {
        return "CompanyEmpWage [company=" + company + ", emp_rate_per_hour=" + emp_rate_per_hour
                + ", num_of_working_days=" + num_of_working_days + ", max_hours_in_month=" + max_hours_in_month
                + ", totalEmpWage=" + totalEmpWage + ", dailyWages=" + dailyWages + "]";
    }
}