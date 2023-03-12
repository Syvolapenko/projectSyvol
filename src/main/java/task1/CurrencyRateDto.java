package task1;

public class CurrencyRateDto {
    private String currency;
    private double sellRate;
    private double buyRate;

    public CurrencyRateDto(String currency, double sellRate, double buyRate) {
        this.currency = currency;
        this.sellRate = sellRate;
        this.buyRate = buyRate;
    }

    public String getCurrency() {
        return currency;
    }

    public double getSellRate() {
        return sellRate;
    }

    public double getBuyRate() {
        return buyRate;
    }
}
