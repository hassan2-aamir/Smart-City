//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    interface Greetings {
        public void greet();
    }
    class City {
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
    }
    class Culture extends City {
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
    }
    class Parks extends Location {
        private String parkName;
        private boolean containsPlayArea;
        public Parks(String parkName, boolean containsPlayArea) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.parkName = parkName;
            this.containsPlayArea = containsPlayArea;
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
    }
    class touristPlaces extends Location {
        protected static String touristPlaceName;
        protected static String entryFee;
        static Time openingTime;
        static Time closingTime;
        public touristPlaces(String touristPlaceName, String entryFee, Time openingTime, Time closingTime) {
            super(Location.locationName, Location.locationArea, Location.postalCode);
            this.touristPlaceName = touristPlaceName;
            this.entryFee = entryFee;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
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
       public historicalPlaces(History historicalPlaceManufacturer, History historicalTimePeriod, History historicalTimeDuration) {
            super(touristPlaces.touristPlaceName, touristPlaces.entryFee, touristPlaces.openingTime, touristPlaces.closingTime);
            this.historicalPlaceName = touristPlaces.touristPlaceName;
            this.historicalPlaceManufacturer = historicalPlaceManufacturer;
            this.historicalTimePeriod = historicalTimePeriod;
            this.historicalTimeDuration = historicalTimeDuration;
        }
    }
    public class SmartCity {
        public static void main(String[] args) {

        }
    }