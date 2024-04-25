insert into campuses(Campus_code, Uni_name, Campus_name, Campus_address, Campus_image_ID, Campus_rating_ID)
values("NH-12T","NUST","H-12","NUST H-12, Islamabad","N-1","T-1"),
("NCEME-12T","NUST","CEME","NUST CEME, Rawalpindi","NRw-2","T-2"),
("NMCS-12T","NUST","MCS","NUST MCS, Rawalpindi","NRw-3","T-3"),
("NCAE-12T","NUST","CAE","NUST CAE, Risalpur","NRs-4","T-4"),
("NMCE-12T","NUST","MCE","NUST MCE, Risalpur","NRs-5","T-5"),
("NPNEC-12T","NUST","PNEC","NUST PNEC, Karachi","NK-6","T-6"),
("NNBC-12T","NUST","NBC","NUST NBC, Quetta","NQ-7","T-7");

insert into schools(School_ID, School_Campus_code, School_name, School_contact, School_description_ID, School_facilities_ID, School_image_ID) values
("HSEECS-12","NH-12T","SEECS","05190852400","SEECS-DID1","SEECS-FID1","NS-1"),
("HSMME-12","NH-12T","SMME","05190856010","SMME-DID2","SMME-FID2","NS-2"),
("HSCEE-12","NH-12T","SCEE","0518864501","SCEE-DID3","SCEE-FID3","NS-3"),
("HSCME-12","NH-12T","SCME",NULL,"SCME-DID4","SCME-FID4","NS-4"),
("HUSPC-12","NH-12T","USPCASE","05190855294","USPC-DID5","USPC-FID5","NS-5"),
("HIESE-12","NH-12T","IESE",NULL,"IESE-DID6","IESE-FID6","NS-6"),
("HNICE-12","NH-12T","NICE","05190854517","NICE-DID7","NICE-FID7","NS-7"),
("HIGIS-12","NH-12T","IGIS","05190854401","IGIS-DID8","IGIS-FID8","NS-8"),
("HNBS-12","NH-12T","NBS",NULL,"NBS-DID9","NBS-FID9","NS-9"),
("HSADA-12","NH-12T","SADA",NULL,"SADA-DID10","SADA-FID10","NS-10"),
("HS3H-12","NH-12T","S3H",NULL,"S3H-DID11","S3H-FID11","NS-11"),
("HASAB-12","NH-12T","ASAB",05190851099,"ASAB-DID12","ASAB-FID12","NS-12"),
("HSNS-12","NH-12T","SNS","05190855571","SNS-DID13","SNS-FID13","NS-13"),
("HNSHS-12","NH-12T","NSHS","05190852606","NSHS-DID14","NSHS-FID14","NS-14"),
("HSINES-12","NH-12T","SINES","05190852606","SINE-DID15","SINE-FID15","NS-15"),
("HIAEC-12","NH-12T","IAEC",NULL,"IAEC-DID16","IAEC-FID16","NS-16"),
("HRIMS-12","NH-12T","RIMMS","051908526506","RIMS-DID17","RIMS-FID17","NS-17");

