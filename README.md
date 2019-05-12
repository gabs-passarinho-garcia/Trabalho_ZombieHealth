# TrabalhoZombieHealth - Os Matitos


## Entendendo o repositório
- Notebooks
  - Jupyter Notebooks para criação de protótipos

- src
  - Projeto Eclipse

## Documentação dos componentes

### Componente MelhorPergunta

| Campo | Valor |
|---|---|
| Classe | *zumbi.Componentes.Contador.Contador* |
| Autores | Gabriel |
| Objetivo | Encontrar a melhor pergunta |
| Interface | *zumbi.Interfaces.IContador.IContador* |

~~~
public interface IContador {
	public int melhorPergunta(String[][] sintomas);
	public int[] melhoresPerguntas(String[][] sintomas);
}
~~~

### Detalhamento da interface

#### Interface *IContador*
Interface que utilizada para analisar uma fonte de dados

| Método | Objetivo |
|---|---|
| int melhorPergunta(String[][] sintomas) | Retorna qual é o sintoma (int) mais eficiente para se perguntar |
| int[] melhoresPerguntas(String[][] sintomas) | Retorna um vetor contendo, em ordem, os sintomas de maior interesse a se perguntar |
