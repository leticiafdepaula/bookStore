package com.leticia.bookStore.resource;

import com.leticia.bookStore.domain.Category;
import com.leticia.bookStore.dtos.CategoryDto;
import com.leticia.bookStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category obj = categoryService.findById (id);
        return ResponseEntity.ok ().body (obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> List = categoryService.findAll ();
        List<CategoryDto> ListDTO = List.stream ().map (obj -> new CategoryDto(obj)).collect (Collectors.toList ());
        return ResponseEntity.ok (ListDTO);
    }

    @PostMapping
    public ResponseEntity<Category> create(@Validated @RequestBody Category obj) {
        obj = categoryService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri ().path ("/{id}")
        .buildAndExpand (obj.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Integer id, @RequestBody CategoryDto objDto) {
       Category newObj = categoryService.create (id, objDto);
       return ResponseEntity.ok ().body (new CategoryDto (newObj));
    }
@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id ) {
         categoryService.delete(id);
         return ResponseEntity.noContent ().build ();
}

}

