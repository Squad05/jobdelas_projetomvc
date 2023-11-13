export const ProfileBodyEducacao = () => {
  return `<div class="container_titulo_profile">
    <h2 class="titulo_profile">Educação</h2>

    <button
      type="button"
      class="btn btn-primary botao_profile"
      data-toggle="modal"
      data-target="#educacaoModal"
    >
      Adicionar
      <i class="fas fa-pencil-alt"></i>
    </button>
  </div>
  <div class="lista_cardeducacao">
    <div class="card_educacao">
      <ul>
        <li>
          <h3><i class="fas fa-university"></i> Nome da instituição</h3>
          <p><strong>Curso:</strong> Nome do curso</p>
          <p>
            <strong>Ano de Conclusão:</strong>
            YYYY
          </p>
        </li>
      </ul>
      <button class="btn-excluir-educacao">
        Excluir
        <i class="fas fa-trash-alt"></i>
      </button>
    </div>
    <div class="card_educacao">
      <ul>
        <li>
          <h3><i class="fas fa-university"></i> Nome da instituição</h3>
          <p><strong>Curso:</strong> Nome do curso</p>
          <p>
            <strong>Ano de Conclusão:</strong>
            YYYY
          </p>
        </li>
      </ul>
      <button class="btn-excluir-educacao">
        Excluir
        <i class="fas fa-trash-alt"></i>
      </button>
    </div>
    <div class="card_educacao">
      <ul>
        <li>
          <h3><i class="fas fa-university"></i> Nome da instituição</h3>
          <p><strong>Curso:</strong> Nome do curso</p>
          <p>
            <strong>Ano de Conclusão:</strong>
            YYYY
          </p>
        </li>
      </ul>
      <button class="btn-excluir-educacao">
        Excluir
        <i class="fas fa-trash-alt"></i>
      </button>
    </div>
  </div>`;
};
