$( document ).ready( function(){
	$( "#txtNombre" ).keyup(function(event) {
		if ($("#txtNombre").val() != ""){
		 	$.ajax({
				type: "GET",
				url: BASE_URL + "departamento/buscar",
				data: "nombre=" + $("#txtNombre").val(),
				async: false,
				success:function(data){
					data = JSON.parse(data);
					var lista_coincidencias = "";
					$("#coincidencias").empty();

					for(var k = 0; k < data.length; k++){
						var id = data[k]["id"];
						var nombre = data[k]["nombre"];
						lista_coincidencias = lista_coincidencias + '<li id="' + id + '" class="item">' + nombre + '</li>';
					}

					$("#coincidencias").append(lista_coincidencias);	
				}
			});
	 	}else{
	 		$("#coincidencias").empty();
	 		$("#distrito_id").html("");
	 		$("#txtNombre").val("");
	 	}
	});

	$( "#coincidencias" ).on("click", function(event) {
		var id_distrito = $(event.target).attr("id");
		var nombre = $(event.target).html();
		
		$("#txtNombre").val(nombre);
		$("#distrito_id").html(id_distrito);
	});
});