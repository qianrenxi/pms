package org.qianrenxi.pms.javers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.javers.core.Javers;
import org.javers.core.changelog.SimpleTextChangeLog;
import org.javers.core.diff.Change;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.repository.jql.QueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qianrenxi.pms.entity.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JaversTests {

	@Autowired
	Javers javers;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void shouldListChangeHistory() {
		// given:
        // commit some changes
		Requirement requirement = new Requirement();
		requirement.setId(4L);
		requirement.setName("Javers demo");
		javers.commit("author", requirement);
		
		requirement.setName("Javers simple demo");
		javers.commit("author", requirement);
		
		requirement.setName("Javers simple example");
		javers.commit("author", requirement);
		
		// when:
        // list change history
		List<Change> changes = javers.findChanges(
	            QueryBuilder.byInstanceId(4L, Requirement.class).build());
		
		// then:
        // there should be tow ValueChange with "requirement" name
		// assertThat(changes).hasSize(2);
		ValueChange change = (ValueChange) changes.get(0);
		/*assertThat(change.getPropertyName()).isEqualTo("name");
        assertThat(change.getLeft()).isEqualTo("Javers demo");
        assertThat(change.getRight()).isEqualTo("Javers simple demo");*/
		
		String changeLog = javers.processChangeList(changes, new SimpleTextChangeLog());
		System.out.println(changeLog);
		
	}
}
