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
| Classe | *zumbi.Componentes.Contador* |
| Autores | Gabriel |
| Objetivo | Encontrar a melhor pergunta |
| Interface | IContador |

~~~
public interface IContador {
	public int melhorPergunta(String[][] sintomas);
	public int[] melhoresPerguntas(String[][] sintomas);
}
~~~

### Detalhamento da interface

#### Interface *IContador*
