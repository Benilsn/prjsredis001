package dev.prj.prjsredis001.infra.error;

public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException() {
    final String DEFAULT_MESSAGE = "Product not found in the system!";
    throw new RuntimeException(DEFAULT_MESSAGE);
  }

}
