#encoding: UTF-8
#language: pt

Funcionalidade: Cadastro Tricentis
  Preencher formulario e obter mensagem de sucesso

  Cenario: Realizar o cadastro com sucesso
		Quando informo os campos da aba enter Vehicle Data e prossigo
		E informo os dados da aba enter Insurant Data e prossigo
		E informo os dados da aba enter Product Data e prossigo
		E informo os dados da aba Select Price Option e prossigo
		E informo os dados da aba Send Quote e envio
		Entao valido a mensagem de sucesso