export const Curso = (curso) => {
  return `
    <div class="card-curso">
      <h3><i class="fas fa-graduation-cap"></i> Título do Curso 1</h3>
      <p>
        <i class="fas fa-book"></i> Matéria: ${curso.materia}
      </p>
      <p>
        <i class="far fa-clock"></i> Duração: ${curso.duracao}
      </p>
      <button>
        <i class="fas fa-play"></i> <a href="/curso">Learn </a>
      </button>
    </div>
  `;
};
