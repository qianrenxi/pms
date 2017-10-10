package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.TestSuiteCaseRef;
import org.qianrenxi.pms.entity.TestSuiteCaseRefPK;
import org.qianrenxi.pms.repository.jpa.TestSuiteCaseRefJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteCaseRefService
		extends BaseService<TestSuiteCaseRef, TestSuiteCaseRefPK, TestSuiteCaseRefJpaRepository> {

}
