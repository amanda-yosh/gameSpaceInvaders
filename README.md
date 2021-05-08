# Game Space Invaders
Objetivo do projeto era criar um jogo no estilo de Space Invaders utilizando os conceitos aprendidos na disciplina de programa��o orientada a objetos.
Assim sendo, as classes foram separadas de acordo com suas responsabilidades dentro dos pacotescada classe do jogo tem uma responsabilidade.
A **Launch** � respons�vel pela execu��o do programa, ela cont�m o main.
J� o jogo em si est� na classe **Game**.
Nela s�o instanciados dois objetos, um da classe Display e e outro da classe Thread. Para podermos utilizar a *Thread* precisamos implementar a interface *Runnable* que pede o uso do m�todo run().
O Display � quem cria a tela do jogo atrav�s do objeto JFrame, assim � poss�vel colocar um t�tulo a janela, redimensionar a tela, adicionar elementos, entre outros.
Outro objeto usado no Display � o Canvas, que define a area de pintura da tela e fica responsavel por pintar os elementos na tela.


Resolvendo o problema da pintura
O computador tem muitos ciclos por segundo, e assim n�o conseguimos ver a pintura da tela.
Usando a thread para separar os programa faz com que possamos ver
O metodo run() fica com a parte de pintura da tela. Ela comeca quando chamado pelo metodo start() e para atraves do metodo stop()

Assim, o inicio do jogo se d� a partir da instancia��o de um objeto da classe *Game* em *Launch*.