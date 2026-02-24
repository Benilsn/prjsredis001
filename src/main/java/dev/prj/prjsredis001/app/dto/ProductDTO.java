package dev.prj.prjsredis001.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Schema(name = "ProductDTO", description = "Represents a product returned by the API")
public class ProductDTO {

  @Schema(description = "Product name", example = "Gaming Laptop RTX 4070")
  @NotBlank(message = "Name is required")
  @Size(max = 150, message = "Name must have at most 150 characters")
  private String name;

  @Schema(description = "Detailed description of the product",
    example = "High performance gaming laptop with 16GB RAM and 1TB SSD")
  @Size(max = 1000, message = "Description must have at most 1000 characters")
  private String description;

  @Schema(description = "Final selling price", example = "7499.90")
  @NotNull(message = "Price is required")
  @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
  @Digits(integer = 12, fraction = 2, message = "Price must have up to 2 decimal places")
  private BigDecimal price;

  @Schema(description = "Price paid", example = "5499.90")
  @NotNull(message = "Cost price is required")
  @DecimalMin(value = "0.0", inclusive = false, message = "Cost Price must be greater than zero")
  @Digits(integer = 12, fraction = 2, message = "Cost Price must have up to 2 decimal places")
  private BigDecimal costPrice;

  @Schema(description = "Available quantity in stock", example = "25")
  @NotNull(message = "Stock quantity is required")
  @Min(value = 0, message = "Stock quantity cannot be negative")
  private Integer stockQuantity;

  @Schema(description = "Indicates if the product is active and available for sale", example = "true")
  @NotNull(message = "Active flag is required")
  private Boolean active;

  @Schema(description = "Average customer rating (0.0 to 5.0)", example = "4.7")
  @DecimalMin(value = "0.0", message = "Rating cannot be negative")
  @DecimalMax(value = "5.0", message = "Rating cannot be greater than 5")
  private Double rating;

  @Schema(description = "Total number of reviews", example = "134")
  @Min(value = 0, message = "Review count cannot be negative")
  private Integer reviewCount;

  @Schema(description = "Stock Keeping Unit identifier", example = "LAP-RTX4070-16GB")
  @NotBlank(message = "SKU is required")
  @Size(max = 100, message = "SKU must have at most 100 characters")
  private String sku;

  @Schema(description = "Product brand name", example = "Asus")
  @NotBlank(message = "Brand is required")
  @Size(max = 100)
  private String brand;

  @Schema(description = "Product category", example = "Electronics")
  @NotBlank(message = "Category is required")
  @Size(max = 100)
  private String category;

  @Schema(description = "Tags associated with the product",
    example = "[\"gaming\", \"laptop\", \"ssd\"]")
  private Set<
    @NotBlank(message = "Tag cannot be blank")
    @Size(max = 50, message = "Tag must have at most 50 characters")
      String> tags;

  @Schema(
    description = "Product weight in kilograms (kg)",
    example = "2.35",
    minimum = "0.0"
  )
  @DecimalMin(value = "0.0", message = "Weight cannot be negative")
  private Double weight;

  @Schema(
    description = "Product height in centimeters (cm)",
    example = "4.2",
    minimum = "0.0"
  )
  @DecimalMin(value = "0.0", message = "Height cannot be negative")
  private Double height;

  @Schema(
    description = "Product width in centimeters (cm)",
    example = "12.8",
    minimum = "0.0"
  )
  @DecimalMin(value = "0.0", message = "Width cannot be negative")
  private Double width;

  @Schema(
    description = "Product length in centimeters (cm)",
    example = "35.0",
    minimum = "0.0"
  )
  @DecimalMin(value = "0.0", message = "Length cannot be negative")
  private Double length;

}
