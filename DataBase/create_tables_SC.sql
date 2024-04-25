create database SmartCity;
-- Create Images table with primary key
CREATE TABLE Images (
    Image_ID VARCHAR(10),
    Image_name VARCHAR(255),
    image_link VARCHAR(500),
    CONSTRAINT Image_ID_PK PRIMARY KEY (Image_ID)
);

-- Create Ratings table with primary key
CREATE TABLE Ratings (
    Rating_ID VARCHAR(10),
    Rating DECIMAL(2,1) NOT NULL,
    CONSTRAINT Rating_PK PRIMARY KEY (Rating_ID)
);

-- Create Descriptions table with primary key
CREATE TABLE Descriptions (
    Description_ID VARCHAR(10),
    Description_text TEXT,
    CONSTRAINT Description_ID_PK PRIMARY KEY (Description_ID)
);

-- Create Facilities table with primary key
CREATE TABLE Facilities (
    Facility_ID VARCHAR(10),
    Facilities TEXT,
    CONSTRAINT Facility_ID_PK PRIMARY KEY (Facility_ID)
);

-- Create Times table with primary key
CREATE TABLE Times (
    Time_ID VARCHAR(10),
    Opening_time TIME,
    Closing_time TIME,
    CONSTRAINT Time_ID_PK PRIMARY KEY (Time_ID)
);

-- Create Campuses table with primary key
CREATE TABLE Campuses (
    Campus_code VARCHAR(10),
    Uni_name VARCHAR(20),
    Campus_name VARCHAR(20) NOT NULL,
    Campus_address VARCHAR(1024),
    Campus_image_ID VARCHAR(10) NOT NULL,
    Campus_rating_ID varchar(10),
    CONSTRAINT Campus_code_PK PRIMARY KEY (Campus_code)
);

-- Create Schools table with primary key
CREATE TABLE Schools (
    School_ID VARCHAR(10),
    School_Campus_code VARCHAR(10) NOT NULL,
    School_name VARCHAR(20) NOT NULL,
	School_contact VARCHAR(20),
	School_description_ID VARCHAR(10),
    School_facilities_ID VARCHAR(10),
    School_image_ID VARCHAR(10) NOT NULL,
    CONSTRAINT School_ID_PK PRIMARY KEY (School_ID)
);

-- Create KeyLocations table with primary key
CREATE TABLE KeyLocations (
    KeyLocation_ID VARCHAR(10),
    KeyLocation_Campus_code VARCHAR(10) NOT NULL,
    KeyLocation_name VARCHAR(20) NOT NULL,
    KeyLocation_type VARCHAR(20),
    KeyLocation_description_ID VARCHAR(10),
    KeyLocation_facilities_ID VARCHAR(10),
    KeyLocation_image_ID VARCHAR(10) NOT NULL,
    CONSTRAINT KeyLocation_ID_PK PRIMARY KEY (KeyLocation_ID)
);

-- Create Recreational_Spots table with primary key
CREATE TABLE Recreational_Spots (
    Recreational_Spots_ID VARCHAR(20),
    Recreational_Spots_Campus_code VARCHAR(10) NOT NULL,
    Recreational_Spots_name VARCHAR(20) NOT NULL,
    Recreational_Spots_description_ID VARCHAR(10),
    Recreational_Spots_facilities_ID VARCHAR(10),
    Recreational_Spots_image_ID VARCHAR(10) NOT NULL,
    CONSTRAINT Recreational_Spots_ID_PK PRIMARY KEY (Recreational_Spots_ID)
);

-- Create Hostels table with primary key
CREATE TABLE Hostels (
	Hostel_ID VARCHAR(20),
    Hostel_Campus_code VARCHAR(10) NOT NULL,
    Hostel_name VARCHAR(20) NOT NULL,
    Hostel_rating_ID VARCHAR(10),
    Hostel_type VARCHAR(10),
    Hostel_description_ID VARCHAR(10),
    Hostel_facilities_ID VARCHAR(10),
    Hostel_image_ID VARCHAR(10) NOT NULL,
    Hostel_curfewTiming_ID VARCHAR(10),
    CONSTRAINT Hostel_ID_PK PRIMARY KEY (Hostel_ID)
);

-- Create FoodSpots table with primary key
CREATE TABLE FoodSpots (
    FoodSpot_Campus_code VARCHAR(10) NOT NULL,
    FoodSpot_ID VARCHAR(20),
    FoodSpot_name VARCHAR(20) NOT NULL,
    FoodSpot_rating_ID VARCHAR(10),
    FoodSpot_Food_rating_ID VARCHAR(10),
    FoodSpot_cuisineType VARCHAR(10),
    FoodSpot_description_ID VARCHAR(10),
    FoodSpot_facilities_ID VARCHAR(10),
    FoodSpot_image_ID VARCHAR(10) NOT NULL,
    FoodSpot_Timing_ID VARCHAR(10),
    CONSTRAINT FoodSpot_ID_PK PRIMARY KEY (FoodSpot_ID)
);