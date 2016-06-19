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

public class DocumentWordCounter {
	private String path;

	public DocumentWordCounter(String path) {
		this.path = path;
	}

	public void numberOfWordsInDocument() {
		getwords(readFile(path));
	}

	public Map<String, Integer> getwords(String doc) {
		countWords(scrubPuctutation(Arrays.asList(doc.toLowerCase().split(" "))));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return countWordsNoFrequency(scrubPuctutation(Arrays.asList(doc.toLowerCase().split(" "))));
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

	public Map<String, Integer> countWordsNoFrequency(List<String> words) {
		Collections.sort(words);
		Map<String, Integer> wordData = new HashMap<>();
		for (int i = 0; i < words.size(); i++) {
			String str = words.get(i);
			int count = 1;
			for (int j = i + 1; j < words.size(); j++) {
				if (str.equals(words.get(j))) {
					count++;
				} else {
					i = j - 1;
					break;
				}
			}
			if (!wordData.containsKey(str)) {
				System.out.println("word " + str + " appears " + count + " times");
				wordData.put(str, count);
			}
		}
		return wordData;
	}

	public String readFile(String path) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))))) {
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
