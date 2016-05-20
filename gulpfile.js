var fs = require('fs');
var path = require('path');
var gulp = require("gulp");
var clean = require('gulp-clean');
var requirejs = require('requirejs');
var rjs = require('gulp-r');
var amdOptimize = require("amd-optimize");
var concat = require('gulp-concat');

var requirejsOptimize = require('gulp-requirejs-optimize');

var xpath = {
    webappSource: 'src/main/webapp/app/',
    distribution: 'src/main/webapp/dist/'
};

function getFolders(dir) {
    return fs.readdirSync(dir)
            .filter(function (file) {
                return fs.statSync(path.join(dir, file)).isDirectory();
            });
}

gulp.task('clean', function () {
    return gulp.src(xpath.distribution + "**/**", {read: false})
            .pipe(clean({force: true}));

});

gulp.task('scripts', function () {
    setTimeout(function () {
        var folders = getFolders(xpath.webappSource);
        folders.forEach(function (folder) {
            console.log(folder);
            gulp.src(xpath.webappSource + folder + '/js/*.js')
                    .pipe(amdOptimize('main', {
                       
                        configFile: 'src/main/webapp/app/' + folder +'/js/base-config.js'


                    }))
                    .pipe(concat('main-bundle.js'))
                    .pipe(gulp.dest(xpath.distribution + "app/" + folder));
//            gulp.src(xpath.webappSource + folder + '/*.js')
//            .pipe(gulp.dest(xpath.distribution + "app/" + folder));

        });

    }, 1000);
});
//gulp.task('requirejsOptimize', function () {
//    
//       var folders = getFolders(xpath.webappSource);
//        folders.forEach(function (folder) {
//            gulp.src(xpath.webappSource + folder + '/js/main.js')
//		.pipe(requirejsOptimize())
//		.pipe(gulp.dest('dist'));
//        });
//    return ;
//});
gulp.task('maven_build', ['clean', 'scripts'], function () {

});