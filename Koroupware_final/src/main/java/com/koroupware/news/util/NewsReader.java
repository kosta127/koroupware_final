package com.koroupware.news.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NewsReader {
	//뉴스읽어옴
	public static String newsReader(String urlStr, String charset){
		BufferedReader br = null;
		URL url = null;
		URLConnection uc = null;
		InputStream is = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			url = new URL(urlStr);
			uc = url.openConnection();
			is = uc.getInputStream();
			br = new BufferedReader(
					new InputStreamReader(is, charset));
			String rl = "";
			while((rl = br.readLine()) != null){
				sb.append(rl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				is.close();
			} catch (Exception e2) {}
		}
		return sb.toString();
	}
}
