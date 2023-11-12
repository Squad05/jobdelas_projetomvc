import { CardInfoAprendizado } from "/js/CardInfoAprendizado.js";
import { Navbar } from "/js/Navbar.js";

const header = document.querySelector("header");
header.innerHTML = Navbar();

const cardInfoAprendizado = document.querySelector(".container-aprendizado");
cardInfoAprendizado.innerHTML = CardInfoAprendizado();
