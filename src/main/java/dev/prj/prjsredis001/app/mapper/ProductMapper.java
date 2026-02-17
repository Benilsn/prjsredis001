package dev.prj.prjsredis001.app.mapper;

import dev.prj.prjsredis001.app.dto.ProductDTO;
import dev.prj.prjsredis001.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  ProductDTO toDto(Product product);

  List<ProductDTO> toDtoList(List<Product> products);

  Product toModel(ProductDTO product);

}