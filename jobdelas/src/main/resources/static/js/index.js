import { Navbar } from "/js/Navbar.js";
import { Modaleditar } from "/js/Modaleditar.js";

const header = document.querySelector("header");
header.innerHTML = Navbar();

const modal = document.querySelector(".teste");
modal.innerHTML = Modaleditar();
