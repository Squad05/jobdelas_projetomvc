export const CardCriarPostagem = () => {
  const cardCriarPostagem = document.querySelector(".cardCriarPostagem");
  const nomeUsuario = cardCriarPostagem.getAttribute("data-nome-usuario");

  // Verifique se o nome do usuário está disponível e exiba-o no componente
  const mensagem = nomeUsuario
    ? `O que você está pensando, ${nomeUsuario}?`
    : "O que você está pensando?";

  return ` <div class="card-body">
      <img src="/img/iconfoto.png" alt="User" class="user-photo" />
      <h3>${mensagem}</h3>
      <button
          class="btn btn-primary"
          data-toggle="modal"
          data-target="#writePostModal"
      >
          Postar
      </button>
  </div>`;
};
