
#zPay API Console

## Install / Run

mvn clean 

mvn install

mvn jetty:run


update maven to v3.3.9
 
$ brew update

$ brew unlink maven

$ brew install maven


http://localhost:8080/demo1
http://localhost:8080/demo2


#API Console
http://localhost:8080/zpay/


#Restful API 

QRCode API
GET: http://localhost:8080/api/zPay/getVendorInfoByQRCode/{qrCode}
GET: http://localhost:8080/api/zPay/decryptQRCode/{qrCode}

User API
GET:    http://localhost:8080/api/users/
GET:    http://localhost:8080/api/user/{id}
POST:   http://localhost:8080/api/user/   @RequestBody User user
PUT:    http://localhost:8080/api/user/   @RequestBody User user
DELETE: http://localhost:8080/api/user/   @RequestBody @ID
DELETE: http://localhost:8080/api/users/


##Under construction - Build - Deploy
node ./src/main/webapp/bower_components/r.js/dist/r.js -o build.js
