package issue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class IssueTest {

	Issue i1 = new Issue();
	Issue i2 = new Issue();
	User u1 = new User();
	User u2 = new User();
	
	@Before
	public void Set() throws Exception {

		u1.setId(50);
		u2.setId(50);
		u1.setLogin("harshita");
		u2.setLogin("hyma");

		i1.setId(6);
		i1.setNumber(5);
		i1.setState("open");
		i1.setBody("hello");
		i1.setCreatedAt("");
		i1.setClosedAt("");
		i1.setUser(u1);
		i1.setAssignee(u2);
		i1.setTitle("welcome");

		i2.setId(6);
		i2.setNumber(5);
		i2.setState("open");
		i2.setBody("hello");
		i2.setCreatedAt("");
		i2.setClosedAt("");
		i2.setUser(u2);
		i2.setAssignee(u1);
		i2.setTitle("welcome");

	}

	@Test
	public void testEquals() {
		assertTrue(i1.equals(i2));
	}

	@Test
	public void testHashCode() {
		assertTrue(i1.hashCode() == i2.hashCode());
	}

	@Test
	public void testUserEquals() {
		assertTrue(u1.equals(u2));
	}

	@Test
	public void testUserHashcode() throws IOException {
		assertTrue(u1.hashCode() == u2.hashCode());
		
	}

	@Test
	public void testToString() {

		assertEquals(
				"Issue [number=5, id=6, state=open, title=welcome, body=hello, createdAt=, closedAt=, user=User [login=harshita, id=50], assignee=User [login=hyma, id=50]]",
				i1.toString());

	}

	@Test
	public void testEqualsTo() {

		i1.setId(42);
		i2.setId(42);
		assertEquals(0, i1.compareTo(i2));
		assertTrue(i1.equals(i2));

	}

	@Test
	public void testGreater() {
		i1.setId(47);
		i2.setId(42);
		assertEquals(1, i1.compareTo(i2));

	}

	@Test
	public void testLessThan() {

		i1.setId(38);
		i2.setId(42);
		assertEquals(-1, i1.compareTo(i2));

	}

}
