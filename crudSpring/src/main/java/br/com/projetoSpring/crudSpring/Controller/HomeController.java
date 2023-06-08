package br.com.projetoSpring.crudSpring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoSpring.crudSpring.ModelFilme.DadosFilmes;
import br.com.projetoSpring.crudSpring.ModelFilme.Filme;
import br.com.projetoSpring.crudSpring.ModelFilme.FilmeRepository;

@Controller
@RequestMapping("/Home")
public class HomeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregaForms(Long id,Model model) {
        if (id != null) {
            var filme= repository.getReferenceById(id);
            model.addAttribute("filme", filme);
        } return "Home/formulario";
    }

    @GetMapping
    public String carregaList(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "Home/listagem";
    }

    @PostMapping
    public String cadastroFilme(DadosFilmes dados) {
        var filme = new Filme(dados);
        repository.save(filme);
    
        return "redirect:/Home";
    }

    @PutMapping
    @Transactional
    public String editarFilme(DadosAlteraFilme dados) {
        
        var filme= repository.getReferenceById(dados.id()); 
        filme.atualizadados(dados);

        return "redirect:/Home";
    }
    
    @DeleteMapping
    @Transactional
    public String removeFilme(Long id){
        repository.deleteById(id);
        return "redirect:/Home";
    }
}
