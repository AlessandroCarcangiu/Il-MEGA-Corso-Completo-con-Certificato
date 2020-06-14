/**
All'interno della sezione con id="content_main", aggiungi due piccoli pulsanti a lato del titolo 
che permettano, rispettivamente, di aumentare e diminuire le dimensioni del font del testo del paragrafo 
sottostante. 
NB: le modifiche non devono richiedere di ricaricare la pagina
 */
$(document).ready(function(){
	
	$("#aumenta_carattere").click(function(event){
		// incrementa il font
		cambia_dimensioni_font(1);
	});
	$("#riduci_carattere").click(function(event){
		// decrementa il font
		cambia_dimensioni_font(-1);
	});
	
	function cambia_dimensioni_font(valore){
		// prendi le dimensioni attuali
		var dimensione_attuale = parseInt($("#paragrafo_sottostante").css("font-size"));
		// esegui la modifica (incremento o decremento, dipende dal pulsante premuto)
		var nuova_dimensione = dimensione_attuale+valore;
		// aggiorna il valore associato all'attributo font-size di body
		$("#paragrafo_sottostante").css({'font-size':nuova_dimensione + "px"});
	};
});
