public class EmpWageBuilder {
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;

    private final String company;
    private final int empRatePerHr;
    private final int numOfWorkingDays;
    private final int maxHrsInMonth;
    private int totalEmpWage;

    public EmpWageBuilder (String company, int empRatePerHr, int numOfWorkingDays, int maxHrsInMonth) {
    	this.company=company;
        this.empRatePerHr=empRatePerHr;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHrsInMonth=maxHrsInMonth;
    }

    public void computeEmpWage() {
        int empHrs=0;
        int totalWorkingDays=0;
        int totalEmpHrs=0;
        while (totalEmpHrs <= maxHrsInMonth && totalWorkingDays < numOfWorkingDays) {
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
        totalEmpWage= totalEmpHrs * empRatePerHr;
    }

    @Override
    public String toString() {
    	return "Total Employee Wage of " + company + " is " + totalEmpWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmpWageBuilder airtel = new EmpWageBuilder ("Airtel", 25, 20, 200);
        EmpWageBuilder jio = new EmpWageBuilder ("Jio", 20, 25, 100);
        airtel.computeEmpWage();
        System.out.println(airtel);
        jio.computeEmpWage();
        System.out.println(jio);
    }
}
