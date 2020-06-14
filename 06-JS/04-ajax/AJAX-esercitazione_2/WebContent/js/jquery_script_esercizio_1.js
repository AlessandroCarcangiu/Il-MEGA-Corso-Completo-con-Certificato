/**
Considera l'applicazione web su cui hai lavorato durante le varie esercitazioni.
Crea il file "script_jquery_esercizio_1.js" all'interno di questo percorso "WEB-INF/js/"
Al suo interno, inserisci le istruzioni per ascoltare quando un utente preme dei tasti della tastiera e mostra,
sulla console del browser, le lettere premute. 
 */
$(document).ready(function(){
	$("body").keypress(function(event){
		// dobbiamo estrarre da event la lettera premuta
		// il metodo event.which ci fornisce questa informazione (peccato sotto forma di codice ASCII)
		// per convertirlo in stringa, usiamo la funzione String.fromCharCode 
		// (che, dato un codice ASCII, restituisce il carattere ad esso associato) 
		tasto_premuto = String.fromCharCode(event.which);
		
		// stampiamo sulla console la lettera premuta
		console.log("Hai premuto il tasto "+tasto_premuto);
	});
});
