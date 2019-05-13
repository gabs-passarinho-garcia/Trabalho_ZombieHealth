# TrabalhoZombieHealth - Os Matitos


## Entendendo o repositório
- Notebooks
  - Jupyter Notebooks para criação de protótipos [![Binder](https://mybinder.org/badge_logo.svg)](https://mybinder.org/v2/gh/batataazul/Trabalho_ZombieHealth/master?urlpath=lab)

- src
  - Projeto Eclipse

## Documentação dos componentes

### Componente *MelhorPergunta*

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


### Componente RedutorPossibilidades

| Campo | Valor |
|---|---|
| Classe | *zumbi.Componentes.RedutorPossibilidades.RedutorPossibilidades* |
| Autores | Felipe |
| Objetivo | Remover da matriz os pacientes incompatíveis com a resposta |
| Interface | *zumbi.Interfaces.IRedutorPossibilidades.IRedutorPossibilidades* |

~~~
public interface IRedutorPossibilidades {
	public String[][] novaTabela(String[][] tabela, int sintoma, String resposta);
}
~~~

### Detalhamento da interface

#### Interface *IRedutorPossibilidades*
Interface de tratamento de dados

| Método | Objetivo |
|---|---|
| public String[][] novaTabela(String[][] tabela, int sintoma, String resposta) | Recebe o sintoma e remove da tabela os pacientes que não condizem com a resposta obtida, retornando uma tabela atualizada |


### Componente *Supervisor*

| Campo | Valor |
|---|---|
| Classe | *zumbi.Componentes.Supervisor.Supervisor* |
| Autores | Christian |
| Objetivo | Avaliar o desempenho do doutor nos diagnósticos |
| Interface | *zumbi.Interfaces.ISupervisor.ISupervisor* |

~~~
public interface ISupervisor {
	public void reportar(String diag, String doenca);
	public void gerarRelatorio();
	public void motivar();
}
~~~

### Detalhamento da interface

#### Interface *ISupervior*
Interface que utilizada para analisar uma fonte de dados

| Método | Objetivo |
|---|---|
| void reportar(String diag, String doenca) | Informa o supervisor do diagnóstico feito pelo doutor e da real doença do zumbi |
| void gerarRelatorio() | Imprime métricas de acurácia, precisão, sensibilidade, especifidade e *F1 score* dos diagnósticos reportados |
| void motivar() | Imprime uma mensagem motivacional para o doutor que está cansado de ficar de plantão e não vê mais sentido na vida |




