export const ProfileBodySobre = () => {
  return `
  <div class="container_titulo_profile">
  <h2 class="titulo_profile">Sobre</h2>

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
  <div> <p>Adicione uma bio personalizada aqui.</p> </div>
`;
};
