package dev.prj.prjsredis001.app.service;

import dev.prj.prjsredis001.app.dto.ParcialProductDTO;
import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.mapper.ProductMapper;
import dev.prj.prjsredis001.domain.model.Product;
import dev.prj.prjsredis001.infra.error.ProductNotFoundException;
import dev.prj.prjsredis001.infra.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @Mock ProductRepository productRepository;
  @Mock ProductMapper productMapper;

  @InjectMocks ProductService productService;

  private Product product;
  private ProductDTO dto;

  @BeforeEach
  void setup() {
    product = new Product();
    product.setId(UUID.randomUUID());
    product.setName("Keyboard");
    product.setPrice(new BigDecimal("100.00"));
    product.setCostPrice(new BigDecimal("70.00"));
    product.setStockQuantity(10);
    product.setActive(true);
    product.setRating(4.5);
    product.setReviewCount(2);
    product.setSku("SKU-1");
    product.setBrand("Brand");
    product.setCategory("Hardware");
    product.setCreatedAt(LocalDateTime.now().minusDays(1));
    product.setUpdatedAt(LocalDateTime.now().minusDays(1));

    dto = new ProductDTO();
    dto.setName("Keyboard");
    dto.setPrice(new BigDecimal("100.00"));
    dto.setCostPrice(new BigDecimal("70.00"));
    dto.setStockQuantity(10);
    dto.setActive(true);
    dto.setRating(4.5);
    dto.setReviewCount(2);
    dto.setSku("SKU-1");
    dto.setBrand("Brand");
    dto.setCategory("Hardware");
  }

  @Test
  void getAllProducts_includeDeletedFalse_shouldQueryOnlyNotDeleted() {
    when(productRepository.findByDeletedAtIsNull()).thenReturn(List.of(product));
    when(productMapper.toDtoList(anyList())).thenReturn(List.of(dto));

    List<ProductDTO> result = productService.getAllProducts(false);

    assertThat(result).hasSize(1);
    verify(productRepository).findByDeletedAtIsNull();
    verify(productRepository, never()).findAll();
  }

  @Test
  void getAllProducts_includeDeletedTrue_shouldQueryAll() {
    when(productRepository.findAll()).thenReturn(List.of(product));
    when(productMapper.toDtoList(anyList())).thenReturn(List.of(dto));

    List<ProductDTO> result = productService.getAllProducts(true);

    assertThat(result).hasSize(1);
    verify(productRepository).findAll();
    verify(productRepository, never()).findByDeletedAtIsNull();
  }

  @Test
  void findProduct_whenExists_shouldReturnDto() {
    when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
    when(productMapper.toDto(product)).thenReturn(dto);

    ProductDTO result = productService.findProduct(product.getId());

    assertThat(result.getName()).isEqualTo("Keyboard");
  }

  @Test
  void findProduct_whenMissing_shouldThrow() {
    UUID id = UUID.randomUUID();
    when(productRepository.findById(id)).thenReturn(Optional.empty());

    assertThatThrownBy(() -> productService.findProduct(id))
      .isInstanceOf(ProductNotFoundException.class);
  }

  @Test
  void insertOne_shouldSetCreatedAtAndUpdatedAt_andSave() {
    Product mapped = new Product();
    when(productMapper.toModel(dto)).thenReturn(mapped);

    productService.insertOne(dto);

    assertThat(mapped.getCreatedAt()).isNotNull();
    assertThat(mapped.getUpdatedAt()).isNotNull();
    verify(productRepository).save(mapped);
  }

  @Test
  void updateOne_shouldApplyNonNullFields_updateUpdatedAt_andSave() {
    UUID id = product.getId();
    ParcialProductDTO partial = new ParcialProductDTO();
    partial.setName("New Name");

    when(productRepository.findById(id)).thenReturn(Optional.of(product));
    doAnswer(invocation -> {
      Product entity = invocation.getArgument(1);
      entity.setName(partial.getName());
      return null;
    }).when(productMapper).updateProductFromDto(any(), any());

    Product saved = product;
    when(productRepository.save(any(Product.class))).thenReturn(saved);
    when(productMapper.toDto(saved)).thenReturn(dto);

    ProductDTO result = productService.updateOne(id, partial);

    assertThat(product.getName()).isEqualTo("New Name");
    assertThat(product.getUpdatedAt()).isNotNull();
    verify(productRepository).save(product);
    assertThat(result).isNotNull();
  }

  @Test
  void deleteOne_softDelete_shouldSetDeletedAt_andDisable() {
    UUID id = product.getId();
    when(productRepository.findById(id)).thenReturn(Optional.of(product));

    productService.deleteOne(id, false);

    assertThat(product.getDeletedAt()).isNotNull();
    assertThat(product.getActive()).isFalse();
    assertThat(product.getUpdatedAt()).isNotNull();
    verify(productRepository).save(product);
    verify(productRepository, never()).delete(any());
  }

  @Test
  void deleteOne_hardDelete_shouldDelete() {
    UUID id = product.getId();
    when(productRepository.findById(id)).thenReturn(Optional.of(product));

    productService.deleteOne(id, true);

    verify(productRepository).delete(product);
    verify(productRepository, never()).save(any());
  }
}