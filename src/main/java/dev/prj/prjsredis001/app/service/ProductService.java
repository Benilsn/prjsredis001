package dev.prj.prjsredis001.app.service;

import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.mapper.ProductMapper;
import dev.prj.prjsredis001.domain.model.Product;
import dev.prj.prjsredis001.infra.error.ProductNotFoundException;
import dev.prj.prjsredis001.infra.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
  public List<ProductDTO> getAllProducts() {
    List<Product> products = productRepository.findAll();

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

    productRepository.save(productToInsert);

    return productDTO;
  }


}
