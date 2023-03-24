// Selecionando os campos de entrada e o botão de envio
const inputNome = document.getElementById('floatingInputNome');
const inputTelefone = document.getElementById('floatingInputTelefone');
const inputEmail = document.getElementById('floatingInputEmail');
const inputTipo = document.getElementById('floatingSelectTipo');
const inputCpf = document.getElementById('floatingInputCpf');
const inputCnpj = document.getElementById('floatingInputCnpj');
const submitButton = document.getElementById('submitButton');

const campoCpf = document.getElementById('campoCpf');
const campoCnpj = document.getElementById('campoCnpj');

// Adicionando um ouvinte de eventos para cada campo de entrada
inputNome.addEventListener('input', checarInput);
inputTelefone.addEventListener('input', checarInput);
inputEmail.addEventListener('input', checarInput);
inputTipo.addEventListener('input', checarInput);
inputCpf.addEventListener('input', checarInput);
inputCnpj.addEventListener('input', checarInput);

inputTipo.addEventListener('change', checarTipo)

// Função para verificar se todos os campos estão preenchidos
function checarInput() {
	if (
		inputNome.value !== '' &&
		inputTelefone.value !== '' &&
		inputEmail.value !== '' &&
		(inputCpf.value !== '' || inputCnpj.value !== '') &&
		(inputTipo.value === 'PF' || inputTipo.value === 'PJ')
		){
		submitButton.disabled = false;
	}
	else {
		submitButton.disabled = true;
	}
}

function checarTipo(){
	if (inputTipo.value === 'PF') {
		campoCnpj.style.display = 'none';
		campoCpf.style.display = 'block';
	}
	else if (inputTipo.value === 'PJ') {
		campoCnpj.style.display = 'block';
		campoCpf.style.display = 'none';
	}
	else {
		campoCnpj.style.display = 'none';
		campoCpf.style.display = 'none';
	}
}

