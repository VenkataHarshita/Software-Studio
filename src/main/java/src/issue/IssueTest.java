package issue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

import org.junit.Test;

public class IssueTest {
	
	Issue issue1=new Issue();
	Issue issue2=new Issue();
	User u1=new User();
	User u2=new User();
	
	@Test
	public void testEquals()  {
		
		issue1.setId(76);
		issue2.setId(76);
		issue1.setState("true");
		issue1.setTitle("hi");
		issue1.setBody("welcome");
		issue1.setNumber(100);
		issue1.setUser(u1);
	issue1.setAssignee(u2);
	issue1.setClosedAt(null);
	issue1.setCreatedAt(null);
			
		
		u1.setLogin("hi");
		u1.setId(99);
		u2.setLogin("hi");
		
		assertTrue(issue1.equals(issue2));
		assertTrue(issue1.equals(issue1));
		assertTrue(issue1.hashCode()==issue2.hashCode());
		System.out.println(issue1.toString());
		assertEquals("Issue [number=0, id=76, state=null, title=null, body=null, createdAt=null, closedAt=null, user=null, assignee=null]",issue1.toString());
		System.out.println(issue1);
	}
		
		@Test
		public void testUserEquals(){
			assertTrue(u1.equals(u2));
		}
		@Test
		public void testUserHashcode() throws IOException{
			assertTrue(u1.hashCode()==u2.hashCode());
			IssuesExporter.main();
		}

		
		
		
		
		
		
}


