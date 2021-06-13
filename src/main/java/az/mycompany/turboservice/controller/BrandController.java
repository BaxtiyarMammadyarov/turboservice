package az.mycompany.turboservice.controller;

import az.mycompany.turboservice.dto.BrandDto;
import az.mycompany.turboservice.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping
    public ResponseEntity<?>creare(@RequestBody  BrandDto dto){
        System.out.println(dto);
        return brandService.create(dto);
    }
    @GetMapping
    public ResponseEntity<?>get(){
        return brandService.get();
    }
}
