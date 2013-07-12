package com.tleng.grammar;

public class PrettyPrinter {
	public static final PrettyPrinter prettyPrinter = new PrettyPrinter();
	private static final String CLOSE_DIV = "</div>";
	private static final String BEGIN_DIV = "<div class=\"bloque\">";
	private static final String BEGIN_SPAN = "<span class=\"";
	private static final String END_SPAN = "</span>";;
	private static final String LESS = "&lt;";
	private static final String GREATER = "&gt;";
	private StringBuilder _stream;
	private boolean _existsParsingError;
	
	private PrettyPrinter()
	{
		_stream = new StringBuilder();
		_existsParsingError = false;
	}
	
	public static PrettyPrinter GetInstance()
	{
		return prettyPrinter;
	}
	
	public void PrintParsedHTML()
	{
		System.out.println(_stream.toString());
	}

	public void Append(String stream)
	{
		if(!_existsParsingError)
			_stream.append(stream);
	}
	
	private String CreateLineSpan(String cssClass, String tag) 
	{
		String lineSpan = "";
		lineSpan += BEGIN_SPAN + cssClass + "\">" + LESS + tag + GREATER +END_SPAN;
		return lineSpan;
	}
	
	public void Tag(String tag)
	{
		Append(LESS + tag + GREATER);
	}
	
	public void Text(String cssClass, String text)
	{
		if(text == null)
			text ="";
		String prettyText = BEGIN_SPAN + cssClass + "\">" + text + END_SPAN;
		Append(prettyText);
	}
	
	public void LineSpan(String cssClass, String tag ) 
	{
		String span = CreateLineSpan(cssClass, tag);
		Append(span);
	}
	
	public void StartBlock()
	{
		Append(BEGIN_DIV);
	}
	
	public void StartBlock(String cssClass, String tag) 
	{
		String span = CreateLineSpan(cssClass, tag);
		Append(BEGIN_DIV + span);
	}
	
	public void CloseBlock()
	{
		Append(CLOSE_DIV);
	}
	
	public void CloseBlock(String cssClass, String tag) 
	{
		String span = CreateLineSpan(cssClass, tag);
		Append(span + CLOSE_DIV);
	}
	
	public void LogError(IllegalArgumentException exception)
	{
		_stream = new StringBuilder("<html> &lt;html&gt;");
		StartBlock();
		Append("No se pudo parsear correctamente el input. A continuacion se detalla el error:<br>"+
				exception.getMessage());
		CloseBlock();
		Append("&lt;html&gt; </html>");
		_existsParsingError = true;
	}
}
