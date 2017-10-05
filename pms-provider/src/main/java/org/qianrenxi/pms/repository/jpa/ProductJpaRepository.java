package org.qianrenxi.pms.repository.jpa;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.Product;

@JaversSpringDataAuditable
public interface ProductJpaRepository extends SupportRepository<Product, Long> {

}
