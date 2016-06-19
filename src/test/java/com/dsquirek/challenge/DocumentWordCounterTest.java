package com.dsquirek.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class DocumentWordCounterTest {

	@Test
	public void wordCountTest() {
		DocumentWordCounter reader = new DocumentWordCounter("file path");
		Map<String, Integer> words = reader
				.getwords("Hello world hello this is only only just a test, again this is only a test hello world");
		assertEquals(9, words.size());
		assertTrue(words.containsKey("a"));
		assertTrue(2 == words.get("a"));
		assertTrue(words.containsKey("test"));
		assertTrue(2 == words.get("test"));
		assertTrue(words.containsKey("again"));
		assertTrue(1 == words.get("again"));
		assertTrue(words.containsKey("this"));
		assertTrue(2 == words.get("this"));
		assertTrue(words.containsKey("is"));
		assertTrue(2 == words.get("is"));
		assertTrue(words.containsKey("world"));
		assertTrue(2 == words.get("world"));
		assertTrue(words.containsKey("only"));
		assertTrue(3 == words.get("only"));
		assertTrue(words.containsKey("hello"));
		assertTrue(3 == words.get("hello"));
		assertTrue(words.containsKey("just"));
		assertTrue(1 == words.get("just"));
	}

	@Test
	public void uniqueLastWordTest() {
		DocumentWordCounter reader = new DocumentWordCounter("file path");
		Map<String, Integer> words = reader.getwords("Hello world");
		assertEquals(2, words.size());
		assertTrue(words.containsKey("world"));
		assertTrue(1 == words.get("world"));
		assertTrue(words.containsKey("hello"));
		assertTrue(1 == words.get("hello"));
	}

	@Test
	public void sameLastWordTest() {
		DocumentWordCounter reader = new DocumentWordCounter("file path");
		Map<String, Integer> words = reader.getwords("Hello hello");
		assertEquals(1, words.size());
		assertTrue(words.containsKey("hello"));
		assertTrue(2 == words.get("hello"));
	}
}
