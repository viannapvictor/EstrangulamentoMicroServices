package br.com.ebac.memelandia.controllers;

import br.com.ebac.memelandia.entities.Meme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.ebac.memelandia.services.ServicoMemelandia;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class ControllerMemelandia {
    @Autowired
    private ServicoMemelandia servicoMemelandia;

    @GetMapping("/memes")
    public List<Meme> buscaMemes() {
        return servicoMemelandia.listaTodosMemes();
    }

    @PostMapping("/memes")
    public Meme novoMeme(@RequestBody Meme meme) {
        return servicoMemelandia.novoMeme(meme);
    }
}
