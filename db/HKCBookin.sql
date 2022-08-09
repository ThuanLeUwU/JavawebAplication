use HKCBooking

CREATE TABLE user_booking 
(
	
	username nvarchar(50) NOT NULL PRIMARY KEY,
	password nvarchar(50) NOT NULL,
	lastname nvarchar(50) NOT NULL,
	isAdmin bit
)

INSERT INTO user_booking VALUES( 'sa', '123456', 'Mixi', 1)
INSERT INTO user_booking VALUES( 'se', '123456', 'Cris', 0)
INSERT INTO user_booking VALUES( 'ss', '123456', 'Rambo', 0)
INSERT INTO user_booking VALUES( 'tin', '2001', 'Tin', 0)
INSERT INTO user_booking VALUES( 'vip', '2210', 'Volca', 0)

select * from user_booking

Drop Table user_booking

SELECT Username FROM SINHVIEN where username = 'se' and password = '123456'

Select username, password, lastname, isAdmin
From user_booking
where lastname Like 'M'

"Delete from user_bookingWhere username = ?"

CREATE TABLE product
(	
	 productID int not null primary key,
     productName nvarchar(50) not null,
     quantity int,
	 username nvarchar(50)  	 
)
drop table product