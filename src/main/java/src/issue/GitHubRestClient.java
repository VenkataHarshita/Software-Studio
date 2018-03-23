package issue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GitHubRestClient {

	private static String BASE_URI = "/repos/SoftwareStudioSpring2018/githubapi-issues-VenkataHarshita/issues";

	public static void main(String[] args) {
		GitHubRestClient prototype = new GitHubRestClient();
		// IMPORTANT: don't commit your username and password to your repo!!!
		String json = prototype.requestIssues("VenkataHarshita", "K0mandur1", "open");
		System.out.println(json);
	}

	public String requestIssues(String username, String password, String state) {
		String jsonContent = null;
		String s = null;
		if (state.equals("open")) {
			s = BASE_URI + "?state=open";
		} else if (state.equals("closed")) {
			s = BASE_URI + "?state=closed";
		}

		HttpHost target = new HttpHost("api.github.com", 443, "https");
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(target.getHostName(), target.getPort()),
				new UsernamePasswordCredentials(username, password));

		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();

		AuthCache authCache = new BasicAuthCache();
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(target, basicAuth);

		HttpClientContext localContext = HttpClientContext.create();
		localContext.setAuthCache(authCache);

		// TODO adjust the URI to match your repo name
		HttpGet httpget = new HttpGet(s);
		try {
			CloseableHttpResponse response = httpclient.execute(target, httpget, localContext);
			System.out.println(response.getStatusLine());
			// TODO check for status 200 before proceeding

			HttpEntity entity = response.getEntity();

			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));

			jsonContent = reader.readLine();

			EntityUtils.consume(entity);
		} catch (ClientProtocolException e) {
			// TODO properly handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO properly handle exception
			e.printStackTrace();
		} finally {
			// TODO close all resources
		}
		return jsonContent;
	}

}
