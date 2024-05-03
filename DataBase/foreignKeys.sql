-- Foreign Key added with actions in campuses table

ALTER TABLE Campuses
ADD CONSTRAINT Campus_rating_ID_FK FOREIGN KEY (Campus_rating_ID) REFERENCES Ratings(Rating_ID)
ON UPDATE CASCADE
ON DELETE SET NULL;


-- Foreign Keys added with actions in schools table

ALTER TABLE schools
ADD CONSTRAINT School_Campus_code_FK FOREIGN KEY (School_Campus_code) REFERENCES Campuses(Campus_code)
ON UPDATE CASCADE
ON DELETE CASCADE,

ADD CONSTRAINT School_description_ID_FK FOREIGN KEY (School_description_ID) REFERENCES Descriptions(Description_ID)
ON UPDATE CASCADE
ON DELETE SET NULL,

ADD CONSTRAINT School_facilities_ID_FK FOREIGN KEY (School_facilities_ID) REFERENCES Facilities(Facility_ID)
ON UPDATE CASCADE
ON DELETE SET NULL;


-- Foreign Keys added with actions in keyLocations table

ALTER TABLE KeyLocations
ADD CONSTRAINT KeyLocation_Campus_code_FK FOREIGN KEY (KeyLocation_Campus_code) REFERENCES Campuses(Campus_code)
ON UPDATE CASCADE
ON DELETE CASCADE,

ADD CONSTRAINT KeyLocation_description_ID_FK FOREIGN KEY (KeyLocation_description_ID) REFERENCES Descriptions(Description_ID)
ON UPDATE CASCADE
ON DELETE SET NULL,

ADD CONSTRAINT KeyLocation_facilities_ID_FK FOREIGN KEY (KeyLocation_facilities_ID) REFERENCES Facilities(Facility_ID)
ON UPDATE CASCADE
ON DELETE SET NULL;


-- Foreign Keys added with actions in Recreational_Spots table

ALTER TABLE Recreational_Spots
ADD CONSTRAINT Recreational_Spots_Campus_code_FK FOREIGN KEY (Recreational_Spots_Campus_code) REFERENCES Campuses(Campus_code)
ON UPDATE CASCADE
ON DELETE CASCADE,

ADD CONSTRAINT Recreational_Spots_description_ID_FK FOREIGN KEY (Recreational_Spots_description_ID) REFERENCES Descriptions(Description_ID)
ON UPDATE CASCADE
ON DELETE SET NULL,

ADD CONSTRAINT Recreational_Spots_facilities_ID_FK FOREIGN KEY (Recreational_Spots_facilities_ID) REFERENCES Facilities(Facility_ID)
ON UPDATE CASCADE
ON DELETE SET NULL;


-- Foreign Keys added with actions in Hostels table

ALTER TABLE Hostels
ADD CONSTRAINT Hostel_Campus_code_FK FOREIGN KEY (Hostel_Campus_code) REFERENCES Campuses(Campus_code)
ON UPDATE CASCADE
ON DELETE CASCADE,

ADD CONSTRAINT Hostel_description_ID_FK FOREIGN KEY (Hostel_description_ID) REFERENCES Descriptions(Description_ID)
ON UPDATE CASCADE
ON DELETE SET NULL,

ADD CONSTRAINT Hostel_facilities_ID_FK FOREIGN KEY (Hostel_facilities_ID) REFERENCES Facilities(Facility_ID)
ON UPDATE CASCADE
ON DELETE SET NULL,

ADD CONSTRAINT Hostel_rating_ID_FK FOREIGN KEY (Hostel_rating_ID) REFERENCES Ratings(Rating_ID)
ON UPDATE CASCADE
ON DELETE NO ACTION,

ADD CONSTRAINT Hostel_curfewTiming_ID_FK FOREIGN KEY(Hostel_curfewTiming_ID) REFERENCES Times(Time_ID)
ON UPDATE CASCADE
ON DELETE SET NULL;


-- Foreign Keys added with actions in FoodSpots table

ALTER TABLE FoodSpots
ADD CONSTRAINT FoodSpot_Campus_code_FK FOREIGN KEY (FoodSpot_Campus_code) REFERENCES Campuses(Campus_code)
ON UPDATE CASCADE
ON DELETE CASCADE,

ADD CONSTRAINT FoodSpot_description_ID_FK FOREIGN KEY (FoodSpot_description_ID) REFERENCES Descriptions(Description_ID)
ON UPDATE CASCADE
ON DELETE SET NULL,

ADD CONSTRAINT FoodSpot_facilities_ID_FK FOREIGN KEY (FoodSpot_facilities_ID) REFERENCES Facilities(Facility_ID)
ON UPDATE CASCADE
ON DELETE SET NULL,

ADD CONSTRAINT FoodSpot_rating_ID_FK FOREIGN KEY (FoodSpot_rating_ID) REFERENCES Ratings(Rating_ID)
ON UPDATE CASCADE
ON DELETE NO ACTION,

ADD CONSTRAINT FoodSpot_Food_rating_ID_FK FOREIGN KEY (FoodSpot_Food_rating_ID) REFERENCES Ratings(Rating_ID)
ON UPDATE CASCADE
ON DELETE NO ACTION,

ADD CONSTRAINT FoodSpot_Timing_ID_FK FOREIGN KEY (FoodSpot_Timing_ID) REFERENCES Times(Time_ID)
ON UPDATE CASCADE
ON DELETE SET NULL;
