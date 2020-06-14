/*
Dato in input una serie di stringhe, scrivi la funzione che indichi quale è la stringa più lunga.
Esempio: "a","ab","abba", tra le tre la più lunga è "abba".
*/

function trova_la_stringa_piu_lunga(stringhe){
	// inizializzo le variabili che descrivono l'indice della stringa più lunga
	lunghezza_max = 0;
	indice_stringa_piu_lunga = -1;
	
	
	// controlla la lunghezza di ogni stringa
	for (var x=0;x < stringhe.length;x++)
	{
		lunghezza_stringa_attuale = stringhe[x].length;
		
		if (indice_stringa_piu_lunga < 0 || lunghezza_stringa_attuale > lunghezza_max){
			// aggiorno le variabili relative alla stringa più lunga
			lunghezza_max = lunghezza_stringa_attuale;
			indice_stringa_piu_lunga = x;
		}
	}
	
	console.log(stringhe[indice_stringa_piu_lunga]);
}

trova_la_stringa_piu_lunga(["a","ab","abba"]); // stampa "abba"