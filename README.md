
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

GET: http://localhost:8080/api/zPay/getVendorInfoByQRCode/{qrCode}

##Under construction - Build - Deploy
node ./src/main/webapp/bower_components/r.js/dist/r.js -o build.js
