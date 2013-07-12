grammar PrettyPrint;

options {
  language = Java;
  output = AST;
}

@header {
  package com.tleng.grammar;
}

@lexer::header {
  package com.tleng.grammar;
}

@members {
  @Override
  public void reportError(RecognitionException e) {
    	throw new IllegalArgumentException(e);
  }
}

begin : InitHTML {PrettyPrinter.GetInstance().Append("<html> &lt;html&gt;" +
							  " <head>" +
							   " <style type='text/css'>" +
							   " div.bloque {margin-left:2em;}" +
							   " span.tagHeadBody {color: blue;}" +
							   " span.tagTitleScript {color: orange;}" + 
							   " span.Script {color: orange;}" +
							   " span.tagTexto {color:grey;}" + 
							   " span.tagH1 {color: red;}" +
							   " span.tagBr {color: lightblue;}" +
							   " span.tagDiv{color: crimson;}" +
							   " span.tagP{color: purple;}" +
							   " </style>" +
							   " </head>");}
        html	
		EndHTML {PrettyPrinter.GetInstance().Tag("/html"); 
				 PrettyPrinter.GetInstance().Append("</html>");}
		;

html : head body;

head : 	InitHead {PrettyPrinter.GetInstance().StartBlock("tagHeadBody", "head");} 
		leer_head 
		EndHead  {PrettyPrinter.GetInstance().CloseBlock("tagHeadBody", "/head" );}
	| ;

body : 	InitBody {PrettyPrinter.GetInstance().StartBlock("tagHeadBody", "body");
				  PrettyPrinter.GetInstance().StartBlock();}
		leer_body 
		EndBody  {PrettyPrinter.GetInstance().CloseBlock();
				  PrettyPrinter.GetInstance().CloseBlock("tagHeadBody", "/body");}
	  | ; 

leer_head :   script leer_head 
			| title leer_head 
			| ; 

title : InitTitle 		{PrettyPrinter.GetInstance().StartBlock("tagTitleScript", "title");}
		content=NoTags 	{PrettyPrinter.GetInstance().Text("tagTexto", $content.text);}
		EndTitle  		{PrettyPrinter.GetInstance().CloseBlock("tagTitleScript", "/title");}
		;

script : InitScript {PrettyPrinter.GetInstance().StartBlock("tagTitleScript", "script");
				     PrettyPrinter.GetInstance().StartBlock();}
		 (content=NoTags |)	
		 			{PrettyPrinter.GetInstance().Text("tagTexto", $content.text);}
		 EndScript  {PrettyPrinter.GetInstance().CloseBlock();
				     PrettyPrinter.GetInstance().CloseBlock("tagTitleScript", "/script");}
		 ;

leer_body :   content=NoTags {PrettyPrinter.GetInstance().Text("tagTexto", $content.text);}
			  leer_body 
			| Br 	  	{PrettyPrinter.GetInstance().LineSpan("tagBr", "br");}
			  leer_body 
			| InitDiv 	{PrettyPrinter.GetInstance().LineSpan("tagDiv", "div");}
			  leer_body 
			  EndDiv 	{PrettyPrinter.GetInstance().LineSpan("tagDiv", "/div");}
			  leer_body 
			| InitP		{PrettyPrinter.GetInstance().LineSpan("tagP", "p");} 
			  leer_body 
			  EndP 		{PrettyPrinter.GetInstance().LineSpan("tagP", "/p");}
			  leer_body
			| InitH1 	{PrettyPrinter.GetInstance().LineSpan("tagH1", "h1");}
			  leer_body 
			  EndH1 	{PrettyPrinter.GetInstance().LineSpan("tagH1", "/h1");}
			  leer_body
			| ; 

InitHTML : '<html>';
EndHTML: '</html>';
InitHead : '<head>';
EndHead : '</head>';
InitBody : '<body>';
EndBody : '</body>';
InitTitle : '<title>';
EndTitle : '</title>';
InitScript : '<script>';
EndScript : '</script>';
InitDiv : '<div>';
EndDiv : '</div>';
InitH1 : '<h1>';
EndH1 : '</h1>';
InitP : '<p>';
EndP : '</p>';
Br : '<br>';
NoTags : (~('<'|'>'))*;

WS 
    :   (' ' 				//Escapes spaces
    	| '\t' 
    	| '\r'
    	| '\n' 				
    	| '<!--'(.*)'-->') 	//Escapes comments 
    	{$channel=HIDDEN;}
    ;

