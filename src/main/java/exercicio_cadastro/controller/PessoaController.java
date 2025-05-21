package exercicio_cadastro.controller;


import exercicio_cadastro.service.PessoaService;
import exercicio_cadastro.model.PessoaModel;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class PessoaController {

    private final PessoaService cadastroservice;


    @GetMapping("/cadastro/new") //formulario de criação
    public String cadastro(Model model) {
        model.addAttribute("pessoa", new PessoaModel());
        return "formulario";
    }

    @PostMapping("/cadastro/new") // Processa o formulário de criação
    public String cadastrarPessoa(@ModelAttribute PessoaModel pessoa, RedirectAttributes redirectAttributes) {
        cadastroservice.salvarPessoa(pessoa); // Salva a pessoa no banco
        redirectAttributes.addFlashAttribute("msg", "Salvo com sucesso!"); // Mensagem de sucesso
        return "redirect:/cadastro"; // Redireciona para a listagem
    }

    @GetMapping("/cadastro") //listar todos os cadastros
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView(("listagem"));
        modelAndView.addObject("pessoas", cadastroservice.findAll());
        return modelAndView;
    }

    @GetMapping("/cadastro/{id}") //exibe os detalhes do usuario para a edição do cadastro
    public ModelAndView editar(@PathVariable long id){
        PessoaModel pessoa = cadastroservice.findById(id);
        ModelAndView modelAndView = new ModelAndView("edicao");
        modelAndView.addObject("pessoa", pessoa);
        return modelAndView;
    }

    @PostMapping("/cadastro/{id}") //processa o formulario de edição
    public String editarPessoa(@ModelAttribute PessoaModel pessoa, RedirectAttributes redirectAttributes) {
        cadastroservice.salvarPessoa(pessoa);
        redirectAttributes.addFlashAttribute("msg", "Cadastro atualizado com sucesso!");
        return "redirect:/cadastro";
    }

    @DeleteMapping("/cadastro/{id}")
    public String deletarPessoa(@PathVariable long id, RedirectAttributes redirectAttributes) {
        cadastroservice.deletarPessoa(id);
        redirectAttributes.addFlashAttribute("msg", "Cadastro deletado com sucesso!");
        return "redirect:/cadastro";
    }

}
