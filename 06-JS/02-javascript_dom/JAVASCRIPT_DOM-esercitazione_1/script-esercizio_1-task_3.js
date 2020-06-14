/*
Crea un nuovo file javascript. Scrivi un'istruzione che verifichi se il mese corrente sia Luglio. 
In caso affermativo stamperà sul file .html "​Siamo a LUGLIO!", altrimenti "​Non siamo a LUGLIO".
	- HINT: per ottenere un numero corrispondente al mese corrente prova a utilizzare queste istruzioni 
	  ​var date = new Date(); var m_num = date.getMonth();

*/
const luglio = 7;

function controlla_mese(){
	// determino la data odierna
	data_corrente = new Date();
	mese_corrente = data_corrente.getMonth();
	
	// controllo se il mese corrente è uguale a LUGLIO
	if (mese_corrente == luglio){
		document.write("Siamo a LUGLIO!");
	}
	else{
		document.write("Non siamo a LUGLIO");
	}
}

controlla_mese();