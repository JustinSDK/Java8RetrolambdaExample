package example;

import java.util.*;

public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }
  
    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        return "Rental Record for " + getName() + "\n" 
               + _rentals.stream()
                       .map(each -> "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n")
                       .reduce((result, desc) -> result + desc)
               + "Amount owed is " + String.valueOf(getTotalCharge()) + "\n"
               + "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
    }

    private double getTotalCharge() {
        return _rentals.stream()
              .mapToDouble(Rental::getCharge)
              .sum();
    }
    
    private int getTotalFrequentRenterPoints() {
        return _rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }
}
