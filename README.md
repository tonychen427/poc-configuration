
#zPay API Console

<img src="http://maggie.clientsbox.com/img/zpay.png">

### Install / Run

* mvn clean
* mvn install
* mvn jetty:run


update maven to v3.3.9
 
* $ brew update
* $ brew unlink maven
* $ brew install maven


### UI Demo Framework (AngularJS / ReactJS)
* http://localhost:8080/demo1
* http://localhost:8080/demo2


### API Console
* http://localhost:8080/zpay/


### Additional Info 
    
    public static final String gcm_url = "https://gcm-http.googleapis.com/gcm/send";
    public static final String project_number = "615249975727";  //sender_id
    public static final String api_key = "AIzaSyAF4kKR_g9skGhyTJ-P2JQ4B3viDnV5ddc";

### Restful API 

QRCode API
* GET: http://localhost:8080/api/zPay/getVendorInfoByQRCode/{qrCode}
* GET: http://localhost:8080/api/zPay/decryptQRCode/{qrCode}


User API
* GET:    http://localhost:8080/api/users/
* GET:    http://localhost:8080/api/user/{id}
* POST:   http://localhost:8080/api/user/   @RequestBody User user

'''sh
   {
	"firstname" : "Tony",
	"lastname" : "Chen",
	"username" : "tchen",
	"password" : "welcome123",
	"gender" : "male",
	"email" : "tchen427@gmail.com",
	"telephone" : "561-901-5698",
	"address" : "san jose",
	"registrationid": "djO6PMXp0rY:APA91bH3SUSaq68U9ne1LAWxTEcRYmIlHdiiumpHTSJNJxlNoNmleorWk8xhwN1BDYtZUqIjqxHdLvHnVy9R6K9755nXKV9vzbWLVCRIn0mSPhRqFJs70Rde0JDgESk-K6thH4qLfNJw",
        "qrcode": "MQ=="
    }
'''sh

* PUT:    http://localhost:8080/api/user/   @RequestBody User user
* DELETE: http://localhost:8080/api/user/   @RequestBody @ID
* DELETE: http://localhost:8080/api/users/


### Under construction - Build - Deploy
* node ./src/main/webapp/bower_components/r.js/dist/r.js -o build.js
