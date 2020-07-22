public class EmpWageBuilder {
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;

    public static void computeEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsInMonth) {
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
        int totalEmpWage= totalEmpHrs * empRatePerHr;
        System.out.println("Total Employee Wage of " + company + " is " + totalEmpWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        computeEmpWage("Airtel", 25, 20, 100);
        computeEmpWage("Jio", 20, 25, 200);
    }
}
