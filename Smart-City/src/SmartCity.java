//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    interface Greetings {
        public void greet();
    }
    class City {
    private static String cityName;
    private static int population;
    private static double cityArea;
    private static int cityLandlineCode;

    public City(String cityName, int population, double cityArea, int cityLandlineCode) {
        this.cityName = cityName;
        this.population = population;
        this.cityArea = cityArea;
        this.cityLandlineCode = cityLandlineCode;
    }
    class Culture extends City {
    private String cultureName;
    private String cultureLanguage;
    private String cultureFood;
    private String cultureMashroob;
    private String cultureClothes;

    public Culture(String cultureName, String language, String food, String mashroob, String clothes) {
        super(cityName, population, cityArea, cityLandlineCode);
        this.cultureName = cultureName;
        cultureLanguage = language;
        cultureFood = food;
        cultureMashroob = mashroob;
        cultureClothes = clothes;
    }
    class Location extends City {
        private String locationName;
        private double locationArearea;
        private int postalCode;
        public Location(String name, double area, int postalCode) {
            super(City.cityName, City.population, City.cityArea, City.cityLandlineCode);
            locationName = name;
            locationArearea = area;
            this.postalCode = postalCode;
        }
    }
    class Schools extends Location{
        private String schoolName;
        private String schoolLevel;
        private int schoolContact;
        public Schools(String name, double area, int postalCode, String schoolName, String schoolLevel, int schoolContact) {
            super(name, area, postalCode);
            this.schoolName = schoolName;
            this.schoolLevel = schoolLevel;
            this.schoolContact = schoolContact;
        }
    }
    class Hospitals extends Location{
        private String hospitalName;
        private String hospitalType;
        private int hospitalContact;
        public Hospitals(String name, double area, int postalCode, String hospitalName, String hospitalType, int hospitalContact) {
            super(name, area, postalCode);
            this.hospitalName = hospitalName;
            this.hospitalType = hospitalType;
            this.hospitalContact = hospitalContact;
        }
    }
    class Parks extends Location {
        private String parkName;
        private boolean containsPlayArea;
        public Parks(String name, double area, int postalCode, String parkName, boolean containsPlayArea) {
            super(name, area, postalCode);
            this.parkName = parkName;
            this.containsPlayArea = containsPlayArea;
        }
    }
    class Hotels extends Location {
        private String hotelName;
        private int hotelContact;
        private double hotelRating;
        private String priceRange;
        public Hotels(String name, double area, int postalCode, String hotelName, int hotelContact, double hotelRating, String priceRange) {
            super(name, area, postalCode);
            this.hotelName = hotelName;
            this.hotelContact = hotelContact;
            this.hotelRating = hotelRating;
            this.priceRange = priceRange;
        }
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
        public Restaurants(String name, double area, int postalCode, String restaurantName, double restaurantRating, String foodType) {
            super(name, area, postalCode);
            this.restaurantName = restaurantName;
            this.restaurantRating = restaurantRating;
            this.foodType = foodType;
        }
    }
    class touristPlaces extends Location {
        private String placeName;
        private String entryFee;
        Time openingTime;
        Time closingTime;
        public touristPlaces(String name, double area, int postalCode, String placeName, String entryFee) {
            super(name, area, postalCode);
            this.placeName = placeName;
            this.entryFee = entryFee;
        }
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
        public historicalPlaces(String name, double area, int postalCode, String placeName, String entryFee, String historicalPlaceName) {
            super(name, area, postalCode, placeName, entryFee);
            this.historicalPlaceName = historicalPlaceName;
        }
    }
    public class SmartCity {
        public static void main(String[] args) {

        }
    }