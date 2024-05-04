
CREATE TABLE Campuses (
    Campus_code VARCHAR(10),
    Uni_name VARCHAR(20),
    Campus_name VARCHAR(20) NOT NULL,
    Campus_address VARCHAR(1024),
    Image_path VARCHAR(500), 
    Rating DECIMAL(2,1),
    CONSTRAINT Campus_code_PK PRIMARY KEY (Campus_code)
);


CREATE TABLE Schools (
    School_ID VARCHAR(10),
    Schools_Campus_code VARCHAR(10) NOT NULL,
    School_name VARCHAR(20) NOT NULL,
    School_contact VARCHAR(14),
    Description TEXT, -- Added description column directly
    Facilities TEXT, -- Added facilities column directly
    Image_path VARCHAR(500) NOT NULL, -- Changed to store image path directly
    CONSTRAINT School_ID_PK PRIMARY KEY (School_ID)
);


CREATE TABLE KeyLocations (
    KeyLocation_ID VARCHAR(10),
    KeyLocation_Campus_code VARCHAR(10) NOT NULL,
    KeyLocation_name VARCHAR(20) NOT NULL,
    KeyLocation_type VARCHAR(20),
    Description TEXT, 
    Facilities TEXT,
    Image_path VARCHAR(500) NOT NULL, 
    Rating DECIMAL(2,1), 
    
    CONSTRAINT KeyLocation_ID_PK PRIMARY KEY (KeyLocation_ID)
);


CREATE TABLE Recreational_Spots (
    Recreational_Spots_ID VARCHAR(20),
    Recreational_Spots_Campus_code VARCHAR(10) NOT NULL,
    Recreational_Spots_name VARCHAR(20) NOT NULL,
    Description TEXT, 
    Facilities TEXT, 
    Image_path VARCHAR(500) NOT NULL, 
    Rating DECIMAL(2,1), 
    CONSTRAINT Recreational_Spots_ID_PK PRIMARY KEY (Recreational_Spots_ID)
);


CREATE TABLE Hostels (
	Hostel_ID VARCHAR(20),
    Hostel_Campus_code VARCHAR(10) NOT NULL,
    Hostel_name VARCHAR(20) NOT NULL,
    Hostel_type VARCHAR(10),
    Description TEXT, 
    Facilities TEXT, 
    Image_path VARCHAR(500) NOT NULL, 
    Rating DECIMAL(2,1), 
    Opening_time VARCHAR(10),
    closing_time VARCHAR(10),
    CONSTRAINT Hostel_ID_PK PRIMARY KEY (Hostel_ID)
);


CREATE TABLE FoodSpots (
    FoodSpot_ID VARCHAR(20),
    FoodSpot_Campus_code VARCHAR(10) NOT NULL,
    FoodSpot_name VARCHAR(20) NOT NULL,
    CuisineType VARCHAR(10),
    Description TEXT, 
    Facilities TEXT, 
    Image_path VARCHAR(500) NOT NULL, 
    Rating DECIMAL(2,1), 
    CONSTRAINT FoodSpot_ID_PK PRIMARY KEY (FoodSpot_ID)
);
