package br.com.academia.resource.rest;

import br.com.academia.domain.Produto;
import br.com.academia.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping( value = "/produtos" )
public class ProdutoRestController {

    @Autowired
    private ProdutoService service;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto editarProduto(@PathVariable("id") Long id, @RequestBody Produto produto){
        service.update(id, produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProduto(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto getProduto(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Produto produto){

        service.save(produto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listar(){
        return service.findAll();
    }

}
