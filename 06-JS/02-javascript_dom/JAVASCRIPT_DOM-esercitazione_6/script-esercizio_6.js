/*
Crea una serie di 3 div, uno dentro l'altro, ognuno con un id diverso.
Questi div devono apparire in modo che siano facilmente cliccabili (usa le proprietà height e width). 
Gestisci il click di ogni div, associando un event handler che mostri un alert con il nome del div cliccato.
*/
const id_errori = "paragrafo_errori";

function click_div(event)
{
	// mostra l'id dell'elemento selezionato
	alert(event.target.id);
}