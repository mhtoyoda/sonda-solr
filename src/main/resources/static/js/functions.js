function validateInstructions(e){
	var expressao;
	expressao = /[LlMmRr]/;
	if(expressao.test(String.fromCharCode(e.keyCode))){
		return true;
	}else{
		return false;
	}
}

function validateIdentificacao(e){
	var expressao;
	expressao = /[A-Za-z0-9]/;
	if(expressao.test(String.fromCharCode(e.keyCode))){
		return true;
	}else{
		return false;
	}
}