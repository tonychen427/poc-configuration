<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>8x8 Inc.</title>
          <link rel="stylesheet" type="text/css" href="app/${application}/styles/application.css">
          <link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.css">
    </head>
    <body>        
        
<!--        <div id="nav"></div>
        <div id="app"></div>-->

        <div id="nav" ></div>
        <div id="app" class="view" data-ng-view>
             <div class="loading-indicator"></div>
        </div>
        
        
        <script src="../../bower_components/requirejs/require.js" data-main="../app/${application}/js/main"></script>

    </body>
</html>