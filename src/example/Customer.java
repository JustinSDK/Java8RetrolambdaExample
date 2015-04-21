package example;

import java.util.*;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }
  
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Vector<Rental> rentals = _rentals;
        return "Rental Record for " + getName() + "\n" 
               + rentals.stream()
                       .map(each -> "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n")
                       .reduce((result, desc) -> result + desc)
               + "Amount owed is " + String.valueOf(getTotalCharge()) + "\n"
               + "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
    }

    private double getTotalCharge() {
        Vector<Rental> rentals = _rentals;
        return rentals.stream()
              .mapToDouble(Rental::getCharge)
              .sum();
    }
    
    private int getTotalFrequentRenterPoints() {
        Vector<Rental> rentals = _rentals;
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }
}
