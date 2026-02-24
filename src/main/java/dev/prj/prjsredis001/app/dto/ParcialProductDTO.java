package dev.prj.prjsredis001.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Schema(name = "ProductDTO", description = "Represents a product returned by the API")
public class ParcialProductDTO {

  private String name;
  private String description;
  private BigDecimal price;
  private BigDecimal costPrice;
  private Integer stockQuantity;
  private Boolean active;
  private Double rating;
  private Integer reviewCount;
  private String sku;
  private String brand;
  private String category;
  private Set<String> tags;
  private Double weight;
  private Double height;
  private Double width;
  private Double length;

}
