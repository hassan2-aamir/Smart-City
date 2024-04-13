//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    interface Greetings {
        public void greet();
    }
    class City implements Greetings{
        protected static String cityName;
        protected static int population;
        protected static double cityArea;
        protected static int cityLandlineCode;

        public City(String cityName, int population, double cityArea, int cityLandlineCode) {
            this.cityName = cityName;
            this.population = population;
            this.cityArea = cityArea;
            this.cityLandlineCode = cityLandlineCode;
        }
        public void greet() {
            System.out.println("Welcome to " + cityName); // greeting message in GUI
        }
    }
    class Culture extends City{
        private String cultureName;
        private String cultureLanguage;
        private String cultureFood;
        private String cultureMashroob;
        private String cultureClothes;

        public Culture(String cultureName, String language, String food, String mashroob, String clothes) {
            super(City.cityName, population, cityArea, cityLandlineCode);
            this.cultureName = cultureName;
            cultureLanguage = language;
            cultureFood = food;
            cultureMashroob = mashroob;
            cultureClothes = clothes;
        }

        @Override
        public void greet() {
            System.out.println("Welcome to " + cultureName); // greeting message in GUI
        }
    }
    class Location extends City {
        protected static String locationName;
        protected static double locationArea;
        protected static int postalCode;
        public Location(String name, double area, int postalCode) {
            super(City.cityName, City.population, City.cityArea, City.cityLandlineCode);
            locationName = name;
            locationArea = area;
            this.postalCode = postalCode;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + locationName); // greeting message in GUI
        }
    }
    class Schools extends Location{
        private String schoolName;
        private String schoolLevel;
        private int schoolContact;
        public Schools(String schoolName, String schoolLevel, int schoolContact) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.schoolName = schoolName;
            this.schoolLevel = schoolLevel;
            this.schoolContact = schoolContact;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + schoolName); // greeting message in GUI
        }
    }
    class Hospitals extends Location{
        private String hospitalName;
        private String hospitalType;
        private int hospitalContact;
        public Hospitals(String name, double area, int postalCode, String hospitalName, String hospitalType, int hospitalContact) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.hospitalName = hospitalName;
            this.hospitalType = hospitalType;
            this.hospitalContact = hospitalContact;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + hospitalName); // greeting message in GUI
        }
    }
    class Parks extends Location {
        private String parkName;
        private boolean containsPlayArea;
        public Parks(String parkName, boolean containsPlayArea) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.parkName = parkName;
            this.containsPlayArea = containsPlayArea;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + parkName); // greeting message in GUI
        }
    }
    class Hotels extends Location {
        private String hotelName;
        private int hotelContact;
        private double hotelRating;
        private String priceRange;
        public Hotels(String hotelName, int hotelContact, double hotelRating, String priceRange) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.hotelName = hotelName;
            this.hotelContact = hotelContact;
            this.hotelRating = hotelRating;
            this.priceRange = priceRange;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + hotelName); // greeting message in GUI
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
        public Restaurants(String restaurantName, double restaurantRating, String foodType, Time openingTime, Time closingTime) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.restaurantName = restaurantName;
            this.restaurantRating = restaurantRating;
            this.foodType = foodType;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + restaurantName); // greeting message in GUI
        }
    }
    class touristPlace extends Location {
        protected static String touristPlaceName;
        protected static String entryFee;
        static Time openingTime;
        static Time closingTime;
        public touristPlace(String touristPlaceName, String entryFee, Time openingTime, Time closingTime) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.touristPlaceName = touristPlaceName;
            this.entryFee = entryFee;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + touristPlaceName); // greeting message in GUI
        }
    }
    class History {
        private String historicalPlaceManufacturer;
        private String historicalTimePeriod;
        private String historicalTimeDuration;
    }
    class historicalPlaces extends touristPlace {
        private String historicalPlaceName;
        History historicalPlaceManufacturer;
        History historicalTimePeriod;
        History historicalTimeDuration;
       public historicalPlaces(History historicalPlaceManufacturer, History historicalTimePeriod, History historicalTimeDuration) {
            super(touristPlace.touristPlaceName, touristPlace.entryFee, touristPlace.openingTime, touristPlace.closingTime);
            this.historicalPlaceName = touristPlace.touristPlaceName;
            this.historicalPlaceManufacturer = historicalPlaceManufacturer;
            this.historicalTimePeriod = historicalTimePeriod;
            this.historicalTimeDuration = historicalTimeDuration;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + historicalPlaceName); // greeting message in GUI
        }
    }
    public class SmartCity {
        public static void main(String[] args) {

        }
    }