package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CurrencyRateDtoTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість знаків після коми: \t");
        int countDigits = scanner.nextInt();
        List<CurrencyRateDto> rates = new ArrayList<>();
        rates.add(new CurrencyRateDto("USD", 36.5686, 37.4532));
        rates.add(new CurrencyRateDto("EUR", 38.7426, 40.4858));
        List<CurrencyRateDto> formattedRates = digitsAfterDecimalPoint(rates, countDigits);
        System.out.println("\tОБМІН ВАЛЮТ");
        System.out.println("Курс валют на сьогодні:");
        for (CurrencyRateDto rate : formattedRates) {
            System.out.println(rate.getCurrency() + ": " + " (купівля: " + rate.getSellRate() + ", продаж: " + rate.getBuyRate() + ")");
        }
    }

    public static List<CurrencyRateDto> digitsAfterDecimalPoint(List<CurrencyRateDto> rates, int countDigits) {
        List<CurrencyRateDto> formattedRates = new ArrayList<>();
        for (CurrencyRateDto rate : rates) {
            double roundedSellRate = Math.round(rate.getSellRate() * Math.pow(10, countDigits)) / Math.pow(10, countDigits);
            double roundedBuyRate = Math.round(rate.getBuyRate() * Math.pow(10, countDigits)) / Math.pow(10, countDigits);
            double[] roundedRates = {roundedSellRate, roundedBuyRate};
            formattedRates.add(new CurrencyRateDto(rate.getCurrency(), roundedRates[0], roundedRates[1]));
        }
        return formattedRates;
    }
}
