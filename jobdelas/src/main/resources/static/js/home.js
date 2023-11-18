import { ListaTarefas } from "/js/ListaTarefas.js";
// import { CardCriarPostagem } from "/js/CardCriarPostagem.js";
import { Navbar } from "/js/Navbar.js";
// import { Post } from "/js/Post.js";

const listaTarefas = document.querySelector(".lateral_home");
listaTarefas.innerHTML = ListaTarefas();

// const cardCriarPostagem = document.querySelector(".cardCriarPostagem");
// cardCriarPostagem.innerHTML = CardCriarPostagem();

const header = document.querySelector("header");
header.innerHTML = Navbar();

// const posts = document.querySelector(".feed");
// posts.innerHTML = Post();
