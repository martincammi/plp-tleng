// $ANTLR 3.5 C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g 2013-07-12 00:21:45

  package com.tleng.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class PrettyPrintParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Br", "EndBody", "EndDiv", "EndH1", 
		"EndHTML", "EndHead", "EndP", "EndScript", "EndTitle", "InitBody", "InitDiv", 
		"InitH1", "InitHTML", "InitHead", "InitP", "InitScript", "InitTitle", 
		"NoTags", "WS"
	};
	public static final int EOF=-1;
	public static final int Br=4;
	public static final int EndBody=5;
	public static final int EndDiv=6;
	public static final int EndH1=7;
	public static final int EndHTML=8;
	public static final int EndHead=9;
	public static final int EndP=10;
	public static final int EndScript=11;
	public static final int EndTitle=12;
	public static final int InitBody=13;
	public static final int InitDiv=14;
	public static final int InitH1=15;
	public static final int InitHTML=16;
	public static final int InitHead=17;
	public static final int InitP=18;
	public static final int InitScript=19;
	public static final int InitTitle=20;
	public static final int NoTags=21;
	public static final int WS=22;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public PrettyPrintParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public PrettyPrintParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return PrettyPrintParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g"; }


	  @Override
	  public void reportError(RecognitionException e) {
	    	throw new IllegalArgumentException(e);
	  }


	public static class begin_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "begin"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:23:1: begin : InitHTML html EndHTML ;
	public final PrettyPrintParser.begin_return begin() throws RecognitionException {
		PrettyPrintParser.begin_return retval = new PrettyPrintParser.begin_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token InitHTML1=null;
		Token EndHTML3=null;
		ParserRuleReturnScope html2 =null;

		Object InitHTML1_tree=null;
		Object EndHTML3_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:23:7: ( InitHTML html EndHTML )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:23:9: InitHTML html EndHTML
			{
			root_0 = (Object)adaptor.nil();


			InitHTML1=(Token)match(input,InitHTML,FOLLOW_InitHTML_in_begin54); 
			InitHTML1_tree = (Object)adaptor.create(InitHTML1);
			adaptor.addChild(root_0, InitHTML1_tree);

			PrettyPrinter.GetInstance().Append("<html> &lt;html&gt;" +
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
										   " </head>");
			pushFollow(FOLLOW_html_in_begin66);
			html2=html();
			state._fsp--;

			adaptor.addChild(root_0, html2.getTree());

			EndHTML3=(Token)match(input,EndHTML,FOLLOW_EndHTML_in_begin71); 
			EndHTML3_tree = (Object)adaptor.create(EndHTML3);
			adaptor.addChild(root_0, EndHTML3_tree);

			PrettyPrinter.GetInstance().Tag("/html"); 
							 PrettyPrinter.GetInstance().Append("</html>");
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "begin"


	public static class html_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "html"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:42:1: html : head body ;
	public final PrettyPrintParser.html_return html() throws RecognitionException {
		PrettyPrintParser.html_return retval = new PrettyPrintParser.html_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope head4 =null;
		ParserRuleReturnScope body5 =null;


		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:42:6: ( head body )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:42:8: head body
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_head_in_html84);
			head4=head();
			state._fsp--;

			adaptor.addChild(root_0, head4.getTree());

			pushFollow(FOLLOW_body_in_html86);
			body5=body();
			state._fsp--;

			adaptor.addChild(root_0, body5.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "html"


	public static class head_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "head"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:44:1: head : ( InitHead leer_head EndHead |);
	public final PrettyPrintParser.head_return head() throws RecognitionException {
		PrettyPrintParser.head_return retval = new PrettyPrintParser.head_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token InitHead6=null;
		Token EndHead8=null;
		ParserRuleReturnScope leer_head7 =null;

		Object InitHead6_tree=null;
		Object EndHead8_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:44:6: ( InitHead leer_head EndHead |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==InitHead) ) {
				alt1=1;
			}
			else if ( (LA1_0==EndHTML||LA1_0==InitBody) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:44:9: InitHead leer_head EndHead
					{
					root_0 = (Object)adaptor.nil();


					InitHead6=(Token)match(input,InitHead,FOLLOW_InitHead_in_head95); 
					InitHead6_tree = (Object)adaptor.create(InitHead6);
					adaptor.addChild(root_0, InitHead6_tree);

					PrettyPrinter.GetInstance().StartBlock("tagHeadBody", "head");
					pushFollow(FOLLOW_leer_head_in_head102);
					leer_head7=leer_head();
					state._fsp--;

					adaptor.addChild(root_0, leer_head7.getTree());

					EndHead8=(Token)match(input,EndHead,FOLLOW_EndHead_in_head107); 
					EndHead8_tree = (Object)adaptor.create(EndHead8);
					adaptor.addChild(root_0, EndHead8_tree);

					PrettyPrinter.GetInstance().CloseBlock("tagHeadBody", "/head" );
					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:47:4: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "head"


	public static class body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "body"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:49:1: body : ( InitBody leer_body EndBody |);
	public final PrettyPrintParser.body_return body() throws RecognitionException {
		PrettyPrintParser.body_return retval = new PrettyPrintParser.body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token InitBody9=null;
		Token EndBody11=null;
		ParserRuleReturnScope leer_body10 =null;

		Object InitBody9_tree=null;
		Object EndBody11_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:49:6: ( InitBody leer_body EndBody |)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==InitBody) ) {
				alt2=1;
			}
			else if ( (LA2_0==EndHTML) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:49:9: InitBody leer_body EndBody
					{
					root_0 = (Object)adaptor.nil();


					InitBody9=(Token)match(input,InitBody,FOLLOW_InitBody_in_body123); 
					InitBody9_tree = (Object)adaptor.create(InitBody9);
					adaptor.addChild(root_0, InitBody9_tree);

					PrettyPrinter.GetInstance().StartBlock("tagHeadBody", "body");
									  PrettyPrinter.GetInstance().StartBlock();
					pushFollow(FOLLOW_leer_body_in_body129);
					leer_body10=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body10.getTree());

					EndBody11=(Token)match(input,EndBody,FOLLOW_EndBody_in_body134); 
					EndBody11_tree = (Object)adaptor.create(EndBody11);
					adaptor.addChild(root_0, EndBody11_tree);

					PrettyPrinter.GetInstance().CloseBlock();
									  PrettyPrinter.GetInstance().CloseBlock("tagHeadBody", "/body");
					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:54:6: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "body"


	public static class leer_head_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "leer_head"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:56:1: leer_head : ( script leer_head | title leer_head |);
	public final PrettyPrintParser.leer_head_return leer_head() throws RecognitionException {
		PrettyPrintParser.leer_head_return retval = new PrettyPrintParser.leer_head_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope script12 =null;
		ParserRuleReturnScope leer_head13 =null;
		ParserRuleReturnScope title14 =null;
		ParserRuleReturnScope leer_head15 =null;


		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:56:11: ( script leer_head | title leer_head |)
			int alt3=3;
			switch ( input.LA(1) ) {
			case InitScript:
				{
				alt3=1;
				}
				break;
			case InitTitle:
				{
				alt3=2;
				}
				break;
			case EndHead:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:56:15: script leer_head
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_script_in_leer_head154);
					script12=script();
					state._fsp--;

					adaptor.addChild(root_0, script12.getTree());

					pushFollow(FOLLOW_leer_head_in_leer_head156);
					leer_head13=leer_head();
					state._fsp--;

					adaptor.addChild(root_0, leer_head13.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:57:6: title leer_head
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_title_in_leer_head164);
					title14=title();
					state._fsp--;

					adaptor.addChild(root_0, title14.getTree());

					pushFollow(FOLLOW_leer_head_in_leer_head166);
					leer_head15=leer_head();
					state._fsp--;

					adaptor.addChild(root_0, leer_head15.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:58:6: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "leer_head"


	public static class title_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "title"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:60:1: title : InitTitle content= NoTags EndTitle ;
	public final PrettyPrintParser.title_return title() throws RecognitionException {
		PrettyPrintParser.title_return retval = new PrettyPrintParser.title_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token content=null;
		Token InitTitle16=null;
		Token EndTitle17=null;

		Object content_tree=null;
		Object InitTitle16_tree=null;
		Object EndTitle17_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:60:7: ( InitTitle content= NoTags EndTitle )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:60:9: InitTitle content= NoTags EndTitle
			{
			root_0 = (Object)adaptor.nil();


			InitTitle16=(Token)match(input,InitTitle,FOLLOW_InitTitle_in_title182); 
			InitTitle16_tree = (Object)adaptor.create(InitTitle16);
			adaptor.addChild(root_0, InitTitle16_tree);

			PrettyPrinter.GetInstance().StartBlock("tagTitleScript", "title");
			content=(Token)match(input,NoTags,FOLLOW_NoTags_in_title192); 
			content_tree = (Object)adaptor.create(content);
			adaptor.addChild(root_0, content_tree);

			PrettyPrinter.GetInstance().Text("tagTexto", (content!=null?content.getText():null));
			EndTitle17=(Token)match(input,EndTitle,FOLLOW_EndTitle_in_title199); 
			EndTitle17_tree = (Object)adaptor.create(EndTitle17);
			adaptor.addChild(root_0, EndTitle17_tree);

			PrettyPrinter.GetInstance().CloseBlock("tagTitleScript", "/title");
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "title"


	public static class script_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "script"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:65:1: script : InitScript (content= NoTags |) EndScript ;
	public final PrettyPrintParser.script_return script() throws RecognitionException {
		PrettyPrintParser.script_return retval = new PrettyPrintParser.script_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token content=null;
		Token InitScript18=null;
		Token EndScript19=null;

		Object content_tree=null;
		Object InitScript18_tree=null;
		Object EndScript19_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:65:8: ( InitScript (content= NoTags |) EndScript )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:65:10: InitScript (content= NoTags |) EndScript
			{
			root_0 = (Object)adaptor.nil();


			InitScript18=(Token)match(input,InitScript,FOLLOW_InitScript_in_script215); 
			InitScript18_tree = (Object)adaptor.create(InitScript18);
			adaptor.addChild(root_0, InitScript18_tree);

			PrettyPrinter.GetInstance().StartBlock("tagTitleScript", "script");
							     PrettyPrinter.GetInstance().StartBlock();
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:67:4: (content= NoTags |)
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==NoTags) ) {
				alt4=1;
			}
			else if ( (LA4_0==EndScript) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:67:5: content= NoTags
					{
					content=(Token)match(input,NoTags,FOLLOW_NoTags_in_script225); 
					content_tree = (Object)adaptor.create(content);
					adaptor.addChild(root_0, content_tree);

					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:67:21: 
					{
					}
					break;

			}

			PrettyPrinter.GetInstance().Text("tagTexto", (content!=null?content.getText():null));
			EndScript19=(Token)match(input,EndScript,FOLLOW_EndScript_in_script242); 
			EndScript19_tree = (Object)adaptor.create(EndScript19);
			adaptor.addChild(root_0, EndScript19_tree);

			PrettyPrinter.GetInstance().CloseBlock();
							     PrettyPrinter.GetInstance().CloseBlock("tagTitleScript", "/script");
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "script"


	public static class leer_body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "leer_body"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:73:1: leer_body : (content= NoTags leer_body | Br leer_body | InitDiv leer_body EndDiv leer_body | InitP leer_body EndP leer_body | InitH1 leer_body EndH1 leer_body |);
	public final PrettyPrintParser.leer_body_return leer_body() throws RecognitionException {
		PrettyPrintParser.leer_body_return retval = new PrettyPrintParser.leer_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token content=null;
		Token Br21=null;
		Token InitDiv23=null;
		Token EndDiv25=null;
		Token InitP27=null;
		Token EndP29=null;
		Token InitH131=null;
		Token EndH133=null;
		ParserRuleReturnScope leer_body20 =null;
		ParserRuleReturnScope leer_body22 =null;
		ParserRuleReturnScope leer_body24 =null;
		ParserRuleReturnScope leer_body26 =null;
		ParserRuleReturnScope leer_body28 =null;
		ParserRuleReturnScope leer_body30 =null;
		ParserRuleReturnScope leer_body32 =null;
		ParserRuleReturnScope leer_body34 =null;

		Object content_tree=null;
		Object Br21_tree=null;
		Object InitDiv23_tree=null;
		Object EndDiv25_tree=null;
		Object InitP27_tree=null;
		Object EndP29_tree=null;
		Object InitH131_tree=null;
		Object EndH133_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:73:11: (content= NoTags leer_body | Br leer_body | InitDiv leer_body EndDiv leer_body | InitP leer_body EndP leer_body | InitH1 leer_body EndH1 leer_body |)
			int alt5=6;
			switch ( input.LA(1) ) {
			case NoTags:
				{
				alt5=1;
				}
				break;
			case Br:
				{
				alt5=2;
				}
				break;
			case InitDiv:
				{
				alt5=3;
				}
				break;
			case InitP:
				{
				alt5=4;
				}
				break;
			case InitH1:
				{
				alt5=5;
				}
				break;
			case EndBody:
			case EndDiv:
			case EndH1:
			case EndP:
				{
				alt5=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:73:15: content= NoTags leer_body
					{
					root_0 = (Object)adaptor.nil();


					content=(Token)match(input,NoTags,FOLLOW_NoTags_in_leer_body261); 
					content_tree = (Object)adaptor.create(content);
					adaptor.addChild(root_0, content_tree);

					PrettyPrinter.GetInstance().Text("tagTexto", (content!=null?content.getText():null));
					pushFollow(FOLLOW_leer_body_in_leer_body270);
					leer_body20=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body20.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:75:6: Br leer_body
					{
					root_0 = (Object)adaptor.nil();


					Br21=(Token)match(input,Br,FOLLOW_Br_in_leer_body278); 
					Br21_tree = (Object)adaptor.create(Br21);
					adaptor.addChild(root_0, Br21_tree);

					PrettyPrinter.GetInstance().LineSpan("tagBr", "br");
					pushFollow(FOLLOW_leer_body_in_leer_body291);
					leer_body22=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body22.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:77:6: InitDiv leer_body EndDiv leer_body
					{
					root_0 = (Object)adaptor.nil();


					InitDiv23=(Token)match(input,InitDiv,FOLLOW_InitDiv_in_leer_body299); 
					InitDiv23_tree = (Object)adaptor.create(InitDiv23);
					adaptor.addChild(root_0, InitDiv23_tree);

					PrettyPrinter.GetInstance().LineSpan("tagDiv", "div");
					pushFollow(FOLLOW_leer_body_in_leer_body309);
					leer_body24=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body24.getTree());

					EndDiv25=(Token)match(input,EndDiv,FOLLOW_EndDiv_in_leer_body317); 
					EndDiv25_tree = (Object)adaptor.create(EndDiv25);
					adaptor.addChild(root_0, EndDiv25_tree);

					PrettyPrinter.GetInstance().LineSpan("tagDiv", "/div");
					pushFollow(FOLLOW_leer_body_in_leer_body327);
					leer_body26=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body26.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:81:6: InitP leer_body EndP leer_body
					{
					root_0 = (Object)adaptor.nil();


					InitP27=(Token)match(input,InitP,FOLLOW_InitP_in_leer_body335); 
					InitP27_tree = (Object)adaptor.create(InitP27);
					adaptor.addChild(root_0, InitP27_tree);

					PrettyPrinter.GetInstance().LineSpan("tagP", "p");
					pushFollow(FOLLOW_leer_body_in_leer_body346);
					leer_body28=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body28.getTree());

					EndP29=(Token)match(input,EndP,FOLLOW_EndP_in_leer_body354); 
					EndP29_tree = (Object)adaptor.create(EndP29);
					adaptor.addChild(root_0, EndP29_tree);

					PrettyPrinter.GetInstance().LineSpan("tagP", "/p");
					pushFollow(FOLLOW_leer_body_in_leer_body365);
					leer_body30=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body30.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:85:6: InitH1 leer_body EndH1 leer_body
					{
					root_0 = (Object)adaptor.nil();


					InitH131=(Token)match(input,InitH1,FOLLOW_InitH1_in_leer_body372); 
					InitH131_tree = (Object)adaptor.create(InitH131);
					adaptor.addChild(root_0, InitH131_tree);

					PrettyPrinter.GetInstance().LineSpan("tagH1", "h1");
					pushFollow(FOLLOW_leer_body_in_leer_body382);
					leer_body32=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body32.getTree());

					EndH133=(Token)match(input,EndH1,FOLLOW_EndH1_in_leer_body390); 
					EndH133_tree = (Object)adaptor.create(EndH133);
					adaptor.addChild(root_0, EndH133_tree);

					PrettyPrinter.GetInstance().LineSpan("tagH1", "/h1");
					pushFollow(FOLLOW_leer_body_in_leer_body400);
					leer_body34=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body34.getTree());

					}
					break;
				case 6 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:89:6: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "leer_body"

	// Delegated rules



	public static final BitSet FOLLOW_InitHTML_in_begin54 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_html_in_begin66 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_EndHTML_in_begin71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_head_in_html84 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_body_in_html86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitHead_in_head95 = new BitSet(new long[]{0x0000000000180200L});
	public static final BitSet FOLLOW_leer_head_in_head102 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_EndHead_in_head107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitBody_in_body123 = new BitSet(new long[]{0x000000000024C030L});
	public static final BitSet FOLLOW_leer_body_in_body129 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EndBody_in_body134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_script_in_leer_head154 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_leer_head_in_leer_head156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_title_in_leer_head164 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_leer_head_in_leer_head166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitTitle_in_title182 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_NoTags_in_title192 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_EndTitle_in_title199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitScript_in_script215 = new BitSet(new long[]{0x0000000000200800L});
	public static final BitSet FOLLOW_NoTags_in_script225 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EndScript_in_script242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NoTags_in_leer_body261 = new BitSet(new long[]{0x000000000024C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Br_in_leer_body278 = new BitSet(new long[]{0x000000000024C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitDiv_in_leer_body299 = new BitSet(new long[]{0x000000000024C050L});
	public static final BitSet FOLLOW_leer_body_in_leer_body309 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_EndDiv_in_leer_body317 = new BitSet(new long[]{0x000000000024C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitP_in_leer_body335 = new BitSet(new long[]{0x000000000024C410L});
	public static final BitSet FOLLOW_leer_body_in_leer_body346 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EndP_in_leer_body354 = new BitSet(new long[]{0x000000000024C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitH1_in_leer_body372 = new BitSet(new long[]{0x000000000024C090L});
	public static final BitSet FOLLOW_leer_body_in_leer_body382 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EndH1_in_leer_body390 = new BitSet(new long[]{0x000000000024C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body400 = new BitSet(new long[]{0x0000000000000002L});
}
