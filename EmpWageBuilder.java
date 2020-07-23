class CompanyEmployeeWage {
    public String company;
    public int empRatePerHr;
    public int numOfWorkingDays;
    public int maxHrsInMonth;
    public int totalEmpWage;
    CompanyEmployeeWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsInMonth) {
        this.company=company;
        this.empRatePerHr=empRatePerHr;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHrsInMonth=maxHrsInMonth;
    }
    public void setTotalWage(int totalEmpWage)
    {
    	this.totalEmpWage=totalEmpWage;
    }
    @Override
    public String toString(){
        return "Total Employee Wage of " + company + " is " + totalEmpWage;
    }
}
public class EmpWageBuilder {
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;

    private int companyNo=0;
    private int numOfCompanies;
    private CompanyEmployeeWage[] companyEmployeeWageArray;

    EmpWageBuilder (int numOfCompanies) {
    	this.numOfCompanies=numOfCompanies;
        companyEmployeeWageArray = new CompanyEmployeeWage[numOfCompanies];
    }

    private void addCompanyDetails(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsInMonth)
    {
	companyEmployeeWageArray[companyNo++]=new CompanyEmployeeWage(company,empRatePerHr,numOfWorkingDays,maxHrsInMonth);
    }

    private void computeEmpWage() {
        for (int i=0; i<numOfCompanies; i++) {
	        companyEmployeeWageArray[i].setTotalWage(computeEmpWage(companyEmployeeWageArray[i]));
	        System.out.println(companyEmployeeWageArray[i]);
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
            System.out.println("Day " + totalWorkingDays + " Employee Hrs: " + empHrs);
        }
        return totalEmpHrs * companyEmployeeWage.empRatePerHr;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmpWageBuilder empWageObject = new EmpWageBuilder(2);
        empWageObject.addCompanyDetails("Airtel", 25, 20, 200);
	empWageObject.addCompanyDetails("Jio", 20, 25, 100);
        empWageObject.computeEmpWage();
    }
}
