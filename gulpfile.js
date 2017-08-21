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
  	gulp.src([
  		MEDIA + 'bower_components/font-awesome/fonts/*', 
  		MEDIA + 'bower_components/bootstrap/fonts/*'])
    .pipe(plumber())
    .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('layout-css', function() {
      gulp.src([
    	  	MEDIA + 'bower_components/bootstrap/dist/css/bootstrap.min.css', 
    	  	MEDIA + 'bower_components/font-awesome/css/font-awesome.min.css'])
      .pipe(plumber())
      .pipe(concatCss('vendor.min.css'))
      .pipe(minifyCss())
      .pipe(replace('../../../font-awesome/fonts/', BASE_URL + 'dist/assets/'))
      .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('swp-plugins', function(){
    gulp.src([
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools-core.min.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools.min.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools-interfaces.min.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/jquery.upload.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools.chain.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools.dao.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools.autocomplete.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools.form.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools.observer.js', 
    		MEDIA + 'bower_components/swp-plugins/assets/js/mootools.grid.js'
    		])
     .pipe(plumber())
     .pipe(concatJs('swp.js'))
     .pipe(gulp.dest(DESTINO + 'assets'));

     gulp.src([
    	 	MEDIA + 'bower_components/swp-plugins/assets/css/mootools.autocomplete.css', 
    	 	MEDIA + 'bower_components/swp-plugins/assets/css/mootools.grid.css', 
    	 	MEDIA + 'bower_components/swp-plugins/assets/css/mootools.validations.css'])
     .pipe(plumber())
     .pipe(concatCss('swp.css'))
     .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('layout-js', function() {
    gulp.src([
    		MEDIA + 'bower_components/jquery/dist/jquery.min.js', 
    		MEDIA + 'bower_components/bootstrap/dist/js/bootstrap.min.js', 
    		MEDIA + 'bower_components/underscore/underscore-min.js', 
    		MEDIA + 'bower_components/backbone/backbone-min.js', 
    		MEDIA + 'bower_components/handlebars/handlebars.min.js',
    		MEDIA + 'bower_components/backbone.marionette/lib/backbone.marionette.min.js'])
    .pipe(plumber())
    .pipe(concatJs('vendor.min.js'))
    .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('layout', ['fonts', 'layout-css', 'layout-js']);

gulp.task('styles', function() {
      gulp.src([DESTINO + 'assets/vendor.min.css', MEDIA + 'assets/site/css/styles.css'])
      .pipe(plumber())
      .pipe(concatCss('styles.min.css'))
      //.pipe(minifyCss())
      .pipe(gulp.dest(DESTINO + 'assets'));
});

// ---------------------------------------------------------------------------------------------------------------------------------------------

gulp.task('login', function(){
	 gulp.src([DESTINO + 'assets/styles.min.css', MEDIA + 'assets/login/index.css'])
     .pipe(plumber())
     .pipe(concatCss('login.min.css'))
    // .pipe(minifyCss())
     .pipe(gulp.dest(DESTINO + 'assets'));
});

gulp.task('mantenimiento', function(){
  gulp.start('fonts', 'layout-css', 'layout-js', 'swp-plugins', 'styles');
	
  gulp.src([
	  DESTINO + 'assets/vendor.min.js', 
	  DESTINO + 'assets/swp.js',
	  MEDIA + 'layouts/mantenimiento.js', 
	  MEDIA + 'views/usuario.js', 
	  MEDIA + 'views/_table_sistema.js', 
	  MEDIA + 'views/sistema.js', 
	  MEDIA + 'views/menu.js', 
	  MEDIA + 'routes/router.js'])
//.pipe(uglify())
  .pipe(plumber())
  .pipe(concatJs('mantenimiento.min.js'))
  .pipe(gulp.dest(DESTINO + 'assets'))
  .pipe(livereload());
  
  gulp.src([DESTINO + 'assets/styles.min.css', DESTINO + 'assets/swp.css'])
  .pipe(plumber())
  .pipe(concatCss('mantenimiento.min.css'))
  .pipe(gulp.dest(DESTINO + 'assets'));
});

