package issue;
import static org.junit.Assert.assertEquals;
		import static org.junit.Assert.assertNotNull;

		import java.io.BufferedReader;
		import java.io.FileReader;
		import java.util.ArrayList;
		import java.util.List;
		import org.junit.Before;
		import org.junit.Test;


		public class IssueParserTest {
		    String string1;
		    
		    @Before
		    public void setUp() throws Exception {
		       StringBuilder s=new StringBuilder();
		    BufferedReader reader = new BufferedReader(new FileReader("C:\\github-repos\\githubapi-issues-VenkataHarshita\\Sample-output.txt"));
		       String line=reader.readLine();
		       while(line != null)
		       { 
		           s.append(line).append("\n"); 
		           line = reader.readLine();    
		       }
		       s.append(reader.readLine());
		        string1 = s.toString(); 
		        System.out.println(string1);
		        reader.close();
		    }
		    @Test
		    public void testparseIssues() 
		    {
		    	
		        IssueParser po=new IssueParser();
		        List<Issue> i = new ArrayList<Issue>();
		        Issue issue3=new Issue();
		       // Issue issue1= i.get(1);
		        
		        User u1=new User();
		        u1.setLogin("hi");
		        u1.setId(99);
		        
		        assertEquals(u1,issue3.getUser());
		        assertEquals(u1,issue3.getAssignee());
		        
		        
		        assertEquals(4, i.size());
		        
		        i=po.parseIssues(string1);
		        assertNotNull(i);
		        
		        Issue issue0 = i.get(0);
		        assertEquals(1,issue0.getId());
		        assertEquals(35545982,issue3.getId());
		        
		        
		        

		    }
		    
		


	}


