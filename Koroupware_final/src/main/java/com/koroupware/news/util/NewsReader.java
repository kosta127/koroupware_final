package com.koroupware.news.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NewsReader {
	//뉴스읽어옴
	public static String newsReader(String urlStr){
		BufferedReader br = null;
		URL url = null;
		InputStream is = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(urlStr);
			is = url.openStream();
			br = new BufferedReader(
					new InputStreamReader(is, "UTF-8"));
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
		System.out.println(sb);
		return sb.toString();
	}
}
