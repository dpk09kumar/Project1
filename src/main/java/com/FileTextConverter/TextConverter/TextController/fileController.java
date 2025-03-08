package com.FileTextConverter.TextConverter.TextController;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.FileTextConverter.TextConverter.textService.fileServices;

@RestController
@RequestMapping("/api")
@ResponseBody
public class fileController {

	@Autowired
	private fileServices fileServices;

	/**
	 * Endpoint to handle uploaded file and produce output in XML format
	 * 
	 * @Requestparam output/Input FilePath to save the file FileReader to read and
	 *               write the file
	 * @return a ResponseEntity with the status of the file processed with the
	 *         output file location
	 */

	// Endpoint to handle uploaded file and produce output in XML format
	@PostMapping("/toXML")
	public ResponseEntity<String> uploadFile(@RequestParam("inputFilePath") String inputFilePath,
			@RequestParam("outputFilePath") String outputFilePath) throws IOException {
		try (FileReader fileReader = new FileReader(new File(inputFilePath));
				FileWriter fileWriter = new FileWriter(new File(outputFilePath))) {

			// Process the file content using the service
			String sortedContent = fileServices.processFiletoXML(fileReader);

			// Write the sorted content to the output file
			fileWriter.write(sortedContent);

			return new ResponseEntity<>("File processed successfully to XML. Output saved to: " + outputFilePath,
					HttpStatus.OK);
		}
	}

	/**
	 * Endpoint to handle uploaded file and produce output in CSV format
	 * 
	 * @Requestparam output/Input FilePath to save the file FileReader to read and
	 *               write the file
	 * @return a ResponseEntity with the status of the file processed with the
	 *         output file location
	 */

	// Endpoint to handle uploaded file and convert to CSV Format
	@PostMapping("/toCSV")
	public ResponseEntity<String> processFile(@RequestParam("inputFilePath") String inputFilePath,
			@RequestParam("outputFilePath") String outputFilePath) throws IOException {

		try (FileReader fileReader = new FileReader(new File(inputFilePath));
				FileWriter fileWriter = new FileWriter(new File(outputFilePath))) {
			// Process the file content using the service
			String sortedContentCSV = fileServices.processFileToCSV(fileReader);
			// Write the processed content to the output file
			fileWriter.write(sortedContentCSV);
			return new ResponseEntity<>("File processed successfully to CSV. Output saved to: " + outputFilePath,
					HttpStatus.OK);
		}
	}
}
