/*
Archivos que usa :
	+ views/
*/

var Router = Marionette.AppRouter.extend({
routes: {
	    'email/:email': 'showEmail',
	    "" : "showUsuarios", 
		"accesos/usuarios" : "showUsuarios",
		"accesos/sistemas" : "showSistemas",
		"accesos/sistemas/menu/:sistema_id" : "showSistemaMenu",
		"accesos/sistemas/permiso/:sistema_id" : "showSistemaPermiso",
		"accesos/sistemas/rol/:sistema_id" : "showSistemaRol",
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
	showSistemaMenu: function(sistema_id){
		var menuView = new MenuView({});
		menuView.render();
		menuView.mostrarTabla(sistema_id);
	},
	showSistemaPermiso: function(sistema_id){
		var permisoView = new PermisoView({});
		permisoView.render();
		permisoView.mostrarTabla(sistema_id);
	},
	showSistemaRol: function(sistema_id){
		var rolView = new RolView({});
		rolView.render();
		rolView.mostrarTabla(sistema_id);
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