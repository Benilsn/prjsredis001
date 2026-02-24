package dev.prj.prjsredis001.app.service;

import dev.prj.prjsredis001.app.dto.ParcialProductDTO;
import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.mapper.ProductMapper;
import dev.prj.prjsredis001.domain.model.Product;
import dev.prj.prjsredis001.infra.error.ProductNotFoundException;
import dev.prj.prjsredis001.infra.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Transactional(readOnly = true)
  public List<ProductDTO> getAllProducts(boolean includeDeleted) {
    List<Product> products = includeDeleted
      ? productRepository.findAll()
      : productRepository.findByDeletedAtIsNull();

    return productMapper.toDtoList(products);
  }

  @Cacheable(
    cacheNames = "products",
    key = "#productId",
    unless = "#result == null"
  )
  @Transactional(readOnly = true)
  public ProductDTO findProduct(UUID productId) {
    Optional<Product> product = productRepository.findById(productId);

    return
      product
        .map(productMapper::toDto)
        .orElseThrow(ProductNotFoundException::new);
  }


  public ProductDTO insertOne(ProductDTO productDTO) {
    Product productToInsert = productMapper.toModel(productDTO);

    LocalDateTime now = LocalDateTime.now();
    productToInsert.setCreatedAt(now);
    productToInsert.setUpdatedAt(now);

    productRepository.save(productToInsert);

    return productDTO;
  }

  @CacheEvict(
    cacheNames = "products",
    key = "#productId"
  )
  @Transactional
  public ProductDTO updateOne(UUID productId, ParcialProductDTO dto) {
    Product existing =
      productRepository
        .findById(productId)
        .orElseThrow(ProductNotFoundException::new);

    productMapper.updateProductFromDto(dto, existing);

    existing.setUpdatedAt(LocalDateTime.now());

    Product saved = productRepository.save(existing);
    return productMapper.toDto(saved);
  }


  @CacheEvict(
    cacheNames = "products",
    key = "#productId"
  )
  @Transactional
  public void deleteOne(UUID productId, boolean hardDelete) {
    Product product =
      productRepository
        .findById(productId)
        .orElseThrow(ProductNotFoundException::new);

    if (hardDelete) productRepository.delete(product);
    else {
      product.setDeletedAt(LocalDateTime.now());
      product.setActive(false);
      product.setUpdatedAt(LocalDateTime.now());

      productRepository.save(product);
    }
  }


}
