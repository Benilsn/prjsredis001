package dev.prj.prjsredis001.app.service;

import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.app.mapper.ProductMapper;
import dev.prj.prjsredis001.domain.model.Product;
import dev.prj.prjsredis001.infra.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public List<ProductDTO> getAllProducts() {
    List<Product> products = productRepository.findAll();

    return ProductMapper.INSTANCE.toDtoList(products);
  }


}
