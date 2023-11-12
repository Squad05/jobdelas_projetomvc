export const Modaleditar = () => {
  return ` 
        <!-- Cabeçalho do Modal -->
        <div class="modal-header">
          <h4 class="modal-title">Perfil</h4>
          <button type="button" class="close" data-dismiss="modal">
            &times;
          </button>
        </div>

        <!-- Corpo do Modal -->
        <div class="modal-body">
          <form
            method="PUT"
            class="formulario"
            th:object="${usuario}"
            enctype="multipart/form-data"
          >
            <div class="form-group">
              <label for="imageUpload">Anexar Foto de Perfil:</label>
              <input
                type="file"
                class="form-control-file"
                id="imageUpload"
              />
            </div>
            <div class="form-group">
              <label for="nome">Nome:</label>
              <input type="text" class="form-control" id="nome" required />
            </div>

            <div class="form-group">
              <label for="email">Email:</label>
              <input type="text" class="form-control" id="email" required />
            </div>

            <div class="form-group">
              <label for="senha">Senha:</label>
              <input
                type="password"
                class="form-control"
                id="senha"
                required
              />
            </div>

            <div class="form-group">
              <label for="resumo">Resumo:</label>
              <textarea class="form-control" id="resumo"></textarea>
            </div>

            <div class="form-group">
              <label for="telefone">Telefone:</label>
              <input
                type="text"
                class="form-control"
                id="telefone"
                required
              />
            </div>

            <div class="form-group">
              <label for="portfolio">Link para o Portfólio:</label>
              <input type="text" class="form-control" id="portfolio" />
            </div>
          </form>
        </div>

        <!-- Rodapé do Modal -->
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-primary"
            data-dismiss="modal"
          >
            Fechar
          </button>
          <button type="submit" class="btn btn-primary">Atualizar</button>
        </div>
`;
};
