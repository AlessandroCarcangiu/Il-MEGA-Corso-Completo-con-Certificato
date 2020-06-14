// Verifica se una stringa in input è palindroma o meno.
// La soluzione è abbastanza semplice, scorriamo contemporaneamente l'array in ambo i sensi 
// e controlliamo se i singoli caratteri sono uguali. Sfruttiamo due concetti:
// 1) le stringe si comportano come dei vettori unidimensionali;
// 2) se dividiamo una stringa palindroma in due parti uguali, le due metà sono uguali (nel caso di una stringa dispari, un carattere rimarrà fuori dal controllo ma questo non cambierà il risultato)

function controlla_palindroma(stringa){
	
	// controlla se la stringa è vuota
	if(stringa.length === 0){
		console.log("Stringa in input non valida");
	}
	
	// inizializzo tre variabili: 
	start = 0 // è l'indice che useremo per scorrere la stringa dalla posizione 0
	end = stringa.length-1; // è l'indice che useremo per scorrere la stringa dal verso opposto (quindi dalla fine) 
	flag_palindroma = true; // conserverà il risultato della funzione
	
	// scorro la stringa sino a metà lunghezza a meno che non abbia già appurato che la stringa non è palindroma
	while(start <= Math.floor(stringa.length/2) && flag_palindroma===true){
		// controlla se start == end, se sono diversi, poni flag_palindroma = false
		if (!(stringa[start] == stringa[end])){
			flag_palindroma = false;
		}
		start++;
		end--;
	}
	
	if(flag_palindroma==false){
		console.log("La stringa non è palindroma!");
	} else{
		console.log("La stringa è palindroma!");
	}
}

controlla_palindroma('abba'); // stampa "La stringa è palindroma!"
controlla_palindroma('madam'); // stampa "La stringa è palindroma!"
controlla_palindroma('1221'); // stampa "La stringa è palindroma!"
controlla_palindroma('ru'); // stampa "La stringa non è palindroma!"