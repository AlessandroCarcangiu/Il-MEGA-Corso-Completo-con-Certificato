/*
1. Crea una funzione che scambi il valore di due variabili
2. Definisci una funzione che esegua la moltiplicazione di due numeri passati in input senza usare l'operatore * 
3. Definisci una funzione ​potenza. Questa prende due parametri ("a", "b"),  e restituisce il risultato di 𝑎^𝑏 
(vi vedo se usate la funzione Math.pow....)
*/

function funzione_scambia_valore(a,b){
	// per effettuare lo scambio, uso banalmente una variabile di appoggio
	temp = a
	a = b
	b = temp
	
	console.log("funzione_scambia_valore: "+a+" - "+b);
	return a,b
}

function funzione_moltiplicazione(a,b){
	// inizializzo la variabile che memorizzerà il risultato della moltiplicazione
	risultato = a;
	
	// a * b = a sommato per se stesso 'b' volte. Quindi 2*3 = 2+2+2
	for (var x=1;x < b;x++){
		risultato+=a;
	}
	
	console.log("funzione_moltiplicazione: "+risultato);
	return risultato;
}

function funzione_potenza(a,b){
	// inizializzo la variabile che memorizzerà il risultato dell'operazione
	risultato = a;
	
	// a ^ b = a moltiplicato per se stesso 'b' volte - sfruttiamo la funzione_moltiplicazione 
	for (var x=1;x < b;x++)
	{
		risultato=funzione_moltiplicazione(risultato,a);
	}
	
	console.log("funzione_potenza: "+risultato);
}

funzione_scambia_valore(10,"abba"); // stampa funzione_scambia_valore: abba - 10
funzione_moltiplicazione(2,4); // stampa funzione_moltiplicazione: 8
funzione_potenza(2,4); // stampa funzione_potenza: 16