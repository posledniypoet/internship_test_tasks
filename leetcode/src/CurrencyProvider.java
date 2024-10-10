import java.util.Date;

public interface CurrencyProvider {
    void addRate(Date date, String currency, double rate);
    double getLastKnownRate(Date date, String currency); //returns 0 if there is no last known rate
}
