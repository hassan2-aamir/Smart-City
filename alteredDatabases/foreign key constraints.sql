-- Add foreign key constraint to Schools table referencing Campuses table
ALTER TABLE Schools
ADD CONSTRAINT Schools_Campus_FK
FOREIGN KEY (Schools_Campus_code)
REFERENCES Campuses(Campus_code);

-- Add foreign key constraint to KeyLocations table referencing Campuses table
ALTER TABLE KeyLocations
ADD CONSTRAINT KeyLocations_Campus_FK
FOREIGN KEY (KeyLocation_Campus_code)
REFERENCES Campuses(Campus_code);

-- Add foreign key constraint to Recreational_Spots table referencing Campuses table
ALTER TABLE Recreational_Spots
ADD CONSTRAINT Recreational_Spots_Campus_FK
FOREIGN KEY (Recreational_Spots_Campus_code)
REFERENCES Campuses(Campus_code);

-- Add foreign key constraint to Hostels table referencing Campuses table
ALTER TABLE Hostels
ADD CONSTRAINT Hostels_Campus_FK
FOREIGN KEY (Hostel_Campus_code)
REFERENCES Campuses(Campus_code);

-- Add foreign key constraint to FoodSpots table referencing Campuses table
ALTER TABLE FoodSpots
ADD CONSTRAINT FoodSpots_Campus_FK
FOREIGN KEY (FoodSpot_Campus_code)
REFERENCES Campuses(Campus_code);
