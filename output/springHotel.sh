
startJar () {
    nohup java -jar 'hotel-spring-0.0.1-SNAPSHOT.jar' &
    echo -n ""\n Started ""
}

checkIn () {
    curl -d '{"userName":"mww1","firstName":"mohamad","lastName":"khaleghy"}' -X POST -H "Content-Type: application/json" http://localhost:8080/checkIn
    echo -e "\n {"userName":"mww1","firstName":"mohamad","lastName":"khaleghy"}"
}

signUp () {
    curl -d '{"userName":"staff1","password":"123456","firstName":"mike","lastName":"anderson","role":"staff"}' -X POST -H "Content-Type: application/json" http://localhost:8080/signUp
	echo -e  '\n{"userName":"staff1","password":"123456","firstName":"mike","lastName":"anderson","role":"staff"}'
}

signIn () {
    curl -d '{"userName":"staff1","password":"123456","firstName":"mike","lastName":"anderson","role":"staff"}' -X POST -H "Content-Type: application/json" http://localhost:8080/signIn
    echo -e '\n{"userName":"staff1","password":"123456"}' 
}

guests () {
	echo 'enter start date in timemili'
	read fromDate
	
	echo 'enter end date in timemili'
	read toDate
	
	echo 'enter Authorization token'
	read token
	
	curl  -X GET -H "Content-Type: application/json" -H "pageSize: 10" -H "page: 0" -H "fromDate: $fromDate" -H "toDate: $toDate" -H "Authorization:$token" http://localhost:8080/rest/guests
}


checkOut () {
	echo 'enter Authorization token'
	read token
    
    curl -X POST -H "Authorization:$token" -H "Content-Type: application/x-www-form-urlencoded" http://localhost:8080/rest/checkOut/1
}


if [ "$1" = "startJar" ]
then
    startJar

elif [ "$1" = "checkIn" ]
then
    checkIn

	elif [ "$1" = "checkOut" ]
then
    checkOut

        elif [ "$1" = "signUp" ]
then
    signUp

	elif [ "$1" = "signIn" ]
then
    signIn

	elif [ "$1" = "guests" ]
then
    guests
else
    echo "springHotel startJar"
    echo "springHotel checkIn"
    echo "springHotel checkOut"
    echo "springHotel signUp"
    echo "springHotel signIn"
    echo "springHotel guests"
fi
