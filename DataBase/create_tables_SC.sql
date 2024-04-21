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

CREATE TABLE Description (
    Description_ID varchar(10),
    Description_text TEXT,
    constraint Description_ID_PK primary key (Description_ID)
);

CREATE TABLE Facilities (
    Facility_ID varchar(10),
    Facilities TEXT,
    constraint Facility_ID_PK primary key (Facility_ID)
);

create table Campuses(
Uni_name varchar(20),
Campus_name varchar(20) not null, 
Campus_address double, 
Campus_code int,
Campus_image_ID varchar(10) not null,
Campus_rating decimal(2,1),
constraint Campus_code_PK Primary Key (Campus_code),
constraint Campus_image_ID_FK foreign key (Campus_image_ID) references Images(Image_ID),
constraint Campus_rating_FK foreign key (Campus_rating) references Ratings(Rating_ID)
);



