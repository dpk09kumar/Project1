package com.FileTextConverter.TextConverter.textService;

import java.io.Reader;

import org.springframework.stereotype.Component;

@Component
public interface fileServices {

	// method for producing XML file
	public String processFiletoXML(Reader reader);

	// method for producing CSV file
	public String processFileToCSV(Reader reader);
}
