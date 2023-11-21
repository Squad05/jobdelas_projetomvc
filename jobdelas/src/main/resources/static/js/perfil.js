import { Navbar } from "/js/Navbar.js";
import { ProfileBodyEducacao } from "/js/ProfileBodyEducacao.js";

const header = document.querySelector("header");
header.innerHTML = Navbar();


const profileEducacao = document.querySelector(".profile_educacao");
profileEducacao.innerHTML = ProfileBodyEducacao();
