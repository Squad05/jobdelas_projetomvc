export const ProfileBodySobre = () => {
  return `<div class="profile_infos">
    <h2 class="titulo_profile">Sobre</h2>
    <p>Adicione uma bio personalizada aqui.</p>
  </div>
  <div class="profile_botao">
    <button
      type="button"
      class="btn btn-primary botao_profile"
      data-toggle="modal"
      data-target="#sobreModal"
    >
      Adicionar
      <i class="fas fa-pencil-alt"></i>
    </button>
  </div>`;
};
