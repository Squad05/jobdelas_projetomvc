export const Navbar = () => {
  return `
    <nav class="nav">
      <ul>
        <li class="caixa-item-navbar">
          <a href="/jobdelas">
            <div><i class="fa-solid fa-house icone_nav"></i> Início</div>
          </a>
        </li>
        <li class="caixa-item-navbar">
          <a href="/vagas">
            <div><i class="fa fa-briefcase icone_nav"></i> Vagas</div>
          </a>
        </li>
        <li class="caixa-item-navbar">
          <a href="/mensagens">
            <div><i class="fa fa-envelope icone_nav"></i> Chat</div>
          </a>
        </li>
        <li class="caixa-item-navbar">
          <a href="/cursos">
            <div><i class="fa fa-graduation-cap icone_nav"></i> Cursos</div>
          </a>
        </li>
      </ul>
    </nav>
    <img src="/img/logoRoxa.png" class="logo_jobdelas" alt="logo do jobdelas" />
    <div class="search_bar">
      <input type="text" placeholder="Pesquisar" class="pesquisar_header"/>
      <i class="fa fa-search"></i>
      <button class="botao-perfil" data-toggle="modal" data-target="#editarModal">
        <img src="/img/iconfoto.png" class="img_perfil" alt="Imagem no Botão" />
      </button>
    </div>
  `;
};
