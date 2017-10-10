package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.TestResult;
import org.qianrenxi.pms.repository.jpa.TestResultJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TestResultService extends BaseService<TestResult, Long, TestResultJpaRepository> {

}
