package examples.validator.pm;

import java.util.StringTokenizer;

import org.springframework.util.StringUtils;

public class PathMatcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern="path/*/another/**"; 
		System.out.println(pattern);
		StringTokenizer st = new StringTokenizer(pattern, "*",true);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("Token::"+token);
		}
		String url="path/to/another/location/of/file";
		String[] tokens=StringUtils.tokenizeToStringArray(pattern, "/", false, true);
		 boolean startsWithPattern=startsWithPattern(pattern);
		final boolean endsWithPattern=endsWithPattern(pattern);
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
			String currentToken=tokens[i];
			String nextTokenToken=tokens[i];
			int ctIdx=url.indexOf(currentToken);
			int ntIdx=url.indexOf(nextTokenToken);
			String data=url.substring((ctIdx+currentToken.length()),ntIdx);
			System.out.println(data);
		}
	}
	
	 public static boolean isPattern(String pattern) {
	        return pattern.indexOf('*') > -1;
	    }
	    public static boolean endsWithPattern(String pattern) {
	        return pattern.endsWith("**")||pattern.endsWith("*");
	    }
	    
	    public static boolean startsWithPattern(String pattern) {
	        return pattern.startsWith("**")||pattern.startsWith("*");
	    }

}
