package br.com.academia.resource.rest;

import br.com.academia.domain.Produto;
import br.com.academia.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "/produtos",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class ProdutoRestController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listar(){
        return service.findAll();
    }

}
