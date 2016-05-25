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

	public Map<Integer, String> numberOfWordsInDocument() {
		return getwords(readFile(path));
	}

	public Map<Integer, String> getwords(String doc) {
		return countWords(scrubPuctutation(Arrays.asList(doc.toLowerCase().split(" "))));
	}

	public List<String> scrubPuctutation(List<String> words) {
		return words.stream().map(x -> x.replaceAll(",", "")).collect(Collectors.toList());
	}

	public Map<Integer, String> countWords(List<String> words) {
		Map<Integer, String> wordMap = new HashMap<>();
		Set<String> wordSet = new HashSet<String>(words);
		wordSet.forEach(x -> {
			wordMap.put(Collections.frequency(words, x), x);
		});
		return wordMap;
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
