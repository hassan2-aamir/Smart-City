//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    interface Greetings {
        public void greet();
    }
    class University implements Greetings{
        protected static String UniName;
        protected static String location; // location(country) of the university
        protected static Description description;

        public University(String UniName, String location, Description description) {
            this.UniName = UniName;
            this.location = location;
            this.description = description;
        }
        public void greet() {
            System.out.println("Welcome to " + UniName); // greeting message in GUI
        }
    }
    class Description{
        private String description;

        public Description(String description) {
            this.description = description;
        }
    }
    class Campuses extends University {
        protected static String campusName;
        protected static String campusLocation;
        protected static int campusCode;
        public Campuses(String campusName, String campusLocation,int campusCode) {
            super(University.UniName, University.location, University.description);
            this.campusName = campusName;
            this.campusLocation = campusLocation;
            this.campusCode = campusCode;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + campusName); // greeting message in GUI
        }
    }
    class Schools extends Campuses{
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