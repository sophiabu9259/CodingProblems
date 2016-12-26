package word_xxxx_series;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordPatternTest {
	
	WordPattern o = new WordPattern();
	
	@Test
	public void testWordPatternMatchII() {
		String pattern = "abab";
		String str = "plusminusplusminus";
		assertTrue (o.wordPatternMatchII(pattern, str));
	}
	
	@Test
	public void testWordPatternMatchII_1() {
		String pattern = "a";
		String str = "plusminusplusminus";
		assertTrue (o.wordPatternMatchII(pattern, str));
	}
	
	@Test
	public void testWordPatternMatchII_2() {
		String pattern = "abac";
		String str = "abaa";
		assertFalse (o.wordPatternMatchII(pattern, str));
	}
	
	@Test
	public void testWordPatternMatchII_3() {
		String pattern = "abc";
		String str = "plusminusplusk";
		assertTrue (o.wordPatternMatchII(pattern, str));
	}
	
	@Test
	public void testWordPatternMatchII_4() {
		String pattern = "aabb";
		String str = "xyzabcxzyabc";
		assertFalse (o.wordPatternMatchII(pattern, str));
	}

}
