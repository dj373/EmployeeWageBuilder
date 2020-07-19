public class EmpWageBuilder {
	public static void main (String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
		final int IS_FULL_TIME=1;
		final int EMP_RATE_PER_HR=20;
		int empHrs=0;
		int empWage=0;
		double empCheck=Math.floor(Math.random() * 10)%2;
		if (empCheck == IS_FULL_TIME)
		    empHrs=8;
		empWage= empHrs * EMP_RATE_PER_HR;
		System.out.println("Employee Wage: " + empWage);
	}
}
