// package com.squad05.jobdelas.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.ui.Model; // Importação correta
// import org.springframework.validation.BindingResult;

// import com.squad05.jobdelas.model.Tarefas;
// import com.squad05.jobdelas.repository.TarefasRepository;

// @Controller
// @RequestMapping("/")
// public class TarefasController {

// @Autowired
// private TarefasRepository tarefasRepository;

// @GetMapping("tarefa")
// public String suaPagina(Model model) {
// model.addAttribute("tarefa", new Tarefas());
// return "jobdelas";
// }

// @PostMapping("tarefa")
// public String tarefa(@ModelAttribute("tarefa") Tarefas tarefa) {
// tarefasRepository.save(tarefa);
// return "redirect:/jobdelas";
// }

// }
