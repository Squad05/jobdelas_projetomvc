export const Navbar = () => {
  return `
    <nav class="nav">
      <ul >
        <li class="caixa-item-navbar">
          <a href="jobdelas">
            <div><i class="fa-solid fa-house icone_nav"></i> Início</div>
          </a>
        </li>
        <li class="caixa-item-navbar">
          <a href="vagas">
            <div><i class="fa fa-briefcase icone_nav"></i> Vagas</div>
          </a>
        </li>
        <li class="caixa-item-navbar">
          <a href="/mensagens">
            <div><i class="fa fa-envelope icone_nav"></i> Chat</div>
          </a>
        </li>
        <li class="caixa-item-navbar">
          <a href="cursos">
            <div><i class="fa fa-graduation-cap icone_nav"></i> Cursos</div>
          </a>
        </li>
      </ul>
    </nav>
    <img src="/img/logoRoxa.png" class="logo_jobdelas" alt="logo do jobdelas" />
    <div class="search_bar">
      <input type="text" placeholder="Pesquisar" class="pesquisar_header"/>
      <i class="fa fa-search"></i>
      
      <div class="dropdown perfil-dropdown">
        
<button class="botao-perfil" "navbar-toggler" data-bs-toggle="collapse" id="dropdownMenuButton" data-toggle="dropdown" "dropdown-menu"aria-haspopup="true" aria-expanded="false">
          <img src="/img/iconfoto.png" class="img_perfil" alt="Imagem no Botão" />
        </button>
        <div class="dropdown-menu dropdown-menu-right perfil-dropdown-menu" aria-labelledby="dropdownMenuButton">
          <a class="dropdown-item" data-toggle="modal" data-target="#editarModal">Editar Perfil</a>
          <a class="dropdown-item" href="#">Sair da Conta</a>
          <a class="dropdown-item" href="#">Perfil</a>
        </div>
      </div>
    </div>

<<<<<<< Updated upstream

   
=======
    <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    Dropdown
  </button>
  <ul class="dropdown-menu">
    <li><button class="dropdown-item" type="button">Action</button></li>
    <li><button class="dropdown-item" type="button">Another action</button></li>
    <li><button class="dropdown-item" type="button">Something else here</button></li>
  </ul>
</div>
  
    
>>>>>>> Stashed changes
  `;
};
