package issue;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IssuesExporter {

	public static void main(String[] args) throws IOException {

		PrintWriter o = new PrintWriter(new FileWriter("Issues.txt"));

		System.out.println("Enter your username: ");
		Scanner scanner1 = new Scanner(System.in);
		String username = scanner1.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner1.nextLine();

		o.println(username);
		o.println(password);
		GitHubRestClient client = new GitHubRestClient();
		String json = client.requestIssues(username, password);

		IssueParser parser = new IssueParser();
		List<Issue> issues = parser.parseIssues(json);

		o.println(issues);

		System.out.println("the size is" + issues.size());
		o.close();

	}
}
