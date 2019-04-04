package registro;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import es.curso.registro.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class ApplicationTest {

	
	private EmbeddedDatabase db;
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setup() {
		
		db = new EmbeddedDatabaseBuilder()
        		.setType(EmbeddedDatabaseType.H2)
        		.addScript("create-db.sql")
        		.addScript("insert-data.sql")
        		.build();
	}

}
