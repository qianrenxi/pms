package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.Document;
import org.qianrenxi.pms.repository.jpa.DocumentJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentService extends BaseService<Document, Long, DocumentJpaRepository> {

}
