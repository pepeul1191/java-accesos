/*! layouts/site.js 
	variables : BASE_URL, STATICS_URL, MODULOS_JSON, DATA
*/

$( document ).ready(function() {
	var mantenimiento_template = $("#mantenimiento-template").html();
	var template = Handlebars.compile(mantenimiento_template);
	Handlebars.registerPartial("menu_submodulos", $("#menu-submodulos").html());
	Handlebars.registerPartial("yield", $("#yield").html());

	var data = {
		'BASE_URL' : BASE_URL, 
		'STATICS_URL' : STATICS_URL,
		'DATA' : DATA
	};
	var template_compiled = template(data);

	$("#body-workspace").html(template_compiled);
});

Handlebars.registerHelper( "menuSubmodulos", function (){
	var rpta = '<ul>';
	//console.log(SUBMODULOS_JSON);
	SUBMODULOS_JSON.forEach(function(submodulo) {
		//console.log(submodulo.items);
	    rpta = rpta + "<li>" + submodulo.subtitulo + "<ul>";
	    submodulo.items.forEach(function(item){
	    		rpta = rpta + "<li><a href='"+ BASE_URL + item.url  + "'>" + item.item + "</a></li>";
	    });
	    rpta = rpta + "</ul></li>";
	});
	return rpta + "</ul>";    
});

Handlebars.registerHelper('getValue', function(obj, key) {
    return obj[key];
});