/*
Crea una variabile di nome "​risultato" ed esegui le operazioni elencate qua sotto. 
Al termine di ognuna, stampa il valore della variabile preceduto dalla descrizione a parole dell'operazione eseguita. 
Per esempio: ("Aggiungi 2: " + risultato)
	1) Assegna 8 alla variabile "risultato"
	2) Aggiungi 2
	3) Sottrai 4
	4) Moltiplica per 5
	5) Dividi per 3
	6) Incrementa il valore di 1
	7) Decrementa il valore di 1
*/

// inizializzo la variabile risultato (punto 1)
risultato = 8;
document.writeln("Assegna 8 alla variabile risultato: " + risultato + "<br>");

// sommo 2
risultato+=2;
document.writeln("Aggiungi 2: " + risultato + "<br>");

// sottrai 4
risultato-=4;
document.writeln("Sottrai 4: " + risultato + "<br>");

// Moltiplica per 5
risultato*=5;
document.writeln("Moltiplica per 5: " + risultato + "<br>");

// Dividi per 3
risultato/=3;
document.writeln("Dividi per 3: " + risultato + "<br>");

// Incrementa il valore di 1
risultato++;
document.writeln("Incrementa il valore di 1: " + risultato + "<br>");

// Decrementa il valore di 1
risultato--;
document.writeln("Decrementa il valore di 1: " + risultato + "<br>");