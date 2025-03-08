package com.FileTextConverter.TextConverter.textService;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service

public class fileServiceImpl implements fileServices {

	/**
	 * Processes the file content and sorts words within each sentence, then formats
	 * the result as XML File. read the file and made the split as per requirement
	 * used XML builder to build the file in required format and returned the final
	 * content in XLM /CSV format
	 */

	@Override
	public String processFiletoXML(Reader reader) {
		BufferedReader bufferedReader = new BufferedReader(reader);
		String content = bufferedReader.lines().collect(Collectors.joining("\n"));

		// Split the content into sentences
		List<String> sentences = Arrays.asList(content.split("(?<=[.!?])\\s*"));

		// Process each sentence
		StringBuilder xmlBuilder = new StringBuilder("<text>\n");
		for (String sentence : sentences) {
			// Split the sentence into words
			List<String> words = Arrays.asList(sentence.split("\\s+"));

			// Sorting the words by their first character
			words.sort((w1, w2) -> Character.compare(Character.toLowerCase(w1.charAt(0)),
					Character.toLowerCase(w2.charAt(0))));

			// Wrap each word in <word> tag and joined them with new lines
			xmlBuilder.append("<sentence>\n");

			for (String word : words) {
				xmlBuilder.append("<word>").append(word).append("</word>\n");
			}
			xmlBuilder.append("</sentence>\n");
		}
		xmlBuilder.append("</text>");

		return xmlBuilder.toString();
	}

	@Override
	public String processFileToCSV(Reader reader) {
		BufferedReader bufferedReader = new BufferedReader(reader);
		String content = bufferedReader.lines().collect(Collectors.joining("\n"));

		// Split the content into sentences
		List<String> sentences = Arrays.asList(content.split("(?<=[.!?])\\s*"));

		// Process each sentence
		StringBuilder csvBuilder = new StringBuilder();
		int sentenceCount = 1;
		for (String sentence : sentences) {
			// Split the sentence into words
			List<String> words = Arrays.asList(sentence.split("\\s+"));

			// Sort the words by their first character
			words.sort((w1, w2) -> Character.compare(Character.toLowerCase(w1.charAt(0)),
					Character.toLowerCase(w2.charAt(0))));

			// Format the desired sentence as CSV
			csvBuilder.append("Sentence ").append(sentenceCount).append(", ");
			csvBuilder.append(String.join(", ", words)).append("\n");
			sentenceCount++;
		}
		return csvBuilder.toString();
	}
}
