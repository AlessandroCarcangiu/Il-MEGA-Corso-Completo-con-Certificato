/*
Crea un form per la registrazione di un utente su un sito (nome, cognome, username e password). 
Al click del pulsante submit, devi far in modo che il form non venga inviato se tutti i campi non sono stati compilati.
	NB: non preoccuparti di gestire la correttezza dei dati.
*/
const id_errori = "paragrafo_errori";

function verifica()
{
	id_degli_elementi_da_controllare = ["nome","cognome","username","password"];
	flag_elementi_compilati = true;
	
	// controlla che tutti i campi siano compilati
	indice = 0;
	while(indice < id_degli_elementi_da_controllare.length && flag_elementi_compilati){
		id = id_degli_elementi_da_controllare[indice];
		if(document.getElementById(id).value == ""){
			flag_elementi_compilati = false; // se uno degli elementi è vuoto, allora aggiorniamo il flag (e quindi usciamo dal while)
		}
		indice+=1;
	}
	
	// mostra un feedback se flag_elementi_compilati == false
	if (flag_elementi_compilati==false){
		alert("Error, non hai compilato tutti i campi!");
	}
}