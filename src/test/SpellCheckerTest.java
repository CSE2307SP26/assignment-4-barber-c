package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class SpellCheckerTest {
	private SpellChecker checker;

	@Before
	public void setup() {
		checker = new SpellChecker();
	}

	@Test
	public void testKnownWords() {
		//1. Construct objects to be tested
		// handled by setup

		//2. Call method being tested
		int words = checker.getNumberOFWords();
		
		//3. Use assertion to verify results
		assertEquals(0, words);
	}

	@Test
	public void testWordIncrement() {
		checker.addWord("Hello");
		into words = checker.getNumberOFWords();
		assertEquals(1, words);
	}

	@Test
	public void testDuplicateWords() {
		checker.addWord("Hello");
		checker.addWord("Hello");
		into words = checker.getNumberOFWords();
		assertEquals(1, words);
	}

	@Test
	public void testSpelledCorrectly() {
		//spellCheck method returns 1 if properly spelled, 0 otherwise
		checker.addWord("Hello");
		int spelledCorrectly = checker.spellCheck("Hello");
		assertEquals(1, spelledCorrectly);
	}

	@Test
	public void testMisspelled() {
		checker.addWord("Hello");
		int spelledCorrectly = checker.spellCheck("Hallo");
		assertEquals(0, spelledCorrectly);
	}

	@Test
	public void testIgnoreCase() {
		checker.addWord("Hello");
		int spelledCorrectly = checker.spellCheck("hElLo");
		assertEquals(1, spelledCorrectly);
	}

	@Test
	public void testSuggestionMisspelled() {
		checker.addWord("Apple");
		checker.addWord("Banana");
		checker.addWord("Hello");
		String suggestion = checker.suggestWord("Hallo");
		assertEquals("Hello", suggestion);
	}
	@Test
	public void testSuggestionKnown() {
		checker.addWord("Apple");
		checker.addWord("Banana");
		checker.addWord("Hello");
		String suggestion = checker.suggestWord("Apple");
		assertEquals("Apple", suggestion);
	}

	@Test
	public void testStrictCaseFalse() {
		checker.addWord("Hello");
		int spelledCorrectly = checker.spellCheckCase("hElLo");
		assertEquals(0, spelledCorrectly);	
	}

	@Test
	public void testStrictCaseTrue() {
		checker.addWord("Hello");
		int spelledCorrectly = checker.spellCheckCase("Hello");
		assertEquals(1, spelledCorrectly);	
	}

	@Test
	public void testAddWords() {
		String[] words = {"Hello", "World"};
		checker.addWords(words);
		int numWords = checker.getNumberOFWords();
		assertEquals(2, numWords);
	}

}
