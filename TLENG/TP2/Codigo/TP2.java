package com.tleng.grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class TP2 {
	public static void main(String[] args) throws RecognitionException, UnsupportedEncodingException, IOException 
	{
		String input = "";
	    try 
	    {
	        input = Read();
	    } 
	    catch (IOException e)
	    {
	    	System.out.println("Error reading input.\n" + e.getMessage());
	    }
	    
		CharStream stream = new ANTLRStringStream(input);
		PrettyPrintLexer lexer = new PrettyPrintLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		PrettyPrintParser parser = new PrettyPrintParser(tokenStream);
		
		try
		{
			parser.begin();
		}
		catch(IllegalArgumentException exception)
		{
			PrettyPrinter.GetInstance().LogError(exception);
		}
		finally
		{
			PrettyPrinter.GetInstance().PrintParsedHTML();
		}
	}
	
	private static String Read() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String readString;

	    while ((readString = in.readLine()) != null && readString.length() != 0)
	    	sb.append(readString);

	    return sb.toString();
	}
}
