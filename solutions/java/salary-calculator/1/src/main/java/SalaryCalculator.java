public class SalaryCalculator {
    private final int DAY_SKIP_LIMIT = 5;
    private final int PRODUCT_BONUS_LIMIT = 20;
    private final int BASE_SALARY = 1000;
    private final int MAX_SALARY = 2000;
    
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= DAY_SKIP_LIMIT ? 0.85 : 1.0;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= PRODUCT_BONUS_LIMIT ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double salary = (BASE_SALARY * salaryMultiplier(daysSkipped)) + bonusForProductsSold(productsSold);
        return salary > MAX_SALARY ? MAX_SALARY : salary;
    } 
}
