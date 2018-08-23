# HotelSpring
a sample hotel back end application with spring and jwt writen in kotlin using gradle.

# Senario      
well threre is guests that they can check In and enter they username and personal data.     
and there is staff of the hotel that they can signup , signin ,check guests in period of time and check out the guests.

Guest
```
{
   "userName":"mww1",
   "firstName":"mohamad",
   "lastName":"khaleghy"
}
```
Staff
```
{
	"userName":"staff1"
	,"password":"123456"
	,"firstName":"mike"
	,"lastName":"anderson"
	,"role":"staff"
}
```

# Controllers      
localhost:8080/checkIn     
Post     
Body: guest json     
response: true or false     

localhost:8080/signUp     
Post     
Body: staff json     
response: true or false     

localhost:8080/signIn     
Post      
Body: staff     
response: String login token     

localhost:8080/rest/guests     
Get    
response: paging response of guests     
headers:      
Authorization     
pageSize     
page     
fromDate     

localhost:8080/rest/checkOut/{guestId}     
Post     
url param Guest Id to check out      

# output file
In output directory you can find runnable jar of project with a shell to test it.     
it has these commands 

```
"springHotel startJar"
"springHotel checkIn"
"springHotel checkOut"
"springHotel signUp"
"springHotel signIn"
"springHotel guests"
```
* startJar for running the jar with nohup      
* checkIn for check In with sample guest info      
* signUp for signUp as sample staff user     
* signIn for signIn as sample staff user and get Athentication token      
* guests for getting list of guests in a period of time     
* checkOut for check out a guest.

