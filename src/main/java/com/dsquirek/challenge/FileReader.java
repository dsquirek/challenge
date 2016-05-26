package com.dsquirek.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FileReader {
	private String path;
	
	public FileReader(String path){
		this.path = path;
	}

	public void numberOfWordsInDocument() {
		getwords(readFile(path));
	}

	public void getwords(String doc) {
		countWords(scrubPuctutation(Arrays.asList(doc.toLowerCase().split(" "))));
	}

	public List<String> scrubPuctutation(List<String> words) {
		return words.stream().map(x -> x.replaceAll(",", "")).collect(Collectors.toList());
	}

	public void countWords(List<String> words) {
		Set<String> wordSet = new HashSet<String>(words);
		wordSet.forEach(x -> {
			System.out.println("word " + x + " appears " + Collections.frequency(words, x) + " times");
		});
	}

	public String readFile(String path) {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(path))))) {
			StringBuilder sb = new StringBuilder();
			String str;
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			return sb.toString();
		} catch (IOException e) {
			return null;
		}
	}

}
