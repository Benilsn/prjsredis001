package dev.prj.prjsredis001.infra.repository;

import dev.prj.prjsredis001.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> { }
