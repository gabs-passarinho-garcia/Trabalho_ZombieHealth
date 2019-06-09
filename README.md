# TrabalhoZombieHealth - Os Matitos


## Entendendo o repositório
- Notebooks
  - Jupyter Notebooks para criação de protótipos [![Binder](https://mybinder.org/badge_logo.svg)](https://mybinder.org/v2/gh/batataazul/Trabalho_ZombieHealth/master?urlpath=lab)

- src
  - Projeto Eclipse
  
- Arquivos .jar
  - Componentes à venda =p
  - Os exemplos estão juntos >_<
  
## Integrantes
| **Nome** | **RA** |
|---|---|
| Christian Massao Konishi | 214570 |
| Matheus Fernandes Lopes | 222228 |
| Igor Kenzo Ishikawa Oshiro Nakashima | 217967 |
| Felipe Hideki Matoba | 196767 |
| Gabriel de Freitas Garcia | 216179 |
| Henrique Finger Zimerman | 217771 |


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
}
~~~

### Detalhamento da interface

#### Interface *IContador*
Interface que utilizada para analisar uma fonte de dados

| Método | Objetivo |
|---|---|
| int melhorPergunta(String[][] sintomas) | Retorna qual é o sintoma (int) mais eficiente para se perguntar |


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
| Classe | *zumbi.Componentes.Supervisor.* |
| Autores | Christian |
| Objetivo | Avaliar o desempenho do doutor nos diagnósticos |
| Interface | *zumbi.Interfaces.ISupervisor.* |

~~~
public interface ISupervisor {
	public void reportar(String diag, String doenca);
	public void gerarRelatorio();
	public String strRelatorio();
	public void motivar();
	public String strMotivar();
	public void serializar(String path);
	public void desserializar(String path);
	public double getAcuracia();
	public void reset();
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
| String strMotivar() | Retorna a frase motivacional |
| String strRelatorio() | Retorna o relatório como String |
| void serializar(String path) | Serializa o o Supervisor para a pasta indicada por path (diretório) |
| void desserializar(String path) | Desserializa o Supervisor serializado na pasta indicada por path |
| double getAcuracia() | Retorna a acurácia dos diagnósticos até então |
| void reset() | Reinicia todas as métricas |

### Componente *Interface Gráfica*

| Campo | Valor |
|---|---|
| Classe | *zumbi.Componentes.GUI.GUI* |
| Autores | Matheus |
| Objetivo | Apresentar uma interface gráfica interativa |
| Interface | *zumbi.Interfaces.IGUI.IGUI* |

~~~
public interface IGUI {
	public void open();
	void connectDoutor(Doctor doutor);
	void connectPaciente(Patient patient);
	void diagnostico();
}
~~~

### Detalhamento da interface

#### Interface *IGUI*
Interface Gráfica de Usuário

| Método | Objetivo |
|---|---|
| void open() | Gera a janela do programa na tela |


