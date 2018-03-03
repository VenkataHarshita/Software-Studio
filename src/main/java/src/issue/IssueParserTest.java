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
        	BufferedReader reader = new BufferedReader(new FileReader("C:\\github-repos\\githubapi-issues-VenkataHarshita\\Sample-output.txt"));

            while ((output = reader.readLine()) != null) {
                str_output += output;
            }
            System.out.println(str_output);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
    } 

    @Test
    public void testparseIssues() {
        IssueParser issue_parser = new IssueParser();
        List<Issue> is = issue_parser.parseIssues(str_output);
        Issue issue1 = new Issue();
        User u1 = new User();
        
        assertEquals(0,issue1.getId());
        assertEquals(3, is.size());

        
        u1.setLogin("hi");
        u1.setId(1);

       

    }

}