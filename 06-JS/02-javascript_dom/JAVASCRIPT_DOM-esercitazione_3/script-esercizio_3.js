/*
Scrivi una semplice interfaccia web per acquistare dei panini. La tua paninoteca mette a disposizione 5 differenti ingredienti:
	- radicchio
	- hamburger di pollo
	- salmone e polpo
	- cipolle rosse
	- tofu
Le regole del tuo negozio sono molto semplici:
	1) non si possono prendere più di tre gusti per gelato
	2) l'opzione 3 non può essere combinato con gli altri ingredienti

*/
const gusto_1 = "radicchio"
const gusto_2 = "hamburger_pollo";
const gusto_3 = "salmone_polpo";
const gusto_4 = "cipolle_rosse";
const gusto_5 = "tofu";


function verifica(event)
{
	// inizializza la variabile che conterrà i gusti scelti dall'utente
	var gusti = [];
	
	// prendi dal document l'elemento con id="select" (da cui possiamo prelevare i gusti scelti dall'utente)
    var select = document.getElementById("select");
    
	// scorri tutti i gusti presenti nella select e determina quali sono quelli scelti dall'utente
    for(var i = 0; i < select.options.length; i++)
    {
		// se il gusto è stato selezionato, allora salvalo dentro "gusti"
        if(select.options[i].selected)
            gusti.push(select.options[i].value);
    }
    
	// crea un oggetto di tipo panino
    var panino = new Panino(gusti);
    
	// controlla la prima condizione
    if(panino.numeroGusti() > 3 || panino.numeroGusti()<1)
        document.getElementById("risultato_ordinazione").innerHTML = "Errore! Hai seleziona o troppi gusti o troppo pochi";
	// controlla la seconda condizione
    else if(panino.contieneSalmonePolpo() && panino.numeroGusti() > 1)
        document.getElementById("risultato_ordinazione").innerHTML = "Errore! Con salmone e polpo non puoi selezionare altri gusti!";
	// se non sono stati rilevati problemi allora consegna all'utente il panino che ha ordinato
    else
        document.getElementById("risultato_ordinazione").innerHTML = "Ecco il tuo panino!";
}

function Panino(gusti)
{
    var gusti = gusti;
    
    Panino.prototype.numeroGusti = function()
    {
        return gusti.length;
    };
    
    Panino.prototype.contieneSalmonePolpo = function()
    {
        for(var i = 0; i < gusti.length; i++)
        {
            if(gusti[i] === gusto_3)
                return true;
        }
        return false;
    };
}