insert into hostels(Hostel_ID,Hostel_Campus_code,Hostel_name,Hostel_rating_ID,Hostel_type,Hostel_description_ID,Hostel_facilities_ID,Hostel_image_ID,Hostel_curfewTiming_ID)
values("GZL-H12","NH-12T","Ghazali Hostel","NH-1","UG-Male","NH-DID1","NH-FID1","NH-IMG1","NH-T1"),
("ZKR-H12","NH-12T","Zakariya Hostel","NH-2","UG-Male","NH-DID2","NH-FID2","NH-IMG2","NH-T2"),
("BRN-H12","NH-12T","Beruni Hostel","NH-3","UG-Male","NH-DID3","NH-FID3","NH-IMG3","NH-T3"),
("LQT-H12","NH-12T","Liaquat Hostel","NH-4","UG-Male","NH-DID4","NH-FID4","NH-IMG4","NH-T4"),
("ATR-H12","NH-12T","Attar Hostel","NH-5","UG-Male","NH-DID5","NH-FID5","NH-IMG5","NH-T5"),
("RHM-H12","NH-12T","Rahmat Hostel","NH-6","UG-Male","NH-DID6","NH-FID6","NH-IMG6","NH-T6"),
("RZI-H12","NH-12T","Razi Hostel","NH-7","UG-Male","NH-DID7","NH-FID7","NH-IMG7","NH-T7"),
("HJR-H12","NH-12T","Hajveri Hostel","NH-8","UG-Male","NH-DID8","NH-FID8","NH-IMG8","NH-T8"),
("RMI-H12","NH-12T","Rumi Hostel","NH-9","PG-Male","NH-DID9","NH-FID9","NH-IMG9","NH-T9"),
("JHR-H12","NH-12T","Johar Hostel","NH-10","PG-Male","NH-DID10","NH-FID10","NH-IMG10","NH-T10"),
("AMR-H12","NH-12T","Ammar Hostel","NH-11","PG-Male","NH-DID11","NH-FID11","NH-IMG11","NH-T11"),
("FTM1-H12","NH-12T","Fatima Hostel-Block1","NH-12","PG-Female","NH-DID12","NH-FID12","NH-IMG12","NH-T12"),
("KDJ-H12","NH-12T","Khadija Hostel","NH-13","UG-Female","NH-DID13","NH-FID13","NH-IMG13","NH-T13"),
("AYS-H12","NH-12T","Ayesha Hostel","NH-14","UG-Female","NH-DID14","NH-FID14","NH-IMG14","NH-T14"),
("AMN-H12","NH-12T","Amna Hostel","NH-15","UG-Female","NH-DID15","NH-FID15","NH-IMG15","NH-T15"),
("ZNB-H12","NH-12T","Zainab Hostel","NH-16","UG-Female","NH-DID16","NH-FID16","NH-IMG16","NH-T16"),
("FTM2-H12","NH-12T","Fatima Hostel-Block2","NH-17","PG-Female","NH-DID17","NH-FID1","NH-IMG17","NH-T17");

insert into recreational_spots(Recreational_Spots_ID,Recreational_Spots_Campus_code,Recreational_Spots_name,Recreational_Spots_description_ID,Recreational_Spots_facilities_ID,Recreational_Spots_image_ID)
values("RS-1","NH-12T","Old GYM","RS-DID1","RS-FID1","RS-IMG1"),
("RS-2","NH-12T","Central GYM","RS-DID2","RS-FID2","RS-IMG2"),
("RS-3","NH-12T","Saddle Club","RS-DID3","RS-FID3","RS-IMG3"),
("RS-4","NH-12T","Swimming Pool","RS-DID4","RS-FID4","RS-IMG4"),
("RS-5","NH-12T","Athletics Ground","RS-DID5","RS-FID5","RS-IMG5"),
("RS-6","NH-12T","Rock Climbing Wall","RS-DID6","RS-FID6","RS-IMG6"),
("RS-7","NH-12T","Basketball Court","RS-DID7","RS-FID7","RS-IMG7"),
("RS-8","NH-12T","Tennis Court","RS-DID8","RS-FID8","RS-IMG8"),
("RS-9","NH-12T","Children Park","RS-DID9","RS-FID9","RS-IMG9"),
("RS-10","NH-12T","Piston Cup Track","RS-DID10","RS-FID10","RS-IMG10"),
("RS-11","NH-12T","NUST Lake","RS-DID11","RS-FID11","RS-IMG11"),
("RS-12","NH-12T","Volleyball Court","RS-DID12","RS-FID12","RS-IMG12"),
("RS-13","NH-12T","NBS Ground","RS-DID13","RS-FID13","RS-IMG13"),
("RS-14","NH-12T","NUST Trail","RS-DID14","RS-FID14","RS-IMG14"),
("RS-15","NH-12T","Machoor Garden","RS-DID15","RS-FID15","RS-IMG15"),
("RS-16","NH-12T","Helipad Ground","RS-DID16","RS-FID16","RS-IMG16"),
("RS-17","NH-12T","C1-Basketball Court","RS-DID17","RS-FID17","RS-IMG17"),
("RS-18","NH-12T","HBL Football Ground","RS-DID18","RS-FID18","RS-IMG18"),
("RS-19","NH-12T","HBL Volleyball Court","RS-DID19","RS-FID19","RS-IMG19"),
("RS-20","NH-12T","HBL Futsal Ground","RS-DID20","RS-FID20","RS-IMG20"),
("RS-21","NH-12T","HBL Cricket Ground","RS-DID21","RS-FID21","RS-IMG21"),
("RS-22","NH-12T","SNS Ground","RS-DID22","RS-FID22","RS-IMG22"),
("RS-23","NH-12T","NICE Ground","RS-DID23","RS-FID23","RS-IMG23");