/*
Scrivi un programma che calcoli l'eta di una persona a partire dalla sua data di nascita:
	- Supponi che la data sia espressa come: "dd/mm/yyyy";
	- Hint: usa new Date() per ricavare la data odierna.
*/

function funzione_calcola_eta(data_di_nascita){
	// converto data_di_nascita in un oggetto di tipo Date per semplice comodità
	data_di_nascita = new Date(data_di_nascita.split('/'));
	// recupero la data odierna
	data_odierna = new Date();
	
	// età della persona = data_odierna - data_di_nascita espressa in millisecondi
	eta_in_millisecondi = data_odierna-data_di_nascita;
	
	// converto l'età in giorni = eta_in_millisecondi / (ms * s * m * h), dove
	// ms = numero di millisecondi in un secondo, ovvero 1000
	// s = numero di secondi in un minuto, ovvero 60
	// m = numero di minuti in un'ora, ovvero 60
	// h = numero di ore in un giorno, ovvero 24
	// (ms * s * m * h) = al numero di millisecondi in un giorno
	const ms = 1000;
	const s = 60;
	const m = 60;
	const h = 24;
	eta_in_giorni = eta_in_millisecondi / (ms*s*m*h);
	
	// converto l'età in anni = eta_in_giorni / 365 (cioè al numero di giorni dell'anno)
	const d = 365;
	eta = Math.floor(eta_in_giorni / d);
	
	
	console.log("età: "+eta);
}

funzione_calcola_eta("01/01/1990");