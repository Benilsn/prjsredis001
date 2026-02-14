package dev.prj.prjsredis001.infra.controller;

import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(name = "/v1/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(name = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ProductDTO>> listProducts() {
    List<ProductDTO> products = productService.getAllProducts();

    return ResponseEntity.ok().body(products);
  }

}
