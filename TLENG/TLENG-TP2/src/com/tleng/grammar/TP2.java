package com.tleng.grammar;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class TP2 {
	private final static boolean PRINT_NEW_LINE = true;
		
	public static void main(String[] args) throws RecognitionException {
		CharStream input = new ANTLRStringStream("<!-- LALAL --><html><head> <title>a</title></head>" +
												"<body> <p> <h1> </h1></p><br></body></html> <!-- LALAL -->");
		PrettyPrintLexer lexer = new PrettyPrintLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		PrettyPrintParser parser = new PrettyPrintParser(tokenStream);
		parser.begin();
		System.out.println("lalala, done baby");
	}

	public static String CreateLineSpan(String cssClass, String tag, boolean mustBreakToNewLine ) 
	{
		String lineSpan = "";
		if(mustBreakToNewLine)
			lineSpan = "<br>";
		lineSpan += "<span class=\"" + cssClass + "\">&lt;" + tag + "&gt;</span>";
		return lineSpan;
	}
	
	public static void Print(String stream)
	{
		System.out.println(stream);
	}
	
	public static void PrintTag(String tag)
	{
		Print("<br>&lt;" + tag + "&gt;");
	}
	
	public static void PrintNewLineSpan(String cssClass, String tag ) 
	{
		String span = CreateLineSpan(cssClass, tag, PRINT_NEW_LINE);
		Print(span);
	}
	
	public static void PrintLineSpan(String cssClass, String tag ) 
	{
		
		String span = CreateLineSpan(cssClass, tag, !PRINT_NEW_LINE);
		Print(span);
	}
	
	public static void PrintStartBlock()
	{
		String div = "<div class=\"bloque\">";
		Print(div);
	}
	
	public static void PrintStartBlock(String cssClass, String tag) 
	{
		String span = CreateLineSpan(cssClass, tag, PRINT_NEW_LINE);
		String div = "<div class=\"bloque\">";
		Print(div + span);
	}
	
	public static void PrintCloseBlock()
	{
		String div = "</div>";
		Print(div);
	}
	
	public static void PrintCloseBlock(String cssClass, String tag) 
	{
		String span = CreateLineSpan(cssClass, tag, PRINT_NEW_LINE);
		String div = "</div>";
		Print(span + div);
	}
}
