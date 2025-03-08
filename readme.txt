PROJECT : FILE TEXT CONVERTER

Description 

This project takes the input file as standard input and write to standard .XML and .csv format.
Program is designed in a way that it separate each sentence and then sorting the words of each sentence alphabetically.
Created different layers for loose coupling. Also, handled the exception Globally.
Testing of file are also done to check integrity of application.

Please find the details for running the application:

-> Configure the application.
-> check the  application.properties file( server.port ).
-> run on the desired port Example- 9192.
-> start the Tomcat server.

Using POSTMAN

-> Create a New request.
-> Select the request type to POST.
-> After selecting Query Parameter under Key option mention key : inputFilePath
-> Under Value tab enter the location of file which needs to be processed. Example:(C:/Users/Desktop/testing/filename)
-> Now Again under Key option enter key as : outputFilePath
-> now under corresponding Value tab Enter the location of file needs to be stored after processing.Example(C:/Users/Desktop/testing/filename.XML OR .csv).
-> click on SEND Request
-> We will get confirmation with STATUS CODE.

Using Browser

->use link : 
for Processing file to .XML format
(http://localhost:9192/api/toXML?inputFilePath=C:/Users/Desktop/testing/small.in&outputFilePath=C:/Users/Desktop/testing/outputfile/abc.xml)

for Processing file to .csv format
(http://localhost:9192/api/toCSV?inputFilePath=C:/Users/Desktop/testing/large.in&outputFilePath=C:/Users/Desktop/testing/outputfile/xyz.csv)

NOTE- Replace path in above link as per the local storage location of input and Output file.

