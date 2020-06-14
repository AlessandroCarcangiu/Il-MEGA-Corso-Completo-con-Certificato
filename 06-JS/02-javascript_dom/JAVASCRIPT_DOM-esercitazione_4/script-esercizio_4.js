/*
Realizza una pagina web che contenga un titolo, una lista puntata di 5 elementi ed un pulsante.
Al caricamento della pagina (cerca di capire quale sia l'oggetto e l'evento da utilizzare), 
associa ll click del pulsante a una funzione che aggiunga la posizione di ognuno degli elementi 
della lista in coda al testo dell'elemento stesso
*/

function stampa_posizione(event)
{
	// prendi dal document gli elementi con tag = li contenuti dentro l'elemento con id="lista_puntata"
    var elementi_lista = document.querySelectorAll("#lista_puntata li");
	
	// prendi da document l'elemento con id="coda_pagina"
	var coda_pagina = document.getElementById("coda_pagina");
    	
	// scorri tutti gli elementi della lista
	for(var indice=0;indice<elementi_lista.length;indice++){
		coda_pagina.innerText+=("Posizione "+(indice+1)+": "+elementi_lista[indice].innerHTML+"\n");
	}
	
}