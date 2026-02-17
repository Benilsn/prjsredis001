package dev.prj.prjsredis001.infra.controller;

import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
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
  @GetMapping(path = "/")
  public ResponseEntity<List<ProductDTO>> listProducts() {
    List<ProductDTO> products = productService.getAllProducts();

    return ResponseEntity.ok().body(products);
  }

  @Operation(
    summary = "Find a specific product",
    description = "Returns the requested product if available."
  )
  @GetMapping(path = "/{productId}")
  public ResponseEntity<ProductDTO> findProduct(@PathVariable UUID productId) {
    ProductDTO product = productService.findProduct(productId);

    return ResponseEntity.ok().body(product);
  }

  @Operation(
    summary = "Insert a product",
    description = "Insert a product into the system."
  )
  @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductDTO product) {
    return ResponseEntity.ok().body(productService.insertOne(product));
  }


}
