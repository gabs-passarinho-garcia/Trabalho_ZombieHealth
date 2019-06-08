package teste;
//Pacotes necessários
import zumbi.Classes.MelhorFactory.*;
import zumbi.Classes.ContaSuperFactory.*;
import zumbi.Interfaces.IContaFactory.*;
import zumbi.Interfaces.IContador.*;
import zumbi.Componentes.ContaMetade;

public class TesteMelhorPergunta{
  public static void main(String[] args) {
    //criação de fábrica de melhor pergunta
    IContaFactory fabrica = ContaSuperFactory.criaFabrica();
    //Criação de componente
    IContador componente = fabrica.criaMelhorPergunta();
    //Exemplo de utilização
    //Matriz de sintomas com true para se o sintoma existe, false se não existe
    String[][] matriz = {{"t","f","t","f"},{"t","f","f","f"},{"t","t","f","f"},{"t","t","f","f"}};
    int pos_melhorPergunta;
    //Retorna um inteiro com a posição da melhor pergunta
    pos_melhorPergunta = componente.melhorPergunta(matriz);

  }
}
