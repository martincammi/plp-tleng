// $ANTLR 3.5 C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g 2013-07-09 21:33:58

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
		"NoScripts", "NoTags", "Something", "WS"
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
	public static final int NoScripts=21;
	public static final int NoTags=22;
	public static final int Something=23;
	public static final int WS=24;

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


	public static class begin_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "begin"
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:25:1: begin : InitHTML html EndHTML ;
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:25:7: ( InitHTML html EndHTML )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:25:9: InitHTML html EndHTML
			{
			root_0 = (Object)adaptor.nil();


			InitHTML1=(Token)match(input,InitHTML,FOLLOW_InitHTML_in_begin131); 
			InitHTML1_tree = (Object)adaptor.create(InitHTML1);
			adaptor.addChild(root_0, InitHTML1_tree);

			TP2.Print("<html> &lt;html&gt;" +
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
										   " </head>");
			pushFollow(FOLLOW_html_in_begin143);
			html2=html();
			state._fsp--;

			adaptor.addChild(root_0, html2.getTree());

			EndHTML3=(Token)match(input,EndHTML,FOLLOW_EndHTML_in_begin148); 
			EndHTML3_tree = (Object)adaptor.create(EndHTML3);
			adaptor.addChild(root_0, EndHTML3_tree);

			TP2.PrintTag("/html"); TP2.Print("</html>");
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
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:43:1: html : head body ;
	public final PrettyPrintParser.html_return html() throws RecognitionException {
		PrettyPrintParser.html_return retval = new PrettyPrintParser.html_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope head4 =null;
		ParserRuleReturnScope body5 =null;


		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:43:6: ( head body )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:43:8: head body
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_head_in_html161);
			head4=head();
			state._fsp--;

			adaptor.addChild(root_0, head4.getTree());

			pushFollow(FOLLOW_body_in_html163);
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
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:45:1: head : ( InitHead leer_head EndHead |);
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:45:6: ( InitHead leer_head EndHead |)
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
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:45:9: InitHead leer_head EndHead
					{
					root_0 = (Object)adaptor.nil();


					InitHead6=(Token)match(input,InitHead,FOLLOW_InitHead_in_head172); 
					InitHead6_tree = (Object)adaptor.create(InitHead6);
					adaptor.addChild(root_0, InitHead6_tree);

					TP2.PrintStartBlock("tagHeadBody", "head");
					pushFollow(FOLLOW_leer_head_in_head179);
					leer_head7=leer_head();
					state._fsp--;

					adaptor.addChild(root_0, leer_head7.getTree());

					EndHead8=(Token)match(input,EndHead,FOLLOW_EndHead_in_head184); 
					EndHead8_tree = (Object)adaptor.create(EndHead8);
					adaptor.addChild(root_0, EndHead8_tree);

					TP2.PrintCloseBlock("tagHeadBody", "/head" );
					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:48:4: 
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
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:50:1: body : ( InitBody leer_body EndBody |);
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:50:6: ( InitBody leer_body EndBody |)
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
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:50:9: InitBody leer_body EndBody
					{
					root_0 = (Object)adaptor.nil();


					InitBody9=(Token)match(input,InitBody,FOLLOW_InitBody_in_body200); 
					InitBody9_tree = (Object)adaptor.create(InitBody9);
					adaptor.addChild(root_0, InitBody9_tree);

					TP2.PrintStartBlock("tagHeadBody", "body");
									  TP2.PrintStartBlock();
					pushFollow(FOLLOW_leer_body_in_body206);
					leer_body10=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body10.getTree());

					EndBody11=(Token)match(input,EndBody,FOLLOW_EndBody_in_body211); 
					EndBody11_tree = (Object)adaptor.create(EndBody11);
					adaptor.addChild(root_0, EndBody11_tree);

					TP2.PrintCloseBlock();
									  TP2.PrintCloseBlock("tagHeadBody", "/body");
					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:55:6: 
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
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:57:1: leer_head : ( script leer_head | title leer_head |);
	public final PrettyPrintParser.leer_head_return leer_head() throws RecognitionException {
		PrettyPrintParser.leer_head_return retval = new PrettyPrintParser.leer_head_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope script12 =null;
		ParserRuleReturnScope leer_head13 =null;
		ParserRuleReturnScope title14 =null;
		ParserRuleReturnScope leer_head15 =null;


		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:57:11: ( script leer_head | title leer_head |)
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
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:57:15: script leer_head
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_script_in_leer_head231);
					script12=script();
					state._fsp--;

					adaptor.addChild(root_0, script12.getTree());

					pushFollow(FOLLOW_leer_head_in_leer_head233);
					leer_head13=leer_head();
					state._fsp--;

					adaptor.addChild(root_0, leer_head13.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:58:6: title leer_head
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_title_in_leer_head241);
					title14=title();
					state._fsp--;

					adaptor.addChild(root_0, title14.getTree());

					pushFollow(FOLLOW_leer_head_in_leer_head243);
					leer_head15=leer_head();
					state._fsp--;

					adaptor.addChild(root_0, leer_head15.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:59:6: 
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
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:61:1: title : InitTitle Something EndTitle ;
	public final PrettyPrintParser.title_return title() throws RecognitionException {
		PrettyPrintParser.title_return retval = new PrettyPrintParser.title_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token InitTitle16=null;
		Token Something17=null;
		Token EndTitle18=null;

		Object InitTitle16_tree=null;
		Object Something17_tree=null;
		Object EndTitle18_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:61:7: ( InitTitle Something EndTitle )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:61:9: InitTitle Something EndTitle
			{
			root_0 = (Object)adaptor.nil();


			InitTitle16=(Token)match(input,InitTitle,FOLLOW_InitTitle_in_title259); 
			InitTitle16_tree = (Object)adaptor.create(InitTitle16);
			adaptor.addChild(root_0, InitTitle16_tree);

			TP2.PrintStartBlock("tagTitleScript", "title");
			Something17=(Token)match(input,Something,FOLLOW_Something_in_title265); 
			Something17_tree = (Object)adaptor.create(Something17);
			adaptor.addChild(root_0, Something17_tree);

			EndTitle18=(Token)match(input,EndTitle,FOLLOW_EndTitle_in_title270); 
			EndTitle18_tree = (Object)adaptor.create(EndTitle18);
			adaptor.addChild(root_0, EndTitle18_tree);

			TP2.PrintCloseBlock("tagTitleScript", "/title");
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
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:66:1: script : InitScript Something EndScript ;
	public final PrettyPrintParser.script_return script() throws RecognitionException {
		PrettyPrintParser.script_return retval = new PrettyPrintParser.script_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token InitScript19=null;
		Token Something20=null;
		Token EndScript21=null;

		Object InitScript19_tree=null;
		Object Something20_tree=null;
		Object EndScript21_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:66:8: ( InitScript Something EndScript )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:66:10: InitScript Something EndScript
			{
			root_0 = (Object)adaptor.nil();


			InitScript19=(Token)match(input,InitScript,FOLLOW_InitScript_in_script284); 
			InitScript19_tree = (Object)adaptor.create(InitScript19);
			adaptor.addChild(root_0, InitScript19_tree);

			TP2.PrintStartBlock("tagTitleScript", "script");
							     TP2.PrintStartBlock();
			Something20=(Token)match(input,Something,FOLLOW_Something_in_script291); 
			Something20_tree = (Object)adaptor.create(Something20);
			adaptor.addChild(root_0, Something20_tree);

			EndScript21=(Token)match(input,EndScript,FOLLOW_EndScript_in_script297); 
			EndScript21_tree = (Object)adaptor.create(EndScript21);
			adaptor.addChild(root_0, EndScript21_tree);

			TP2.PrintCloseBlock();
							     TP2.PrintCloseBlock("tagTitleScript", "/script");
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
	// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:73:1: leer_body : ( Something leer_body | Br leer_body | InitDiv leer_body EndDiv leer_body | InitP leer_body EndP leer_body | InitH1 leer_body EndH1 leer_body |);
	public final PrettyPrintParser.leer_body_return leer_body() throws RecognitionException {
		PrettyPrintParser.leer_body_return retval = new PrettyPrintParser.leer_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Something22=null;
		Token Br24=null;
		Token InitDiv26=null;
		Token EndDiv28=null;
		Token InitP30=null;
		Token EndP32=null;
		Token InitH134=null;
		Token EndH136=null;
		ParserRuleReturnScope leer_body23 =null;
		ParserRuleReturnScope leer_body25 =null;
		ParserRuleReturnScope leer_body27 =null;
		ParserRuleReturnScope leer_body29 =null;
		ParserRuleReturnScope leer_body31 =null;
		ParserRuleReturnScope leer_body33 =null;
		ParserRuleReturnScope leer_body35 =null;
		ParserRuleReturnScope leer_body37 =null;

		Object Something22_tree=null;
		Object Br24_tree=null;
		Object InitDiv26_tree=null;
		Object EndDiv28_tree=null;
		Object InitP30_tree=null;
		Object EndP32_tree=null;
		Object InitH134_tree=null;
		Object EndH136_tree=null;

		try {
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:73:11: ( Something leer_body | Br leer_body | InitDiv leer_body EndDiv leer_body | InitP leer_body EndP leer_body | InitH1 leer_body EndH1 leer_body |)
			int alt4=6;
			switch ( input.LA(1) ) {
			case Something:
				{
				alt4=1;
				}
				break;
			case Br:
				{
				alt4=2;
				}
				break;
			case InitDiv:
				{
				alt4=3;
				}
				break;
			case InitP:
				{
				alt4=4;
				}
				break;
			case InitH1:
				{
				alt4=5;
				}
				break;
			case EndBody:
			case EndDiv:
			case EndH1:
			case EndP:
				{
				alt4=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:73:15: Something leer_body
					{
					root_0 = (Object)adaptor.nil();


					Something22=(Token)match(input,Something,FOLLOW_Something_in_leer_body314); 
					Something22_tree = (Object)adaptor.create(Something22);
					adaptor.addChild(root_0, Something22_tree);

					pushFollow(FOLLOW_leer_body_in_leer_body316);
					leer_body23=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body23.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:74:6: Br leer_body
					{
					root_0 = (Object)adaptor.nil();


					Br24=(Token)match(input,Br,FOLLOW_Br_in_leer_body324); 
					Br24_tree = (Object)adaptor.create(Br24);
					adaptor.addChild(root_0, Br24_tree);

					TP2.PrintNewLineSpan("tagBr", "br");
					pushFollow(FOLLOW_leer_body_in_leer_body337);
					leer_body25=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body25.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:76:6: InitDiv leer_body EndDiv leer_body
					{
					root_0 = (Object)adaptor.nil();


					InitDiv26=(Token)match(input,InitDiv,FOLLOW_InitDiv_in_leer_body345); 
					InitDiv26_tree = (Object)adaptor.create(InitDiv26);
					adaptor.addChild(root_0, InitDiv26_tree);

					TP2.PrintNewLineSpan("tagDiv", "div");
					pushFollow(FOLLOW_leer_body_in_leer_body355);
					leer_body27=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body27.getTree());

					EndDiv28=(Token)match(input,EndDiv,FOLLOW_EndDiv_in_leer_body363); 
					EndDiv28_tree = (Object)adaptor.create(EndDiv28);
					adaptor.addChild(root_0, EndDiv28_tree);

					TP2.PrintNewLineSpan("tagDiv", "/div");
					pushFollow(FOLLOW_leer_body_in_leer_body373);
					leer_body29=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body29.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:80:6: InitP leer_body EndP leer_body
					{
					root_0 = (Object)adaptor.nil();


					InitP30=(Token)match(input,InitP,FOLLOW_InitP_in_leer_body381); 
					InitP30_tree = (Object)adaptor.create(InitP30);
					adaptor.addChild(root_0, InitP30_tree);

					TP2.PrintNewLineSpan("tagP", "p");
					pushFollow(FOLLOW_leer_body_in_leer_body392);
					leer_body31=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body31.getTree());

					EndP32=(Token)match(input,EndP,FOLLOW_EndP_in_leer_body400); 
					EndP32_tree = (Object)adaptor.create(EndP32);
					adaptor.addChild(root_0, EndP32_tree);

					TP2.PrintNewLineSpan("tagP", "/p");
					pushFollow(FOLLOW_leer_body_in_leer_body411);
					leer_body33=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body33.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:84:6: InitH1 leer_body EndH1 leer_body
					{
					root_0 = (Object)adaptor.nil();


					InitH134=(Token)match(input,InitH1,FOLLOW_InitH1_in_leer_body418); 
					InitH134_tree = (Object)adaptor.create(InitH134);
					adaptor.addChild(root_0, InitH134_tree);

					TP2.PrintNewLineSpan("tagH1", "h1");
					pushFollow(FOLLOW_leer_body_in_leer_body428);
					leer_body35=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body35.getTree());

					EndH136=(Token)match(input,EndH1,FOLLOW_EndH1_in_leer_body436); 
					EndH136_tree = (Object)adaptor.create(EndH136);
					adaptor.addChild(root_0, EndH136_tree);

					TP2.PrintNewLineSpan("tagH1", "/h1");
					pushFollow(FOLLOW_leer_body_in_leer_body446);
					leer_body37=leer_body();
					state._fsp--;

					adaptor.addChild(root_0, leer_body37.getTree());

					}
					break;
				case 6 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:88:6: 
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



	public static final BitSet FOLLOW_InitHTML_in_begin131 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_html_in_begin143 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_EndHTML_in_begin148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_head_in_html161 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_body_in_html163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitHead_in_head172 = new BitSet(new long[]{0x0000000000180200L});
	public static final BitSet FOLLOW_leer_head_in_head179 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_EndHead_in_head184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitBody_in_body200 = new BitSet(new long[]{0x000000000084C030L});
	public static final BitSet FOLLOW_leer_body_in_body206 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EndBody_in_body211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_script_in_leer_head231 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_leer_head_in_leer_head233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_title_in_leer_head241 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_leer_head_in_leer_head243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitTitle_in_title259 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Something_in_title265 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_EndTitle_in_title270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitScript_in_script284 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Something_in_script291 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EndScript_in_script297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Something_in_leer_body314 = new BitSet(new long[]{0x000000000084C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Br_in_leer_body324 = new BitSet(new long[]{0x000000000084C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitDiv_in_leer_body345 = new BitSet(new long[]{0x000000000084C050L});
	public static final BitSet FOLLOW_leer_body_in_leer_body355 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_EndDiv_in_leer_body363 = new BitSet(new long[]{0x000000000084C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitP_in_leer_body381 = new BitSet(new long[]{0x000000000084C410L});
	public static final BitSet FOLLOW_leer_body_in_leer_body392 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EndP_in_leer_body400 = new BitSet(new long[]{0x000000000084C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_InitH1_in_leer_body418 = new BitSet(new long[]{0x000000000084C090L});
	public static final BitSet FOLLOW_leer_body_in_leer_body428 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EndH1_in_leer_body436 = new BitSet(new long[]{0x000000000084C010L});
	public static final BitSet FOLLOW_leer_body_in_leer_body446 = new BitSet(new long[]{0x0000000000000002L});
}
