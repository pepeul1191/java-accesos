/*
Archivos que usa :
	+ views/buscar.js
	+ views/contacto.js
	+ views/registro.js
	+ views/login.js
*/

var Router = Marionette.AppRouter.extend({
routes: {
	    'email/:email': 'showEmail',
	    "" : "showUsuarios", 
		"accesos/usuarios" : "showUsuarios",
		"accesos/sistemas" : "showSistemas",
		"*actions" : "showUsuarios"
	},
	showEmail: function(email) {
	    // show the email
	    alert(email);
	},
	showUsuarios: function(){
		var usuarioView = new UsuarioView({});
		usuarioView.render();
	},
	showSistemas: function(){
		var sistemaView = new SistemaView({});
		sistemaView.render();
		sistemaView.mostrarTabla();
	},
});

const App = Marionette.Application.extend({
  region: '#body-app',
  onStart() {
  	var router = new Router();
   Backbone.history.start();
  }
});

const myApp = new App();
myApp.start();