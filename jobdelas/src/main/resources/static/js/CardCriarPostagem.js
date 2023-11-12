export const CardCriarPostagem = () => {
  return ` <div class="card-body">
    <img src="/img/iconfoto.png" alt="User" class="user-photo" />
    <h3>O que você está pensando?</h3>
    <button
      class="btn btn-primary"
      data-toggle="modal"
      data-target="#writePostModal"
    >
      Postar
    </button>
  </div>`;
};
