# Game Space Invaders
Objetivo do projeto era criar um jogo no estilo de Space Invaders utilizando os conceitos aprendidos na disciplina de programação orientada a objetos.
Assim sendo, as classes foram separadas de acordo com suas responsabilidades dentro dos pacotescada classe do jogo tem uma responsabilidade.
A **Launch** é responsável pela execução do programa, ela contém o main.
Já o jogo em si está na classe **Game**.
Nela são instanciados dois objetos, um da classe Display e e outro da classe Thread. Para podermos utilizar a *Thread* precisamos implementar a interface *Runnable* que pede o uso do método run().
O Display é quem cria a tela do jogo através do objeto JFrame, assim é possível colocar um título a janela, redimensionar a tela, adicionar elementos, entre outros.
Outro objeto usado no Display é o Canvas, que define a area de pintura da tela e fica responsavel por pintar os elementos na tela.


Resolvendo o problema da pintura
O computador tem muitos ciclos por segundo, e assim não conseguimos ver a pintura da tela.
Usando a thread para separar os programa faz com que possamos ver
O metodo run() fica com a parte de pintura da tela. Ela comeca quando chamado pelo metodo start() e para atraves do metodo stop()

Assim, o inicio do jogo se dá a partir da instanciação de um objeto da classe *Game* em *Launch*.