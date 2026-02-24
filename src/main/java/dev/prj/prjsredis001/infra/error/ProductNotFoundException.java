package dev.prj.prjsredis001.infra.error;

public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException() {
    super("Product not found in the system!");
  }

}
