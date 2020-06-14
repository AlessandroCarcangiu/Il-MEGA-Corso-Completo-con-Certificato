/**
Filtro per le recensioni
 */
$(document).ready(function(){
	
	$("#input_nav").keyup(function(event){
		// vai alla recensione precedente
		chiamata_filtro($('#input_nav').val());
	});
	
	function chiamata_filtro(input_utente){		
		// uso del parametro cmd completamente opzionale
	    $.ajax({
	       url: "filtro_recensioni.html",
	       type: "GET",
	       data: {
	    	   input_utente: input_utente 
	       },
	       dataType: 'json', 
	       success: function (data, state) {caricaRecensioni(data);},
	       error: function(xhr, status, error) {
	    	   // stampa eventuali errori
	    	   console.log(xhr.responseText);
	    	   console.log(status);
	    	 }
		 });
	};

	function caricaRecensioni(recensioni) {
		
		// svuota il contenuto di lista_recensioni 
		// è importante svuotare la lista, altrimenti rimarrebbero i risultati vecchi
		$('#lista_recensioni').empty();
		
		// crea un elemento li per ogni recensione
		recensioni.forEach(function(recensione){
			$("#lista_recensioni").append('<li><a href="mostra_recensione.html?id='+recensione.id+'">'+recensione.film.nome+" by "+recensione.autore.username);
		});
	}

});