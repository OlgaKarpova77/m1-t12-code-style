import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amountDeposit, double yearRate, int depositTerm) {
        double finalAmount = amountDeposit * Math.pow((1 + yearRate / 12), 12 * depositTerm);
        return roundResult(finalAmount, 2);
  }
    double calculateSimplePercent(double amountDeposit, double yearRate, int depositTerm) {
        return roundResult(amountDeposit + amountDeposit * yearRate * depositTerm, 2);
    }
    double roundResult(double number, int position) {
        double format = Math.pow(10, position);
        return Math.round(number * format) / format;
  }
    void resultDeposit() {
        int termDeposit;
        int typeDeposit;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt();

            System.out.println("Введите срок вклада в годах:");

        termDeposit = scanner.nextInt();

            System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом," +
                    " 2 - вклад с капитализацией:");
            typeDeposit = scanner.nextInt();
        double incomeOnDeposit = 0;

            if (typeDeposit == 1) {
                incomeOnDeposit = calculateSimplePercent(amount, 0.06, termDeposit);
            } else if (typeDeposit == 2) {
                incomeOnDeposit = calculateComplexPercent(amount, 0.06, termDeposit);
            }
                System.out.println("Результат вклада: " + amount + " за " + termDeposit
                        + " лет превратятся в " + incomeOnDeposit);
    }
    public static void main(String[] args) {
        new DepositCalculator().resultDeposit();
      }

  }
