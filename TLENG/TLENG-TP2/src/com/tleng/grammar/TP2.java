package com.tleng.grammar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class TP2 {
		
	public static void main(String[] args) throws RecognitionException, UnsupportedEncodingException, IOException {
		if (args.length == 0 || args.length > 2) 
		{
			System.out.println("Usage: java -jar tleng_tp2.jar input_path [output_path]");
		} 
		else 
		{
			String inputPath = args[0];
			String outputPath = args.length == 2 ? args[1] : null;
			String outputInfo = args.length == 2 ? args[1] : "Standard output";
			
			System.out.println("Input: "+ inputPath);
			System.out.println("Output: "+ outputInfo);
		
			String input = "";
		    try 
		    {
		        input = ReadFile(inputPath);
		    } 
		    catch (IOException e)
		    {
		    	System.out.println("Error reading input file.\n" + e.getMessage());
		    }
		    
			CharStream stream = new ANTLRStringStream(input);
			PrettyPrintLexer lexer = new PrettyPrintLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			PrettyPrintParser parser = new PrettyPrintParser(tokenStream);
			
			parser.begin();
			PrettyPrinter.GetInstance().Save(outputPath);

			System.out.println("HTML parsing finished.");
		}
	}

	private static String ReadFile(String filePath) throws IOException
	{
	    BufferedReader br = new BufferedReader(new FileReader(filePath));
	    StringBuilder sb = new StringBuilder();
	    try 
	    {
	        String line = br.readLine();

	        while (line != null) 
	        {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	    } 
	    finally 
	    {
	        br.close();
	    }
		
	    return sb.toString();
	}
	
	//QUE VAMOS A HACER CON LOS ERRORES???
	private static String GetPrettyPrintError(Exception exception)
	{
		String error = 	"<html> &lt;html&gt;" +
					"No se pudo parsear correctamente el input. A continuacion se detalla el error:<br>"+
					exception.getMessage() +
					"&lt;html&gt;"+
					" </html>";
		return error;
	}
}
