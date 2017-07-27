var gulp = require('gulp');
var uglify = require('gulp-uglify');
var concatCss = require('gulp-concat-css');
var concatJs = require("gulp-concat");
var minifyCss = require("gulp-minify-css");
var replace = require('gulp-replace');
var plumber = require('gulp-plumber');
var watch = require('gulp-watch');
var livereload = require('gulp-livereload');
var BASE_URL = 'http://localhost:2000/';
var DESTINO = 'src/main/resources/public/dist/';
var MEDIA = 'src/main/resources/public/'

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------

function errorLog(error){
    console.error.bind(error);
    this.emit('end');
}

gulp.task('watch', function(){
    var server = livereload();

    gulp.watch([MEDIA + 'layouts/**',  DESTINO + '**/**/**'], ['login', 'home']);
});

gulp.task('default', function(){
	console.log("HOLA!!!");
});

gulp.task('demo', function(){
  gulp.src('assets/*/*.js')
    .pipe(plumber())
    .pipe(uglify())
    .pipe(gulp.dest(MEDIA + 'dist/js'));
});

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------

gulp.task('fonts', function() {
  	gulp.src([MEDIA + 'bower_components/font-awesome/fonts/*', MEDIA + 'bower_components/bootstrap/fonts/*'])
    .pipe(plumber())
      .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('layout-css', function() {
      gulp.src([MEDIA + 'bower_components/bootstrap/dist/css/bootstrap.min.css', MEDIA + 'bower_components/font-awesome/css/font-awesome.min.css'])
      .pipe(plumber())
      .pipe(concatCss('styles.min.css'))
      .pipe(minifyCss())
      .pipe(replace('../../../font-awesome/fonts/', BASE_URL + 'dist/assets/'))
      .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('layout-js', function() {
    gulp.src([MEDIA + 'bower_components/jquery/dist/jquery.min.js', MEDIA + 'bower_components/bootstrap/dist/js/bootstrap.min.js', MEDIA + 'bower_components/underscore/underscore-min.js', MEDIA + 'bower_components/backbone/backbone-min.js', MEDIA + 'bower_components/handlebars/handlebars.min.js'])
    .pipe(plumber())
    .pipe(concatJs('app.min.js'))
    .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('layout', ['fonts', 'layout-css', 'layout-js']);

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------

gulp.task('departamentos', function(){
	  gulp.src([DESTINO + 'assets/app.min.js',  MEDIA + 'assets/layouts/home.js',  MEDIA + 'assets/departamento/js/index.js'])
	    //.pipe(uglify())
	    .pipe(plumber())
	    .pipe(concatJs('app.min.js'))
	    .pipe(gulp.dest(DESTINO + 'departamento'))
	    .pipe(livereload());
});

gulp.task('home', function(){
  gulp.src([DESTINO + 'assets/app.min.js',  MEDIA + 'assets/layouts/home.js',  MEDIA + 'assets/home/js/index.js'])
    //.pipe(uglify())
    .pipe(plumber())
    .pipe(concatJs('app.min.js'))
    .pipe(gulp.dest(DESTINO + 'home'))
    .pipe(livereload());
});



