import { ProfileHeader } from "/js/ProfileHeader.js";
import { Navbar } from "/js/Navbar.js";
import { ProfileBodySobre } from "/js/ProfileBodySobre.js";
import { ProfileBodyEducacao } from "/js/ProfileBodyEducacao.js";

const header = document.querySelector("header");
header.innerHTML = Navbar();

const profileHeader = document.querySelector(".profile_header");
profileHeader.innerHTML = ProfileHeader();

const profileSobre = document.querySelector(".profile_sobre");
profileSobre.innerHTML = ProfileBodySobre();

const profileEducacao = document.querySelector(".profile_educacao");
profileEducacao.innerHTML = ProfileBodyEducacao();
