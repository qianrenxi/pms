package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.DocLib;
import org.qianrenxi.pms.repository.jpa.DocLibJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DocLibService extends BaseService<DocLib, Long, DocLibJpaRepository> {

}
