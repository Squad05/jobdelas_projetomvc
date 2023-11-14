import { CardInfoAprendizado } from "/js/CardInfoAprendizado.js";
import { Navbar } from "/js/Navbar.js";
// import { Curso } from "/js/Curso.js";

const header = document.querySelector("header");
header.innerHTML = Navbar();

const cardInfoAprendizado = document.querySelector(".container-aprendizado");
cardInfoAprendizado.innerHTML = CardInfoAprendizado();

// const cursosHTML = dadosDosCursos.map(curso => Curso(curso)).join('');

const curso = document.querySelector(".container-cursos");
curso.innerHTML = Curso();
