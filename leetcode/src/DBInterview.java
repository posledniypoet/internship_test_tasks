import java.util.*;

public class DBInterview implements CurrencyProvider {
    Map<String, TreeMap<Date, Double>> currencyRates = new HashMap<>();

    @Override
    public void addRate(Date date, String currency, double rate) {
        if(!currencyRates.containsKey(currency)){
            TreeMap<Date, Double> rates = new TreeMap<>();
            rates.put(date, rate);
            currencyRates.put(currency, rates);
        } else {
            TreeMap<Date, Double> currentRates = currencyRates.get(currency);
            currentRates.put(date, rate);
        }
    }

    @Override
    public double getLastKnownRate(Date date, String currency) {
        if(!currencyRates.containsKey(currency)){
            return 0.0;
        } else {
            TreeMap<Date, Double> currentRates = currencyRates.get(currency);
            for(Map.Entry<Date, Double> entry : currentRates.entrySet()){
                if(!entry.getKey().after(date)){
                    return  entry.getValue();
                }
            }
        }
        return 0.0;
    }
}
