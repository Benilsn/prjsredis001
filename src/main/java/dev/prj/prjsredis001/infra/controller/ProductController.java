package dev.prj.prjsredis001.infra.controller;

import dev.prj.prjsredis001.app.dto.ParcialProductDTO;
import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.service.ProductService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Products", description = "Operations related to products")
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Operation(
    summary = "List all products",
    description = "Returns a list of all products available in the system"
  )
  @RateLimiter(name = "productsRead", fallbackMethod = "rateLimitFallback")
  @GetMapping(path = "/")
  public ResponseEntity<List<ProductDTO>> listProducts(@RequestParam(name = "includeDeleted", defaultValue = "false") boolean includeDeleted) {
    List<ProductDTO> products = productService.getAllProducts(includeDeleted);

    return ResponseEntity.ok().body(products);
  }

  @Operation(
    summary = "Find a specific product",
    description = "Returns the requested product if available."
  )
  @RateLimiter(name = "productsRead", fallbackMethod = "rateLimitFallback")
  @GetMapping(path = "/{productId}")
  public ResponseEntity<ProductDTO> findProduct(@PathVariable UUID productId) {
    ProductDTO product = productService.findProduct(productId);

    return ResponseEntity.ok().body(product);
  }

  @Operation(
    summary = "Insert a product",
    description = "Insert a product into database."
  )
  @RateLimiter(name = "productsWrite", fallbackMethod = "rateLimitFallback")
  @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductDTO product) {
    return ResponseEntity.ok().body(productService.insertOne(product));
  }

  @Operation(
    summary = "Update any information for a product",
    description = "Update a product."
  )
  @RateLimiter(name = "productsWrite", fallbackMethod = "rateLimitFallback")
  @PutMapping(path = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDTO> updateProduct(@PathVariable UUID productId, @Valid @RequestBody ParcialProductDTO product) {
    return ResponseEntity.ok(productService.updateOne(productId, product));
  }

  @Operation(
    summary = "Delete a product",
    description = "Soft/Hard delete a product from database."
  )
  @RateLimiter(name = "productsWrite", fallbackMethod = "rateLimitFallback")
  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId, @RequestParam(name = "hardDelete", defaultValue = "false") boolean hardDelete) {
    productService.deleteOne(productId, hardDelete);
    return ResponseEntity.noContent().build();
  }

  private ResponseEntity<ProductDTO> rateLimitFallback(ProductDTO product, RequestNotPermitted ex) {
    return ResponseEntity.status(429).build();
  }

}
