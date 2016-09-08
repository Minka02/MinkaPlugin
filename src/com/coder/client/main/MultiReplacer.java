package com.coder.client.main;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class MultiReplacer {

	public String replaceAllTokens(Map<String, String> tokens, String desing) {
		String patternString = "%("+StringUtils.join(tokens.keySet(), "|")+")%";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(desing);
		StringBuffer sb = new StringBuffer();
		while(matcher.find()) {
			matcher.appendReplacement(sb, tokens.get(matcher.group(1)));
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
}
