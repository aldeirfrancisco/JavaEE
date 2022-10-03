/**
 * Confirmar a exclusao de um contato
 * @author Aldeir francisco da Silva
 * @param idcom
 */
 
 function confirmar(idcom){
	
	let resporta = confirm("Confirma a exclusão deste contato ?");
	if(resporta === true){
  //redireciona para o servlet
		window.location.href ="delete?idcom="+idcom;
	}
}