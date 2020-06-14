/**
L'utente può spostarsi tra le varie recensioni tramite dei pulsanti ("avanti" e "indietro").
	- per semplicità, ordiniamo le recensioni in base al loro id
Crea le funzioni per agganciarsi a questi eventi nella funzione $(document).ready()​. Imposta la chiamata ajax, riempiendo il campo 
data con tutti i parametri, e le funzioni necessarie per implementare la funzionalità anche lato server.
 */
$(document).ready(function(){
	
	$("#recensione_precedente").click(function(event){
		// vai alla recensione precedente
		chiamata_server("recensione_precedente");
	});
	$("#recensione_successiva").click(function(event){
		// vai alla recensione successiva
		chiamata_server("recensione_successiva");
	});
	
	function chiamata_server(cmd){
		id = $("#id").val()
		
	    $.ajax({
	       url: "mostra_recensione.html",
	       type: "GET",
	       data: {
	    	   cmd: cmd, 
	    	   id: id 
	       },
	       dataType: 'json', 
	       success: function (data, state) {caricaRecensione(data);},
	       error: function(xhr, status, error) {
	    	   // stampa eventuali errori
	    	   console.log(xhr.responseText);
	    	   console.log(status);
	    	 }
		 });
	};

	function caricaRecensione(recensione) {
		if(recensione.id != ""){
			// aggiorno il titolo del film
			$("#titolo_film").html(recensione.film.nome);
			// aggiorno i dettagli della recensione
			var dettagli_recensione = "Autore: "+recensione.autore.username+"- voto: "+recensione.voto;
			$("#dettagli_recensione").html(dettagli_recensione);
			// aggiorno il contenuto della recensione
			$("#contenuto_recensione").html(recensione.contenuto_recensione);
			// aggiorno l'id
			$("#id").val(recensione.id)
		}
	}

});