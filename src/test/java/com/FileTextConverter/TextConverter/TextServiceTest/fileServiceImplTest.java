package com.FileTextConverter.TextConverter.TextServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

import com.FileTextConverter.TextConverter.textService.fileServiceImpl;
import com.FileTextConverter.TextConverter.textService.fileServices;

public class fileServiceImplTest {
	private fileServices fileServices = new fileServiceImpl();

	@Test
	public void testProcessFileToXML() {
		// Given
		String input = "What	he  shouted was shocking:  停在那儿, 你这肮脏的掠夺者!";
		StringReader reader = new StringReader(input);
		String expectedOutput = "<text>\n" + "<sentence>\n" + "<word>he</word>\n" + "<word>shouted</word>\n"
				+ "<word>shocking:</word>\n" + "<word>What</word>\n" + "<word>was</word>\n" + "<word>你这肮脏的掠夺者!</word>\n"
				+ "<word>停在那儿,</word>\n" + "</sentence>\n" + "</text>";
		// When
		String actualOutput = fileServices.processFiletoXML(reader);
		// Then
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testProcessFileToXMLWithEmptyInput() {
		// Given
		String input = " ";
		StringReader reader = new StringReader(input);
		String expectedOutput = "<text>\n" + "<sentence>\n" + "</sentence>\n" + "</text>";
		// When
		String actualOutput = fileServices.processFiletoXML(reader);
		// Then
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testProcessFileToCSV() {
		// Given
		String input = "Mary   had a little  lamb ";
		StringReader reader = new StringReader(input);
		String expectedOutput = "Sentence 1, a, had, little, lamb, Mary\n";
		// When
		String actualOutput = fileServices.processFileToCSV(reader);
		// Then
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testProcessFileToCSVWithEmptyInput() {
		// Given
		String input = "";
		StringReader reader = new StringReader(input);
		String expectedOutput = "Sentence 1, \n";
		// When
		String actualOutput = fileServices.processFileToCSV(reader);
		// Then
		assertEquals(expectedOutput, actualOutput);
	}
}
