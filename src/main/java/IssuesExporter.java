

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

		String jsonOpenIssue = client.requestIssues(username, password, "open");
		String jsonClosedIssue = client.requestIssues(username, password, "closed");

		IssueParser parser = new IssueParser();

		List<Issue> closedIssues = parser.parseIssues(jsonClosedIssue);
		List<Issue> openIssues = parser.parseIssues(jsonOpenIssue);
		openIssues.addAll(closedIssues);
		Collections.sort(openIssues);

		for (Issue issue : openIssues) {
			o.println(issue);
		}

		System.out.println("the size is :" + openIssues.size());
		o.close();

	}
}
