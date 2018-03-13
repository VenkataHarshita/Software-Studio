package issue;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IssueParserTest {
	public String output = "";
	public String str_output = "";

	@Before
	public void setUp() throws Exception {

		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("C:\\github-repos\\githubapi-issues-VenkataHarshita\\Sample-output.txt"));

			while ((output = reader.readLine()) != null) {
				str_output += output;
			}
			System.out.println(str_output);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void testparseIssues() {
		IssueParser issue_parser = new IssueParser();
		List<Issue> is = issue_parser.parseIssues(str_output);
		Issue issue1 = new Issue();
		User u1 = new User();

		issue1 = is.get(1);

		assertEquals(295014116, issue1.getId());
		assertEquals(3, is.size());

		u1.setLogin("VenkataHarshita");
		u1.setId(35545982);

		assertEquals(35545982, u1.getId());
		assertEquals("open", issue1.getState());
		assertEquals(u1, issue1.getUser());
		assertEquals("This is my Second issue creation", issue1.getBody());
		assertEquals("second issue", issue1.getTitle());

	}

}