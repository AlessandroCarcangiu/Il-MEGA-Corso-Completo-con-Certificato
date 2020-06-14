/*
Scrivi una pagina HTML che contenga i seguenti elementi:
	- Un titolo
	- Una text area
	- Un bottone
Al click del bottone, quello che è stato scritto nella text area viene remplicato in coda alla pagina (sotto il bottone) 
in un elemento HTML apposito. Nel caso sià già presente del testo, il nuovo contenuto lo deve sostituire.
*/

function copia_testo_textarea(){
	// prendi il contenuto dalla textarea
	text_area = document.getElementById("text_area");
	
	// copia il testo di text_area nell'elemento con id="coda_pagina"
	coda_pagina = document.getElementById("coda_pagina");
	coda_pagina.innerHTML = text_area.value;
}
