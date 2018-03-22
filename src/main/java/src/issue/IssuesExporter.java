package issue;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IssuesExporter {

	public static void main(String[] args) throws IOException {

		IssuesExporter i = new IssuesExporter();
		i.generateIssues();
	}

	public void generateIssues() throws IOException {
		PrintWriter o = new PrintWriter(new FileWriter("Issues.txt"));

		System.out.println("Enter your username: ");
		Scanner scanner1 = new Scanner(System.in);
		String username = scanner1.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner1.nextLine();
		GitHubRestClient client = new GitHubRestClient();

		String json = client.requestIssues(username, password, "open");
		String json1 = client.requestIssues(username, password, "closed");

		IssueParser parser = new IssueParser();

		List<Issue> closedissues = parser.parseIssues(json1);
		List<Issue> openissues = parser.parseIssues(json);
		openissues.addAll(closedissues);
		Collections.sort(openissues);

		for (Issue issue : openissues) {
			o.println(issue);
		}

		System.out.println("the size is" + openissues.size());
		o.close();

	}
}
