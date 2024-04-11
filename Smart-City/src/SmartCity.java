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
    class Time {
        private String openingTime;
        private String closingTime;
    }
    class Restaurants extends Location {
        private String restaurantName;
        private double restaurantRating;
        private String foodType;
        Time openingTime;
        Time closingTime;
    }
    class touristPlaces extends Location {
        private String placeName;
        private String entryFee;
        Time openingTime;
        Time closingTime;
    }
    class History {
        private String historicalPlaceManufacturer;
        private String historicalTimePeriod;
        private String historicalTimeDuration;
    }
    class historicalPlaces extends touristPlaces {
        private String historicalPlaceName;
        History historicalPlaceManufacturer;
        History historicalTimePeriod;
        History historicalTimeDuration;
    }
    public class SmartCity {
        public static void main(String[] args) {

        }
    }