create table Images(
    Image_ID varchar(10),
    Image_name VARCHAR(255),
    image_data LONGBLOB NOT NULL,
    image_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    constraint Image_ID_PK Primary key (Image_ID)
    );
    
CREATE TABLE Ratings (
    Rating_ID INT AUTO_INCREMENT,
    Rating DECIMAL(2,1) NOT NULL,
    constraint Rating_PK primary key (Rating_ID)
);

CREATE TABLE Descriptions (
    Description_ID varchar(10),
    Description_text TEXT,
    constraint Description_ID_PK primary key (Description_ID)
);

CREATE TABLE Facilities (
    Facility_ID varchar(10),
    Facilities TEXT,
    constraint Facility_ID_PK primary key (Facility_ID)
);

CREATE TABLE Times (
    Time_ID int AUTO_INCREMENT,
    Opening_time time,
    Closing_time time,
    constraint Time_ID_PK primary key (Time_ID)
);

create table Campuses(
Uni_name varchar(20),
Campus_name varchar(20) not null, 
Campus_address double, 
Campus_code int,
Campus_image_ID varchar(10) not null,
Campus_rating_ID int,
constraint Campus_code_PK Primary Key (Campus_code),
constraint Campus_image_ID_FK foreign key (Campus_image_ID) references Images(Image_ID),
constraint Campus_rating_ID_FK foreign key (Campus_rating_ID) references Ratings(Rating_ID)
);
 
 create table Schools(
 Schools_Campus_code int not null,
 School_ID int,
 School_name varchar(20) not null,
 School_contact int,
 School_description_ID varchar(10),
 School_facilities_ID varchar (10),
 School_image_ID varchar(10) not null,
 constraint School_ID_PK Primary Key (School_ID),
 constraint Schools_Campus_code_FK foreign key (Schools_Campus_code) references Campuses(Campus_code),
 constraint School_image_ID_FK foreign key (School_image_ID) references Images(Image_ID),
 constraint School_description_ID_FK foreign key (School_description_ID) references Descriptions(Description_ID),
 constraint School_facilities_ID_FK foreign key (School_facilities_ID) references Facilities(Facility_ID)
);

create table KeyLocations(
 KeyLocation_Campus_code int not null,
 KeyLocation_ID int,
 KeyLocation_name varchar(20) not null,
 KeyLocation_type varchar(20),
 KeyLocation_description_ID varchar(10),
 KeyLocation_facilities_ID varchar (10),
 KeyLocation_image_ID varchar(10) not null,
 constraint KeyLocation_ID_PK Primary Key (KeyLocation_ID),
 constraint KeyLocation_Campus_code_FK foreign key (KeyLocation_Campus_code) references Campuses(Campus_code),
 constraint KeyLocation_image_ID_FK foreign key (KeyLocation_image_ID) references Images(Image_ID),
 constraint KeyLocation_description_ID_FK foreign key (KeyLocation_description_ID) references Descriptions(Description_ID),
 constraint KeyLocation_facilities_ID_FK foreign key (KeyLocation_facilities_ID) references Facilities(Facility_ID)
);

create table Recreational_Spots(
 Recreational_Spots_Campus_code int not null,
 Recreational_Spots_ID varchar(20),
 Recreational_Spots_name varchar(20) not null,
 Recreational_Spots_description_ID varchar(10),
 Recreational_Spots_facilities_ID varchar (10),
 Recreational_Spots_image_ID varchar(10) not null,
 constraint Recreational_Spots_ID_PK Primary Key (Recreational_Spots_ID),
 constraint Recreational_Spots_Campus_code_FK foreign key (Recreational_Spots_Campus_code) references Campuses(Campus_code),
 constraint Recreational_Spots_image_ID_FK foreign key (Recreational_Spots_image_ID) references Images(Image_ID),
 constraint Recreational_Spots_description_ID_FK foreign key (Recreational_Spots_description_ID) references Descriptions(Description_ID),
 constraint Recreational_Spots_facilities_ID_FK foreign key (Recreational_Spots_facilities_ID) references Facilities(Facility_ID)
);

create table Hostels(
 Hostel_Campus_code int not null,
 Hostel_ID varchar(20),
 Hostel_name varchar(20) not null,
 Hostel_rating_ID int,
 Hostel_type varchar(10),
 Hostel_description_ID varchar(10),
 Hostel_facilities_ID varchar (10),
 Hostel_image_ID varchar(10) not null,
 Hostel_curfewTiming_ID int,
 constraint Hostel_ID_PK Primary Key (Hostel_ID),
 constraint Hostel_Campus_code_FK foreign key (Hostel_Campus_code) references Campuses(Campus_code),
 constraint Hostel_image_ID_FK foreign key (Hostel_image_ID) references Images(Image_ID),
 constraint Hostel_description_ID_FK foreign key (Hostel_description_ID) references Descriptions(Description_ID),
 constraint Hostel_facilities_ID_FK foreign key (Hostel_facilities_ID) references Facilities(Facility_ID),
 constraint Hostel_rating_ID_FK foreign key (Hostel_rating_ID) references Ratings(Rating_ID),
 constraint Hostel_curfewTiming_ID_FK foreign key(Hostel_curfewTiming_ID) references Times(Time_ID)
);

create table FoodSpots(
 FoodSpot_Campus_code int not null,
 FoodSpot_ID varchar(20),
 FoodSpot_name varchar(20) not null,
 FoodSpot_rating_ID int,
 FoodSpot_Food_rating_ID int,
 FoodSpot_cuisineType varchar(10),
 FoodSpot_description_ID varchar(10),
 FoodSpot_facilities_ID varchar (10),
 FoodSpot_image_ID varchar(10) not null,
 FoodSpot_Timing_ID int,
 constraint FoodSpot_ID_PK Primary Key (FoodSpot_ID),
 constraint FoodSpot_Campus_code_FK foreign key (FoodSpot_Campus_code) references Campuses(Campus_code),
 constraint FoodSpot_image_ID_FK foreign key (FoodSpot_image_ID) references Images(Image_ID),
 constraint FoodSpot_description_ID_FK foreign key (FoodSpot_description_ID) references Descriptions(Description_ID),
 constraint FoodSpot_facilities_ID_FK foreign key (FoodSpot_facilities_ID) references Facilities(Facility_ID),
 constraint FoodSpot_rating_ID_FK foreign key (FoodSpot_rating_ID) references Ratings(Rating_ID),
  constraint FoodSpot_Food_rating_ID_FK foreign key(FoodSpot_Food_rating_ID) references Ratings(Rating_ID),
 constraint FoodSpot_Timing_ID_FK foreign key(FoodSpot_Timing_ID) references Times(Time_ID)
);