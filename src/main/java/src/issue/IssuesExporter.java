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
        
        
        //IssueExporter obj=new IssueExporter();
        System.out.println("Enter your username: ");
        Scanner scanner1 = new Scanner(System.in);
        String username = scanner1.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner1.nextLine();
        
        o.println(username);
        o.println(password);
        
        
        Issue i1 = new Issue();
        Issue i2 = new Issue();
        Issue i3 = new Issue();
        i1.id=5;
        i1.state="open";
        
        
        
        List<Issue> one= new ArrayList<Issue>();
        one.add(i1);
        one.add(i2);
        one.add(i3);
        o.println(one);
        
        System.out.println(one.size());
        o.close();        
        // TODO Auto-generated method stub
        scanner1.close();
    }

}

