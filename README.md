# Escalonadores

Criação de um escalonador com a utilização dos algoritmos: First In, First Out (FIFO), Shortest Job First (SJF), Priority Scheduling (PS) e Round Robin (RR) para a disciplina de Sistemas Operacionais - S4 BCC IFCE.

## Como usar

```console
git clone https://github.com/Jphn/Escalonadores.git
```

## IDE

O projeto foi inteiramente constuido utilizando o [NetBeans 22](https://netbeans.apache.org/front/main/index.html), mas deve funcionar com as demais IDEs Java (Eclipse, IntelliJ e *VSCode*).


## Compilação

Até o momento da escrita desta documentação, ainda não foi possível compilar e disponibilizar um `.jar` do projeto, mas quando possível estará disponível na aba de [releases](https://github.com/Jphn/Escalonadores/releases) do GitHub.


## Políticas de Escalonamento

- **[First In, First Out (FIFO)](https://pt.wikipedia.org/wiki/FIFO)**: Os processos são adicionados em uma fila, onde o primeiro processo a entrar é o primeiro a ser executado.

- **[Shortest Job First (SJF)](https://pt.wikipedia.org/wiki/Shortest_job_first)**: Executa o processo com menor tempo de execução.

- **[Priority Scheduling (PS)](https://www.guru99.com/priority-scheduling-program.html)**: Executa um processo com base em uma hierarquia de prioridade, onde o processo com maior prioridade é processado primeiro.

- **[Round Robin (RR)](https://pt.wikipedia.org/wiki/Round-robin)**: Os processos são organizados em uma fila circular e são executados durante determinado período de tempo constante chamado de quantum. Não há prioridade nesse algoritmo.


## Métricas de Desempnho

- Tempo de espera
- Tempo de turnaround
- Tempo médio de espera
- Tempo médio de turnaround
- Utilização de CPU
- Utilização de memória

## Tecnologias

<div style="display: flex; justify-content: center;">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=black)

[![GitHub](https://img.shields.io/badge/GitHub-000?style=for-the-badge&logo=github&logoColor=30A3DC)](https://docs.github.com/)

[![Git](https://img.shields.io/badge/Git-000?style=for-the-badge&logo=git&logoColor=E94D5F)](https://git-scm.com/doc) 

</div>

<div align="center">

Feito por [João Pedro](https://github.com/Jphn), [Natan](https://github.com/natanpedrosateixeira), [Lucas](https://github.com/Lusca-F) e [Bira](https://github.com/Ubiracyauri).

</div>
