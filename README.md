
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
    
* public static final String gcm_url = "https://gcm-http.googleapis.com/gcm/send";
* public static final String project_number = "43563062079";  //sender_id
* public static final String api_key = "AIzaSyDpF8Xh3x9ujmRF_zzKclX8C8gF4HqvFmo";

### Restful API 

QRCode API
* GET: http://localhost:8080/api/zPay/broadcastMsgByQRCode/{qrCode}
* GET: http://localhost:8080/api/zPay/getVendorInfoByQRCode/{qrCode}
* GET: http://localhost:8080/api/zPay/decryptQRCode/{qrCode}


User API
* GET:    http://localhost:8080/api/users/
* GET:    http://localhost:8080/api/user/{id}
* POST:   http://localhost:8080/api/user/   @RequestBody User user

```
POST JSON
{
    "firstname" : "Tony",
    "lastname" : "Chen",
    "username" : "tchen",
    "password" : "welcome123",
    "gender" : "male",
    "email" : "xxxx@gmail.com",
    "telephone" : "561-901-5698",
    "address" : "san jose",
    "registrationid": "xxxxxx",
    "qrcode": "xxxx"
}
```

* PUT:    http://localhost:8080/api/user/   @RequestBody User user
* DELETE: http://localhost:8080/api/user/   @RequestBody @ID
* DELETE: http://localhost:8080/api/users/


### Under construction - Build - Deploy
* node ./src/main/webapp/bower_components/r.js/dist/r.js -o build.js


### Android QR Scanner
https://www.numetriclabz.com/android-qr-code-scanner-using-zxingscanner-library-tutorial/

### Andoird Login
http://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/