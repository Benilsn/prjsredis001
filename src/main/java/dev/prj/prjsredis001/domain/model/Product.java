package dev.prj.prjsredis001.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, length = 150)
  private String name;

  @Column(length = 500)
  private String description;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(name = "cost_price", nullable = false)
  private BigDecimal costPrice;

  @Column(name="stock_quantity", nullable=false)
  private Integer stockQuantity;

  @Column(nullable = false)
  private Boolean active;

  @Column(nullable = false)
  private Double rating;

  @Column(name = "review_count", nullable = false)
  private Integer reviewCount;

  @Column(nullable = false)
  private String sku;

  @Column(nullable = false)
  private String brand;

  @Column(nullable = false)
  private String category;

  @ElementCollection
  @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
  @Column(name = "tag", nullable = false)
  private Set<String> tags;

  private Double weight;

  private Double height;

  private Double width;

  private Double length;

  @Column(name="created_at", nullable=false)
  private LocalDateTime createdAt;

  @Column(name="updated_at", nullable=false)
  private LocalDateTime updatedAt;

  @Column(name="deleted_at")
  private LocalDateTime deletedAt;

}
