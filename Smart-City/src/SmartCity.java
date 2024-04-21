//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    interface Greetings {
        public void greet();
    }
//    composition classes
    class Images{
        private String image;
        
        public Images(String image) {
            this.image = image;
        }
    }
    class Rating {
        private double rating;

        public Rating(double rating) {
            this.rating = rating;
        }
    }
    class Description{
        private String description;

        public Description(String description) {
        this.description = description;
        }
    }
    class Facilities {
        private String facilities;

        public Facilities(String facilities) {
        this.facilities = facilities;
        }
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

    class Campuses extends University {
        protected static String campusName;
        protected static String campusLocation;
        protected static int campusCode;
        protected static Images image;
        public Campuses(String campusName, String campusLocation,int campusCode, Images image) {
            super(University.UniName, University.location, University.description);
            this.campusName = campusName;
            this.campusLocation = campusLocation;
            this.campusCode = campusCode;
            this.image = image;
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
        private Images image;
        public Schools(String schoolName, String schoolID, int schoolContact, Description description, Facilities facilities, Images image) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode, Campuses.image);
            this.schoolName = schoolName;
            this.schoolID = schoolID;
            this.schoolContact = schoolContact;
            this.description = description;
            this.facilities = facilities;
            this.image = image;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + schoolName); // greeting message in GUI
        }
    }

    class KeyLocations extends Campuses{
        private String keyLocationName;
        private String KeyLocationType;
        private Description description;
        private  Facilities facilities;
        private Images image;
        public KeyLocations(String keyLocationName, String KeyLocationType, Description description, Facilities facilities, Images image) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode, Campuses.image);
            this.keyLocationName = keyLocationName;
            this.KeyLocationType = KeyLocationType;
            this.description = description;
            this.facilities = facilities;
            this.image = image;
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
        private Images image;
        public RecreationalSpots(String recreationalSpotName, int spotID, Description description, Facilities facilities, Images image) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode, Campuses.image);
            this.recreationalSpotName = recreationalSpotName;
            this.spotID = spotID;
            this.description = description;
            this.facilities = facilities;
            this.image = image;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + recreationalSpotName); // greeting message in GUI
        }
    }
    class Hostels extends Campuses {
        private String hostelName;
        private int hostelID;
        private Rating hostelRating;
        private String hostelType;
        private Description description;
        private  Facilities facilities;
        Time curfewOpeningTime;
        Time curfewClosingTime;
        private Images image;

        public Hostels(String hostelName, int hostelID, Rating hotelRating, String hostelType, Description description,
                       Facilities facilities, Time curfewOpeningTime, Time curfewClosingTime, Images image) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode, Campuses.image);
            this.hostelName = hostelName;
            this.hostelID = hostelID;
            this.hostelRating = hotelRating;
            this.hostelType = hostelType;
            this.description = description;
            this.facilities = facilities;
            this.curfewOpeningTime = curfewOpeningTime;
            this.curfewClosingTime = curfewClosingTime;
            this.image = image;
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
    class FoodSpots extends Campuses {
        private String foodSpotName;
        private int foodSpotID;
        private Rating restaurantRating;
        private String cuisineType ;
        Time openingTime;
        Time closingTime;
        private Images image;
        public FoodSpots(String foodSpotName, int foodSpotID, Rating restaurantRating, String cuisineType, Time openingTime, Time closingTime, Images image) {
            super(Campuses.campusName, Campuses.campusLocation, Campuses.campusCode, Campuses.image);
            this.foodSpotName = foodSpotName;
            this.foodSpotID = foodSpotID;
            this.restaurantRating = restaurantRating;
            this.cuisineType = cuisineType;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.image = image;
        }
        @Override
        public void greet() {
            System.out.println("Welcome to " + foodSpotName); // greeting message in GUI
        }
    }
    public class SmartCity {
        public static void main(String[] args) {

        }
    }