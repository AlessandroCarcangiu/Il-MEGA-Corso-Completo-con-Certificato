/*
Data una generica stringa in input, scrivi due funzioni che estraggono da essa:
i caratteri che non si ripetono
i caratteri che si ripetono
*/

function estrai_caratteri_che_non_si_ripetono(stringa){
	// inizializzo la variabile in cui salverò i caretteri univoci
	caratteri_unici = "";
	 
	for (var x=0;x < stringa.length;x++)
	{
		valore = stringa[x];
		
		regex_valore = new RegExp(valore, "g");
		if (stringa.match(regex_valore).length == 1){
			caratteri_unici+=valore;
		}
	}
	
	console.log(caratteri_unici);
}

function estrai_caratteri_che_si_ripetono(stringa){
	// inizializzo la variabile in cui salverò i caretteri univoci
	caratteri_ripetuti = "";
	
	for (var x=0;x < stringa.length;x++)
	{
		valore = stringa[x];
		
		regex_valore = new RegExp(valore, "g");
		if (!caratteri_ripetuti.includes(valore) && (stringa.match(regex_valore).length > 1)){
			caratteri_ripetuti+=valore;
		}
	}
	
	console.log(caratteri_ripetuti);
}

estrai_caratteri_che_non_si_ripetono("cixiri"); // stampa "cxr"
estrai_caratteri_che_si_ripetono("cixiri"); // stampa "i"