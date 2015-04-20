package example;
public class Rental {
     private Movie _movie;
     private int _daysRented;

     public Rental(Movie movie, int daysRented) {
       _movie = movie;
       _daysRented = daysRented;
     }
     public int getDaysRented() {
       return _daysRented;
     }
     public Movie getMovie() {
       return _movie;
     } 

    public double getCharge() {
        double amount = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (this.getDaysRented() > 2) {
                    amount += (this.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (this.getDaysRented() > 3) {
                    amount += (this.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return amount;
    }
 }
