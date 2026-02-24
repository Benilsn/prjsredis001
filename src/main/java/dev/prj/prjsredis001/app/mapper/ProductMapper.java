package dev.prj.prjsredis001.app.mapper;

import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.domain.model.Product;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper  {
  ProductDTO toDto(Product product);
  List<ProductDTO> toDtoList(List<Product> products);
  Product toModel(ProductDTO product);

}