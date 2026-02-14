package dev.prj.prjsredis001.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Schema(name = "ProductDTO", description = "Represents a product returned by the API")
public class ProductDTO {

  @Schema(description = "Unique product identifier (UUID)", example = "a3f1c9b2-7e4d-4a5b-9c2d-123456789abc")
  private String id;

  @Schema(description = "Product name", example = "Gaming Laptop RTX 4070")
  private String name;

  @Schema(description = "Detailed description of the product", example = "High performance gaming laptop with 16GB RAM and 1TB SSD")
  private String description;

  @Schema(description = "Final selling price", example = "7499.90")
  private BigDecimal price;

  @Schema(description = "Available quantity in stock", example = "25")
  private Integer stockQuantity;

  @Schema(description = "Indicates if the product is active and available for sale", example = "true")
  private Boolean active;

  @Schema(description = "Average customer rating (0.0 to 5.0)", example = "4.7")
  private Double rating;

  @Schema(description = "Total number of reviews", example = "134")
  private Integer reviewCount;

  @Schema(description = "Stock Keeping Unit identifier", example = "LAP-RTX4070-16GB")
  private String sku;

  @Schema(description = "Product brand name", example = "Asus")
  private String brand;

  @Schema(description = "Product category", example = "Electronics")
  private String category;

  @Schema(description = "Tags associated with the product", example = "[\"gaming\", \"laptop\", \"ssd\"]")
  private Set<String> tags;

  @Schema(description = "Date and time when the product was created", example = "2025-02-14T10:15:30")
  private LocalDateTime createdAt;

}