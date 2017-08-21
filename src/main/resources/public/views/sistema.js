var SistemaView = Backbone.View.extend({
	el: '#workspace',
	initialize: function(){
		//this.render();
		//console.log("initialize");
	},
	render: function() {
		this.$el.html(this.getTemplate());
		return this;
	},
	getTemplate: function() {
		var data = { };
		var template_compiled = null;
		$.ajax({
		   url: STATICS_URL + 'templates/sistema.html', 
		   type: "GET", 
		   async: false, 
		   success: function(source) {
		   	var template = Handlebars.compile(source);
		   	template_compiled = template(data);
		   }
		});
		return template_compiled;
	},
	mostrarTabla: function(){
	   	var ajax_dao_tipo_activos = new AjaxPython(); 
	   	ajax_dao_tipo_activos.Constructor("GET", BASE_URL + "sistema/listar", "", false);
	   	var tablaSistemas = new Grid();
	   	tablaSistemas.SetTableId("tablaSistemas");
	   	tablaSistemas.SetTableObj("tablaSistemas");
	   	tablaSistemas.SetTableHeader(sistema_array_json_th);
	   	tablaSistemas.SetTableBody(sistema_array_json_td, sistema_array_json_btn_td, ajax_dao_tipo_activos);
	   	tablaSistemas.SetTableFooter(sistema_array_json_btn, false);
	   	tablaSistemas.SetLabelMensaje("#txtMensajeRpta");
	   	tablaSistemas.SetURLGuardar(BASE_URL + "sistema/guardar");

	   	tablaSistemas.MostrarTable();
	}
});
