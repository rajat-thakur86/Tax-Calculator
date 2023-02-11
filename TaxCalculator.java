import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TaxCalculator {
    public static void main(String[] args) {
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|                            TAX CALCULATOR                             |");
        System.out.print("|-----------------------------------------------------------------------|\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("|       * ENTER YOUR NAME -> ");
        String name = sc.nextLine();
        System.out.println("|-----------------------------------------------------------------------|");

        System.out.print("|       * ENTER YOUR AGE -> ");
        int age = sc.nextInt();
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|       * ENTER YOUR SALARY SOURCE                                      |");
        System.out.println("|             : Employee                                                |");
        System.out.println("|             : Business                                                |");
        System.out.println("|             : Professional                                            |");
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.print("|           --> ");
        String salarySource = sc.next();
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.print("|       * ENTER YOUR SALARY (INCLUDING DA,TA ETC.) -> ");
        double salary = sc.nextDouble();
        System.out.println("|-----------------------------------------------------------------------|");

        double annualIncome = salary * 12;
        double grossIncome = annualIncome + (0.1 * annualIncome);
        // System.out.println("Annual Income: " + annualIncome);
        // System.out.println("Gross Income: " + grossIncome);

        System.out.println("|                              CALCULATING...                           |");
        System.out.print("|-----------------------------------------------------------------------|\n");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ------------------------------------------------------------------------------
        // Scientific notation representation of the number can be displayed as a
        // regular decimal number by using - String.format() method
        System.out.println("|                     ANNUAL INCOME -> " + String.format("%.0f", annualIncome));
        System.out.println("|                      GROSS INCOME -> " + String.format("%.0f", grossIncome));
        // ------------------------------------------------------------------------------

        // Tax calculation under old tax regime
        double taxOld = 0;
        if (annualIncome <= 500000) {
            taxOld = 0;
        } else if (annualIncome <= 1000000) {
            taxOld = 0.1 * (annualIncome - 500000);
        } else {
            taxOld = 0.1 * 500000 + 0.2 * (annualIncome - 1000000);
        }
        System.out.println("|              TAX UNDER OLD REGIME -> " + taxOld + " Rs");

        double netIncomeOld = annualIncome - taxOld;
        System.out.println("|       NET INCOME UNDER OLD REGIME -> " + netIncomeOld + " Rs");

        // Tax calculation under new tax regime
        double taxNew = 0;
        if (grossIncome <= 250000) {
            taxNew = 0;
        } else if (grossIncome <= 500000) {
            taxNew = 0.05 * (grossIncome - 250000);
        } else if (grossIncome <= 750000) {
            taxNew = 12500 + 0.1 * (grossIncome - 500000);
        } else if (grossIncome <= 1000000) {
            taxNew = 37500 + 0.15 * (grossIncome - 750000);
        } else if (grossIncome <= 1250000) {
            taxNew = 75000 + 0.2 * (grossIncome - 1000000);
        } else if (grossIncome <= 1500000) {
            taxNew = 125000 + 0.25 * (grossIncome - 1250000);
        } else {
            taxNew = 187500 + 0.3 * (grossIncome - 1500000);
        }
        System.out.println("|              TAX UNDER NEW REGIME -> " + taxNew + " Rs");

        double netIncomeNew = grossIncome - taxNew;
        System.out.println("|       NET INCOME UNDER NEW REGIME -> " + netIncomeNew + " Rs");

        // calculates the percentage increase or decrease in salary by comparing the
        // netIncomeNew Regime and netIncomeOld Regime
        double diff = netIncomeNew - netIncomeOld;
        double percentDiff = (diff / netIncomeOld) * 100;
        if (diff > 0) {
            System.out.print("|     PERCENT OF INCREASE IN SALARY -> ");
            System.out.println(String.format("%.2f", percentDiff) + "%");
        } else {
            System.out.print("|     PERCENT OF DECREASE IN SALARY ->");
            System.out.println(String.format("%.2f", percentDiff) + "%");
        }

        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|                             !! NOTE !!                                |");
        System.out.println("|-----------------------------------------------------------------------|");
        // Comparison of tax payable under both regimes
        if (taxNew < taxOld) {
            System.out.println("|             YOU CAN SAVE TAX BY OPTING FOR THE NEW REGIME.            |");
        } else {
            System.out.println("|             YOU CAN SAVE TAX BY OPTING FOR THE OLD REGIME.            |");

        }
        System.out.println("|-----------------------------------------------------------------------|");
    }
}
