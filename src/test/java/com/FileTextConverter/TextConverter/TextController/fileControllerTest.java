package com.FileTextConverter.TextConverter.TextController;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.FileTextConverter.TextConverter.textService.fileServices;

@RunWith(SpringRunner.class)
@WebMvcTest(fileController.class)
public class fileControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	@Qualifier("fileServices")
	@MockBean
	private fileServices fileServices;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testProcessFileToXML() throws Exception {
		// Mocking and returning a sample XML output
		when(fileServices.processFiletoXML(any())).thenReturn("<text></text>");

		// POST request with the required parameters
		mockMvc.perform(post("/api/toXML").param("inputFilePath", "C:/Users/10823782/Desktop/testing/small.in")
				.param("outputFilePath", "C:/Users/10823782/Desktop/testing/outputfile/mz.xml"))
				.andExpect(status().isOk());
	}

	@Test
	public void testProcessFileToXMLWithInvalidPath() throws Exception {
		// POST request with an invalid input file path
		mockMvc.perform(post("/api/toXML").param("inputFilePath", "invalid/path/input.txt").param("outputFilePath",
				"invalid/output.xml")).andExpect(status().isInternalServerError());
	}

	@Test
	public void testProcessFileToCSV() throws Exception {
		// Mocking and returning a sample CSV output
		when(fileServices.processFileToCSV(any())).thenReturn("Sentence 1, Hello, World!\n");

		// POST request with the required parameters
		mockMvc.perform(post("/api/toCSV").param("inputFilePath", "C:/Users/10823782/Desktop/testing/small.in")
				.param("outputFilePath", "C:/Users/10823782/Desktop/testing/outputfile/ml.CSV"))
				.andExpect(status().isOk());
	}

	@Test
	public void testProcessFileToCSVWithInvalidPath() throws Exception {
		// POST request with an invalid input file path
		mockMvc.perform(post("/api/toCSV").param("inputFilePath", "invalid/path/input.txt").param("outputFilePath",
				"invalid/output.xml\"")).andExpect(status().isInternalServerError());
	}
}
