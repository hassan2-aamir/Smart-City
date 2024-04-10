//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    class City {
    private String cityName;
    private int population;
    private double cityArea;
    private int cityLandlineCode;
    }
    class Culture extends City {
    private String cultureName;
    private String language;
    private String food;
    private String mashroob;
    private String clothes;
    }
    class Location extends City {
        private String name;
        private double area;
        private int postalCode;
    }
    class Schools extends Location{
        private String schoolName;
        private String schoolLevel;
        private int schoolContact;
    }
    class Hospitals extends Location{
        private String hospitalName;
        private String hospitalType;
        private int hospitalContact;
    }
    class Parks extends Location {
        private String parkName;
        private boolean containsPlayArea;
    }
    class Hotels extends Location {
        private String hotelName;
        private int hotelContact;
        private double hotelRating;
        private String priceRange;
    }
    class Restaurants extends Location {
        private String restaurantName;
        private double restaurantRating;
        private String foodType;
        private String openingTime;
        private String closingTime;
    }


    public class SmartCity {
        public static void main(String[] args) {

        }
    }