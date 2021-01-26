package examples.validator.pm;

import org.springframework.util.StringUtils;

public class TokenProcessor {

	final String[] tokens;
	int i = -1;
	String previousToken="";

	public TokenProcessor(String pattern) {
		tokens = StringUtils.tokenizeToStringArray(pattern, "/", false, true);
	}

	public String currentToken() {
		String currentToken=null;
		do {
			if(!hasMoreTokens()) {
				break;
			}
			currentToken=tokens[++i];
		}while(isPattern(currentToken));
		//System.out.println("Token::"+currentToken+" isPattern"+isPattern(currentToken) );
		if(!isPattern(currentToken)) {
			previousToken=currentToken;
		}
		return currentToken;
	}

	public String nextToken() {
		String nextToken=null;
		do {
			if(!hasMoreTokens()) {
				break;
			}
			nextToken=tokens[++i];
		}while(isPattern(nextToken));
		//System.out.println("NToken::"+nextToken+" isPattern"+isPattern(nextToken) );
		if(!isPattern(nextToken)) {
			previousToken=nextToken;
		}
		
		return nextToken;
	}
	
	public String previousToken() {
		return previousToken;
	}
	
	public boolean hasMoreTokens() {
		return i<tokens.length-1;
	}
	public boolean isEndToken() {
		return i==tokens.length-1;
	}
	
	public boolean isPattern(String token) {
		return token.indexOf("*") > -1;
	}
	
    public boolean endsWithPattern() {
    	int endIndx=tokens.length-1;
        return tokens[endIndx].endsWith("**")||tokens[endIndx].endsWith("*");
    }
    
    public boolean startsWithPattern() {
        return tokens[0].startsWith("**")||tokens[0].startsWith("*");
    }
}
