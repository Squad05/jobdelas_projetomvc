export const ListaTarefas = () => {
  return `<div class="lista_tarefas">
    <h3>Lista de Tarefas</h3>

    <div class="tarefa">
      <div class="titulo-tarefa">Reunião com Equipe</div>
      <div class="descricao-tarefa">
        Preparar agenda para a reunião.
      </div>
      <div class="botoes-tarefa">
        <button class="concluir-tarefa">
          <i class="fa fa-check"></i> Concluir
        </button>
        <button class="atualizar-tarefa">
          <i class="fa fa-edit"></i> Atualizar
        </button>
      </div>
    </div>

    <div class="tarefa">
      <div class="titulo-tarefa">Projeto X</div>
      <div class="descricao-tarefa">
        Revisar código e fazer melhorias.
      </div>
    </div>

    <button
      id="btnAdicionarTarefa"
      class="botao_criarpostagem"
      data-toggle="modal"
      data-target="#tarefaModal"
    >
      Adicionar Tarefa
    </button>
  </div>`;
};
