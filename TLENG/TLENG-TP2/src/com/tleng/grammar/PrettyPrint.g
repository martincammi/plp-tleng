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

WS 
    :   (' ' 				//Escapes spaces
    	| '\t' 
    	| '\r'
    	| '\n' 				
    	| '<!--'(.*)'-->') 	//Escapes comments 
    	{$channel=HIDDEN;}
    ;

begin : InitHTML {TP2.Print("<html> &lt;html&gt;" +
							  " <head>" +
							   " <style type='text/css'>" +
							   " div.bloque {margin-left:2em;}" +
							   " span.tagHeadBody {color: pink;}" +
							   " span.tagTitleScript {color: orange;}" + 
							   " span.Script {color: yellow;}" +
							   " span.tagTexto {color:fuchsia;}" + 
							   " span.tagH1 {color: red;}" +
							   " span.tagBr {color: blue;}" +
							   " span.tagDiv{color: green;}" +
							   " span.tagP{color: orange;}" +
							   " </style>" +
							   " </head>");}
        html	
		EndHTML {TP2.PrintTag("/html"); TP2.Print("</html>");}
		;

html : head body;

head : 	InitHead {TP2.PrintStartBlock("tagHeadBody", "head");} 
		leer_head 
		EndHead  {TP2.PrintCloseBlock("tagHeadBody", "/head" );}
	| ;

body : 	InitBody {TP2.PrintStartBlock("tagHeadBody", "body");
				  TP2.PrintStartBlock();}
		leer_body 
		EndBody  {TP2.PrintCloseBlock();
				  TP2.PrintCloseBlock("tagHeadBody", "/body");}
	  | ; 

leer_head :   script leer_head 
			| title leer_head 
			| ; 

title : InitTitle {TP2.PrintStartBlock("tagTitleScript", "title");}
		Something 
		EndTitle  {TP2.PrintCloseBlock("tagTitleScript", "/title");}
		;

script : InitScript {TP2.PrintStartBlock("tagTitleScript", "script");
				     TP2.PrintStartBlock();}
		 Something 
		 EndScript  {TP2.PrintCloseBlock();
				     TP2.PrintCloseBlock("tagTitleScript", "/script");}
		 ;

leer_body :   Something leer_body 
			| Br 	  	{TP2.PrintNewLineSpan("tagBr", "br");}
			  leer_body 
			| InitDiv 	{TP2.PrintNewLineSpan("tagDiv", "div");}
			  leer_body 
			  EndDiv 	{TP2.PrintNewLineSpan("tagDiv", "/div");}
			  leer_body 
			| InitP		{TP2.PrintNewLineSpan("tagP", "p");} 
			  leer_body 
			  EndP 		{TP2.PrintNewLineSpan("tagP", "/p");}
			  leer_body
			| InitH1 	{TP2.PrintNewLineSpan("tagH1", "h1");}
			  leer_body 
			  EndH1 	{TP2.PrintNewLineSpan("tagH1", "/h1");}
			  leer_body
			| ; 

Something : 'a'; //TODO: Completar

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
NoTags : 'c'; //~(Br|InitP); //TODO: Completar
NoScripts : 'b'; //TODO: Completar



