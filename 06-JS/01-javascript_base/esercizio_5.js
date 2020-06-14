/*
Considera un array unidimensionale di 100 interi, generati casualmente. Conta le occorrenza di ciascun valore 
all'interno di tale vettore.
Hint: usa l'istruzione Math.floor(Math.random()*100) per generare un intero casuale compreso tra 0 e 99
*/

function funzione_conta_occorrenze(){
	// inizializzo il dizionario che conterrà il numero di occorrenze per ciascun valore
	dizionario = {};
	
	// genero i cento numeri casuali e li conteggio
	for (var x=0; x < 100; x++){
		numero_casuale = Math.floor(Math.random()*100);
		
		if (!(numero_casuale in dizionario))
		{
			dizionario[numero_casuale] = 0;
		}
		dizionario[numero_casuale]+=1;
	}
	
	console.log("funzione_conta_occorrenze: ");
	for (var key in dizionario){
		console.log(key+": "+dizionario[key]);
	}
}

funzione_conta_occorrenze();