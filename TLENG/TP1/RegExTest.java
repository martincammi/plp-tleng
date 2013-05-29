package TP1;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExTest {

	public static String NO_MATCH = "NoMatch";
	public static String TAGS_GRAMATICA = "<html>|</html>|<head>|</head>|<body>|</body>|<title>|</title>|<script>|</script>|<div>|</div>|<p>|</p>|<h1>|</h1>|<br>";
	
	public String textoSinTags(String texto){
		return calcularRegular("^((?!(" + TAGS_GRAMATICA + ")).)*$", texto);
	}
	
	public String comments(String texto){
		return calcularRegular("<!--(.*?)-->", texto);
	}
	
	@Test
	public void testComments() {
		//String text = "<html><body><!-- este es un comentario que puede tener <html> cualquier cosa--></body></html>";
		String text = "<!--hola-->";
		assertEquals(textoSinTags(text), "hola");
	}
	
	@Test
	public void testTextoLengthCero() {
		String text = "";
		assertEquals(textoSinTags(text), "");
	}
	
	@Test
	public void testTextoLengthUno() {
		String text = "t";
		assertEquals(textoSinTags(text), "t");
	}
	
	@Test
	public void testTextoLengthMayor() {
		String text = "texto";
		assertEquals(textoSinTags(text), "texto");
	}
	
	@Test
	public void testTextoMayorMenor() {
		String text = "texto<";
		assertEquals(textoSinTags(text), "texto<");
		
		text = "texto>";
		assertEquals(textoSinTags(text), "texto>");
		
		text = "<texto";
		assertEquals(textoSinTags(text), "<texto");
		
		text = ">texto";
		assertEquals(textoSinTags(text), ">texto");
		
		text = "<texto>";
		assertEquals(textoSinTags(text), "<texto>");
		
		text = ">texto<";
		assertEquals(textoSinTags(text), ">texto<");
		
		text = "texto<>";
		assertEquals(textoSinTags(text), "texto<>");
	}
	
	@Test
	public void testTagNoLenguaje() {
		String text = "texto<span>";
		assertEquals(textoSinTags(text), "texto<span>");
		
		text = "texto <span>";
		assertEquals(textoSinTags(text), "texto <span>");
		
		text = "<span> texto";
		assertEquals(textoSinTags(text), "<span> texto");
		
		text = "<span> texto </span>";
		assertEquals(textoSinTags(text), "<span> texto </span>");
		
		text = "texto < html>";
		assertEquals(textoSinTags(text), "texto < html>");
		
		text = "texto </ html>";
		assertEquals(textoSinTags(text), "texto </ html>");
		
		text = "texto < /html>";
		assertEquals(textoSinTags(text), "texto < /html>");
		
		text = "<html > texto </ html>";
		assertEquals(textoSinTags(text), "<html > texto </ html>");
		
		text = "<br/> texto </br>";
		assertEquals(textoSinTags(text), "<br/> texto </br>");
	}
	
	public void testCaos() {
		
		String text = "br <div >br<span>texto>>body><<texto>html></htmls>p><p/><p >head></ahead>";
		assertEquals(textoSinTags(text), "br <div >br<span>texto>>body><<texto>html></htmls>p><p/><p >head></ahead>");
		
	}
	
	@Test
	public void testTagLenguajeBasic() {
		String text = "<html>";
		assertEquals(textoSinTags(text), NO_MATCH);

		text = "</html>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</html>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<head>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</head>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<body>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</body>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<title>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</title>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<script>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</script>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<div>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</div>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<p>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</p>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<h1>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</h1>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<br>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
	}
	
	@Test
	public void testTagLenguajeComplex() {
		String text = "<html>texto</html>";
		assertEquals(textoSinTags(text), NO_MATCH);

		text = "<html>texto</html>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "</html>texto<html>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<html>texto</body>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<br>body</html>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<br>texto</br>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<div>html</body>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<div>texto</div>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<p>texto</span>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
		text = "<head>div</>";
		assertEquals(textoSinTags(text), NO_MATCH);
		
	}
	
	public String calcularRegular(String regEx, String texto){
		Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(texto);

        if(matcher.find()){
        	return matcher.group();
        }else{
        	return NO_MATCH;
        }
	}

}
