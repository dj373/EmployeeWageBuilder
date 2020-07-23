import java.util.*;
interface ComputeEmpWageInterface {
	public void addCompanyDetails(String company, int empRatePerHr, int maxHrsPerMonth, int numWorkingDays);
	public void computeEmpWage();
	public void getTotalWage(String company);
}
class CompanyEmployeeWage {
    public String company;
    public int empRatePerHr;
    public int numOfWorkingDays;
    public int maxHrsInMonth;
    public int totalEmpWage;
    public ArrayList<Integer> dailyWages;
    CompanyEmployeeWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsInMonth) {
        this.company=company;
        this.empRatePerHr=empRatePerHr;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHrsInMonth=maxHrsInMonth;
	this.dailyWages= new ArrayList<Integer>();
    }
    public void setTotalWage(int totalEmpWage)
    {
    	this.totalEmpWage=totalEmpWage;
    }
    @Override
    public String toString(){
        return "Total Employee Wage of " + company + " is " + totalEmpWage;
    }
    public void addDailyWage(int dailyWage) {
    	this.dailyWages.add(dailyWage);
    }
}
public class EmpWageBuilder implements ComputeEmpWageInterface {
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;

    private int companyNo=0;
    private ArrayList<CompanyEmployeeWage> companyEmployeeWageArray;
    private HashMap<String,CompanyEmployeeWage> companyTotalWageMap;
    EmpWageBuilder () {
        companyEmployeeWageArray = new ArrayList<CompanyEmployeeWage>();
    	companyTotalWageMap = new HashMap<String,CompanyEmployeeWage>();
    }

    public void addCompanyDetails(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsInMonth)
    {
	CompanyEmployeeWage companyEmployeeWage = new CompanyEmployeeWage(company,empRatePerHr,numOfWorkingDays,maxHrsInMonth);
	companyEmployeeWageArray.add(companyEmployeeWage);
	companyTotalWageMap.put(company,companyEmployeeWage);
    }

    public void computeEmpWage() {
        for (int i=0; i<companyEmployeeWageArray.size(); i++) {
	        companyEmployeeWageArray.get(i).setTotalWage(this.computeEmpWage(companyEmployeeWageArray.get(i)));
	        System.out.println(companyEmployeeWageArray.get(i));
        }
    }

    private int computeEmpWage(CompanyEmployeeWage companyEmployeeWage) {
        int empHrs=0;
        int totalWorkingDays=0;
        int totalEmpHrs=0;
        while (totalEmpHrs <= companyEmployeeWage.maxHrsInMonth && totalWorkingDays < companyEmployeeWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck= (int) Math.floor(Math.random() * 10)%3;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs=4;
                    break;
                case IS_FULL_TIME:
                    empHrs=8;
                    break;
                default:
                    empHrs=0;
            }
            totalEmpHrs+=empHrs;
	    int dailyWage=empHrs*companyEmployeeWage.empRatePerHr;
            System.out.println("Day " + totalWorkingDays + " Employee Hrs: " + empHrs + " Daily Wage: " + dailyWage);
            companyEmployeeWage.addDailyWage(dailyWage);
	}
        return totalEmpHrs * companyEmployeeWage.empRatePerHr;
    }
    @Override
    public void getTotalWage(String company) {
    	System.out.println("Total Wage for "+company+" is "+companyTotalWageMap.get(company).totalEmpWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        ComputeEmpWageInterface empWageObject = new EmpWageBuilder();
        empWageObject.addCompanyDetails("Airtel", 25, 20, 200);
	empWageObject.addCompanyDetails("Jio", 20, 25, 100);
        empWageObject.computeEmpWage();
	System.out.println();
	empWageObject.getTotalWage("Airtel");
	empWageObject.getTotalWage("Jio");
    }
}
