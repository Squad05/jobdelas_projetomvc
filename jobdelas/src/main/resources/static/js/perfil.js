import { Navbar } from "/js/Navbar.js";
import { ProfileBodySobre } from "/js/ProfileBodySobre.js";
import { ProfileBodyEducacao } from "/js/ProfileBodyEducacao.js";

const header = document.querySelector("header");
header.innerHTML = Navbar();

const profileSobre = document.querySelector(".profile_sobre");
profileSobre.innerHTML = ProfileBodySobre();

const profileEducacao = document.querySelector(".profile_educacao");
profileEducacao.innerHTML = ProfileBodyEducacao();
