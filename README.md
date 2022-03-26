# Console Driven Parking Management
   - built using JAVA and some built-in libraries 
   - achieved the core functionality of parking management
   - console driven application
   - you can give priority to regular customer by alloting a permanent slot for then so that other people cant take their slots
   - total cost for parking will be calculted when you check out of the park
   - a detailed report can be viewed by the admin 
   
# Sample input/output

```
1.Login
2.Setup Admin
3.Exit
Enter your choice : 2
Enter the UserId : 10
Enter the password : pass
1.Login
2.Setup Admin
3.Exit
Enter your choice : 2
Enter the UserId : 10 pass
Enter the password : pass
1.Login
2.Setup Admin
3.Exit
Enter your choice : 1
Enter the UserId : 10 
Enter the password : pass
login successful!!
Welcome Admin!!
1.Setup Parking
2.Setup Worker
3.Setup Premium customer
4.Availability
5.Report
6.Logout
Enter your choice : 1
Enter the no of floors in the building : 1
Enter the no of cars per floor : 10
Enter the amount for an hour    RS: 10
1.Setup Parking
2.Setup Worker
3.Setup Premium customer
4.Availability
5.Report
6.Logout
Enter your choice : 2
Enter the UserId : 100
Enter the password : pass
1.Setup Parking
2.Setup Worker
3.Setup Premium customer
4.Availability
5.Report
6.Logout
Enter your choice : 5
Park Details : 
	Floors : 1	Slot : 10
	Amount per hour for parking : Rs.10.0

Admin Details : 
	Admin ID : 10
	Password : pass

Worker Details : 
	Worker ID : 100
	Password : pass

No Premium Customer has been set

No data to produce Check-out Report.....Wait for someone to check out

1.Setup Parking
2.Setup Worker
3.Setup Premium customer
4.Availability
5.Report
6.Logout
Enter your choice : 6
1.Login
2.Setup Admin
3.Exit
Enter your choice : 1
Enter the UserId : 100
Enter the password : pass
login successful!!
Welcome Worker!!
1.Make a parking
2.Make a check-out
3.Check Availability
4.Logout
Enter your choice : 1
1.Premium Customer
2.Vehicle Number
3.exit
Enter your choice : 2
Slots available : 
	Floor : 1
		Slot : 1
		Slot : 2
		Slot : 3
		Slot : 4
		Slot : 5
		Slot : 6
		Slot : 7
		Slot : 8
		Slot : 9
		Slot : 10
Enter the Vehicle Number : 1
Slots available : 
	Floor : 1
		Slot : 1
		Slot : 2
		Slot : 3
		Slot : 4
		Slot : 5
		Slot : 6
		Slot : 7
		Slot : 8
		Slot : 9
		Slot : 10
Enter the floor : 10
Enter the slot : 10
Create park for parking first


1.Make a parking
2.Make a check-out
3.Check Availability
4.Logout
Enter your choice : 1
1.Premium Customer
2.Vehicle Number
3.exit
Enter your choice : 2
Slots available : 
	Floor : 1
		Slot : 1
		Slot : 2
		Slot : 3
		Slot : 4
		Slot : 5
		Slot : 6
		Slot : 7
		Slot : 8
		Slot : 9
		Slot : 10
Enter the Vehicle Number : 1
Slots available : 
	Floor : 1
		Slot : 1
		Slot : 2
		Slot : 3
		Slot : 4
		Slot : 5
		Slot : 6
		Slot : 7
		Slot : 8
		Slot : 9
		Slot : 10
Enter the floor : 1
Enter the slot : 10
Vehicle Parked...
Check-in Time : Sat Mar 26 15:50:04 IST 2022
1.Premium Customer
2.Vehicle Number
3.exit
Enter your choice : 2
Slots available : 
	Floor : 1
		Slot : 1
		Slot : 2
		Slot : 3
		Slot : 4
		Slot : 5
		Slot : 6
		Slot : 7
		Slot : 8
		Slot : 9
Enter the Vehicle Number : 2
Slots available : 
	Floor : 1
		Slot : 1
		Slot : 2
		Slot : 3
		Slot : 4
		Slot : 5
		Slot : 6
		Slot : 7
		Slot : 8
		Slot : 9
Enter the floor : 1
Enter the slot : 2
Vehicle Parked...
Check-in Time : Sat Mar 26 15:50:10 IST 2022
1.Premium Customer
2.Vehicle Number
3.exit
Enter your choice : 3
1.Make a parking
2.Make a check-out
3.Check Availability
4.Logout
Enter your choice : 2
1.Premium Customer
2.Vehicle Number
3.Vehicles in Park
4.Exit
Enter your choice : 2
Normal Customer Details : 
	Car ID : 1
		Floor : 1	slot : 10
	Car ID : 2
		Floor : 1	slot : 2
Enter the Vehicle Number : 1
Bill Details : 
	ID : 1
	Floor : 1	Slot : 10
	Check-in Time : Sat Mar 26 15:50:04 IST 2022
	Check-out Time : Sat Mar 26 15:50:21 IST 2022
Total parking time : 0 hrs 0 mins 17 secs 
	Amount : Rs0.04796389
1.Premium Customer
2.Vehicle Number
3.Vehicles in Park
4.Exit
Enter your choice : 2
Normal Customer Details : 
	Car ID : 2
		Floor : 1	slot : 2
Enter the Vehicle Number : 2
Bill Details : 
	ID : 2
	Floor : 1	Slot : 2
	Check-in Time : Sat Mar 26 15:50:10 IST 2022
	Check-out Time : Sat Mar 26 15:50:27 IST 2022
Total parking time : 0 hrs 0 mins 16 secs 
	Amount : Rs0.04683611
1.Premium Customer
2.Vehicle Number
3.Vehicles in Park
4.Exit
Enter your choice : 3
Premium Customer Details : 
	No Premium customer Vehicle in park
Normal Customer Details : 
	No Normal customer Vehicle in park
1.Premium Customer
2.Vehicle Number
3.Vehicles in Park
4.Exit
Enter your choice : 4
1.Make a parking
2.Make a check-out
3.Check Availability
4.Logout
Enter your choice : 3
1.Check number of slot available of parking
2.Check the slots which are available for parking
3.Exit
Enter your choice : 1
Free slots available are 10
1.Check number of slot available of parking
2.Check the slots which are available for parking
3.Exit
Enter your choice : 2
Slots available : 
	Floor : 1
		Slot : 1
		Slot : 2
		Slot : 3
		Slot : 4
		Slot : 5
		Slot : 6
		Slot : 7
		Slot : 8
		Slot : 9
		Slot : 10
1.Check number of slot available of parking
2.Check the slots which are available for parking
3.Exit
Enter your choice : 3
1.Make a parking
2.Make a check-out
3.Check Availability
4.Logout
Enter your choice : 4
1.Login
2.Setup Admin
3.Exit
Enter your choice : 1
Enter the UserId : 10
Enter the password : pass
login successful!!
Welcome Admin!!
1.Setup Parking
2.Setup Worker
3.Setup Premium customer
4.Availability
5.Report
6.Logout
Enter your choice : 6
1.Login
2.Setup Admin
3.Exit
Enter your choice : 1
Enter the UserId : 10
Enter the password : pass
login successful!!
Welcome Admin!!
1.Setup Parking
2.Setup Worker
3.Setup Premium customer
4.Availability
5.Report
6.Logout
Enter your choice : 5
Park Details : 
	Floors : 1	Slot : 10
	Amount per hour for parking : Rs.10.0

Admin Details : 
	Admin ID : 10
	Password : pass

Worker Details : 
	Worker ID : 100
	Password : pass

No Premium Customer has been set

Report:
	Vehicle ID : 1
		Floor : 1	Slot : 10
		Check-in Time : Sat Mar 26 15:50:04 IST 2022
		Check-out Time : Sat Mar 26 15:50:21 IST 2022
		Total parking time : 0 hrs 0 mins 17 secs 
		Amount Paid : Rs.0.04796389
	Vehicle ID : 2
		Floor : 1	Slot : 2
		Check-in Time : Sat Mar 26 15:50:10 IST 2022
		Check-out Time : Sat Mar 26 15:50:27 IST 2022
		Total parking time : 0 hrs 0 mins 16 secs 
		Amount Paid : Rs.0.04683611
				Total Amount Collected : Rs.0.0948
1.Setup Parking
2.Setup Worker
3.Setup Premium customer
4.Availability
5.Report
6.Logout
Enter your choice : 6
1.Login
2.Setup Admin
3.Exit
Enter your choice : 3

Process finished with exit code 0

```
