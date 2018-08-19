

startJar() {
    java -jar hotel-spring-0.0.1-SNAPSHOT.jar
    echo -n "Started "
}

checkIn() {
    curl -d '{"userName":"mww1","firstName":"mohamad","lastName":"khaleghy"}' -X POST -H "Content-Type: application/json" http://localhost:8080/checkIn
	echo -n '{"userName":"mww1","firstName":"mohamad","lastName":"khaleghy"}'
}

signUp() {
    curl -d '{"userName":"staff1","password":"123456","firstName":"mike","lastName":"anderson","role":"staff"}' -X POST -H "Content-Type: application/json" http://localhost:8080/signUp
	echo -n '{"userName":"staff1","password":"123456","firstName":"mike","lastName":"anderson","role":"staff"}'
}

signIn() {
    curl -d '{"userName":"staff1","password":"123456","firstName":"mike","lastName":"anderson","role":"staff"}' -X POST -H "Content-Type: application/json" http://localhost:8080/signIn
    echo -n '{"userName":"staff1","password":"123456"}' 
}

guests() {
	echo 'enter start date in timemili'
	read fromDate
	
	echo 'enter end date in timemili'
	read toDate
	
	echo 'enter Authorization token'
	read token
	
	curl  -X GET -H "Content-Type: application/json" -H "pageSize: 10" -H "page: 0" -H "fromDate: $fromDate" -H "toDate: $toDate" -H "Authorization:$token" http://localhost:8080/rest/guests
}


checkOut() {
    curl -X POST -H "Content-Type: application/json" http://localhost:8080/rest/checkOut/1
}








