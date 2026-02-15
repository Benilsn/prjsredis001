package dev.prj.prjsredis001.infra.controller;

import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(path = "/products")
@Tag(name = "Products", description = "Operations related to products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Operation(
    summary = "List all products",
    description = "Returns a list of all products available in the system"
  )
  @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ProductDTO>> listProducts() {
    List<ProductDTO> products = productService.getAllProducts();

    return ResponseEntity.ok().body(products);
  }

}
