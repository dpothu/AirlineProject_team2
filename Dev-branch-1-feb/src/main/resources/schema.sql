create table T_REL_Flight_Details
(
    id    	Long NOT NULL AUTO_INCREMENT,
   	Name		varchar(225),
   	filledseats		int,
   	emptyseats		int,
    seatcapacity	int,
    primary key (id)
);