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
        private String schoolID;
        private int schoolContact;
        private Description description;
        private  Facilities facilities;
        public Schools(String schoolName, String schoolID, int schoolContact, Description description, Facilities facilities) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode);
            this.schoolName = schoolName;
            this.schoolID = schoolID;
            this.schoolContact = schoolContact;
            this.description = description;
            this.facilities = facilities;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + schoolName); // greeting message in GUI
        }
    }
    class Facilities{
        private String facilities;
        public Facilities(String facilities) {
            this.facilities = facilities;
        }
    }
    class KeyLocations extends Campuses{
        private String keyLocationName;
        private String KeyLocationType;
        private Description description;
        private  Facilities facilities;
        public KeyLocations(String keyLocationName, String KeyLocationType, Description description, Facilities facilities) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode);
            this.keyLocationName = keyLocationName;
            this.KeyLocationType = KeyLocationType;
            this.description = description;
            this.facilities = facilities;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + keyLocationName); // greeting message in GUI
        }
    }
    class RecreationalSpots  extends Campuses {
        private String recreationalSpotName;
        private int spotID;
        private Description description;
        private  Facilities facilities;
        public RecreationalSpots(String recreationalSpotName, int spotID, Description description, Facilities facilities) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode);
            this.recreationalSpotName = recreationalSpotName;
            this.spotID = spotID;
            this.description = description;
            this.facilities = facilities;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + recreationalSpotName); // greeting message in GUI
        }
    }
    class Hostels extends Campuses {
        private String hostelName;
        private int hostelID;
        private double hotelRating;
        private String hostelType;
        private Description description;
        private  Facilities facilities;

        public Hostels(String hostelName, int hostelID, double hotelRating, String hostelType, Description description, Facilities facilities) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode);
            this.hostelName = hostelName;
            this.hostelID = hostelID;
            this.hotelRating = hotelRating;
            this.hostelType = hostelType;
            this.description = description;
            this.facilities = facilities;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + hostelName); // greeting message in GUI
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