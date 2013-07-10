// $ANTLR 3.5 C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g 2013-07-09 21:33:58

  package com.tleng.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PrettyPrintLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PrettyPrintLexer() {} 
	public PrettyPrintLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PrettyPrintLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g"; }

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:17:5: ( ( ' ' | '\\t' | '\\r' | '\\n' | '<!--' ( ( . )* ) '-->' ) )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:17:9: ( ' ' | '\\t' | '\\r' | '\\n' | '<!--' ( ( . )* ) '-->' )
			{
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:17:9: ( ' ' | '\\t' | '\\r' | '\\n' | '<!--' ( ( . )* ) '-->' )
			int alt2=5;
			switch ( input.LA(1) ) {
			case ' ':
				{
				alt2=1;
				}
				break;
			case '\t':
				{
				alt2=2;
				}
				break;
			case '\r':
				{
				alt2=3;
				}
				break;
			case '\n':
				{
				alt2=4;
				}
				break;
			case '<':
				{
				alt2=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:17:10: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:18:8: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:19:8: '\\r'
					{
					match('\r'); 
					}
					break;
				case 4 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:20:8: '\\n'
					{
					match('\n'); 
					}
					break;
				case 5 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:21:8: '<!--' ( ( . )* ) '-->'
					{
					match("<!--"); 

					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:21:14: ( ( . )* )
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:21:15: ( . )*
					{
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:21:15: ( . )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0=='-') ) {
							int LA1_1 = input.LA(2);
							if ( (LA1_1=='-') ) {
								int LA1_3 = input.LA(3);
								if ( (LA1_3=='>') ) {
									alt1=2;
								}
								else if ( ((LA1_3 >= '\u0000' && LA1_3 <= '=')||(LA1_3 >= '?' && LA1_3 <= '\uFFFF')) ) {
									alt1=1;
								}

							}
							else if ( ((LA1_1 >= '\u0000' && LA1_1 <= ',')||(LA1_1 >= '.' && LA1_1 <= '\uFFFF')) ) {
								alt1=1;
							}

						}
						else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ',')||(LA1_0 >= '.' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:21:15: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop1;
						}
					}

					}

					match("-->"); 

					}
					break;

			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "Something"
	public final void mSomething() throws RecognitionException {
		try {
			int _type = Something;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:90:11: ( 'a' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:90:13: 'a'
			{
			match('a'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Something"

	// $ANTLR start "InitHTML"
	public final void mInitHTML() throws RecognitionException {
		try {
			int _type = InitHTML;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:92:10: ( '<html>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:92:12: '<html>'
			{
			match("<html>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitHTML"

	// $ANTLR start "EndHTML"
	public final void mEndHTML() throws RecognitionException {
		try {
			int _type = EndHTML;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:93:8: ( '</html>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:93:10: '</html>'
			{
			match("</html>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndHTML"

	// $ANTLR start "InitHead"
	public final void mInitHead() throws RecognitionException {
		try {
			int _type = InitHead;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:94:10: ( '<head>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:94:12: '<head>'
			{
			match("<head>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitHead"

	// $ANTLR start "EndHead"
	public final void mEndHead() throws RecognitionException {
		try {
			int _type = EndHead;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:95:9: ( '</head>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:95:11: '</head>'
			{
			match("</head>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndHead"

	// $ANTLR start "InitBody"
	public final void mInitBody() throws RecognitionException {
		try {
			int _type = InitBody;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:96:10: ( '<body>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:96:12: '<body>'
			{
			match("<body>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitBody"

	// $ANTLR start "EndBody"
	public final void mEndBody() throws RecognitionException {
		try {
			int _type = EndBody;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:97:9: ( '</body>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:97:11: '</body>'
			{
			match("</body>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndBody"

	// $ANTLR start "InitTitle"
	public final void mInitTitle() throws RecognitionException {
		try {
			int _type = InitTitle;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:98:11: ( '<title>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:98:13: '<title>'
			{
			match("<title>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitTitle"

	// $ANTLR start "EndTitle"
	public final void mEndTitle() throws RecognitionException {
		try {
			int _type = EndTitle;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:99:10: ( '</title>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:99:12: '</title>'
			{
			match("</title>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndTitle"

	// $ANTLR start "InitScript"
	public final void mInitScript() throws RecognitionException {
		try {
			int _type = InitScript;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:100:12: ( '<script>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:100:14: '<script>'
			{
			match("<script>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitScript"

	// $ANTLR start "EndScript"
	public final void mEndScript() throws RecognitionException {
		try {
			int _type = EndScript;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:101:11: ( '</script>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:101:13: '</script>'
			{
			match("</script>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndScript"

	// $ANTLR start "InitDiv"
	public final void mInitDiv() throws RecognitionException {
		try {
			int _type = InitDiv;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:102:9: ( '<div>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:102:11: '<div>'
			{
			match("<div>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitDiv"

	// $ANTLR start "EndDiv"
	public final void mEndDiv() throws RecognitionException {
		try {
			int _type = EndDiv;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:103:8: ( '</div>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:103:10: '</div>'
			{
			match("</div>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndDiv"

	// $ANTLR start "InitH1"
	public final void mInitH1() throws RecognitionException {
		try {
			int _type = InitH1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:104:8: ( '<h1>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:104:10: '<h1>'
			{
			match("<h1>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitH1"

	// $ANTLR start "EndH1"
	public final void mEndH1() throws RecognitionException {
		try {
			int _type = EndH1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:105:7: ( '</h1>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:105:9: '</h1>'
			{
			match("</h1>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndH1"

	// $ANTLR start "InitP"
	public final void mInitP() throws RecognitionException {
		try {
			int _type = InitP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:106:7: ( '<p>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:106:9: '<p>'
			{
			match("<p>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "InitP"

	// $ANTLR start "EndP"
	public final void mEndP() throws RecognitionException {
		try {
			int _type = EndP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:107:6: ( '</p>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:107:8: '</p>'
			{
			match("</p>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndP"

	// $ANTLR start "Br"
	public final void mBr() throws RecognitionException {
		try {
			int _type = Br;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:108:4: ( '<br>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:108:6: '<br>'
			{
			match("<br>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Br"

	// $ANTLR start "NoTags"
	public final void mNoTags() throws RecognitionException {
		try {
			int _type = NoTags;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:109:8: ( 'c' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:109:10: 'c'
			{
			match('c'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NoTags"

	// $ANTLR start "NoScripts"
	public final void mNoScripts() throws RecognitionException {
		try {
			int _type = NoScripts;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:110:11: ( 'b' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:110:13: 'b'
			{
			match('b'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NoScripts"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:8: ( WS | Something | InitHTML | EndHTML | InitHead | EndHead | InitBody | EndBody | InitTitle | EndTitle | InitScript | EndScript | InitDiv | EndDiv | InitH1 | EndH1 | InitP | EndP | Br | NoTags | NoScripts )
		int alt3=21;
		switch ( input.LA(1) ) {
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt3=1;
			}
			break;
		case '<':
			{
			switch ( input.LA(2) ) {
			case '!':
				{
				alt3=1;
				}
				break;
			case 'h':
				{
				switch ( input.LA(3) ) {
				case 't':
					{
					alt3=3;
					}
					break;
				case 'e':
					{
					alt3=5;
					}
					break;
				case '1':
					{
					alt3=15;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 3, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case '/':
				{
				switch ( input.LA(3) ) {
				case 'h':
					{
					switch ( input.LA(4) ) {
					case 't':
						{
						alt3=4;
						}
						break;
					case 'e':
						{
						alt3=6;
						}
						break;
					case '1':
						{
						alt3=16;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 16, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case 'b':
					{
					alt3=8;
					}
					break;
				case 't':
					{
					alt3=10;
					}
					break;
				case 's':
					{
					alt3=12;
					}
					break;
				case 'd':
					{
					alt3=14;
					}
					break;
				case 'p':
					{
					alt3=18;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 3, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case 'b':
				{
				int LA3_8 = input.LA(3);
				if ( (LA3_8=='o') ) {
					alt3=7;
				}
				else if ( (LA3_8=='r') ) {
					alt3=19;
				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 3, 8, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 't':
				{
				alt3=9;
				}
				break;
			case 's':
				{
				alt3=11;
				}
				break;
			case 'd':
				{
				alt3=13;
				}
				break;
			case 'p':
				{
				alt3=17;
				}
				break;
			default:
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 3, 2, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}
			}
			break;
		case 'a':
			{
			alt3=2;
			}
			break;
		case 'c':
			{
			alt3=20;
			}
			break;
		case 'b':
			{
			alt3=21;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 3, 0, input);
			throw nvae;
		}
		switch (alt3) {
			case 1 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:10: WS
				{
				mWS(); 

				}
				break;
			case 2 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:13: Something
				{
				mSomething(); 

				}
				break;
			case 3 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:23: InitHTML
				{
				mInitHTML(); 

				}
				break;
			case 4 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:32: EndHTML
				{
				mEndHTML(); 

				}
				break;
			case 5 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:40: InitHead
				{
				mInitHead(); 

				}
				break;
			case 6 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:49: EndHead
				{
				mEndHead(); 

				}
				break;
			case 7 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:57: InitBody
				{
				mInitBody(); 

				}
				break;
			case 8 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:66: EndBody
				{
				mEndBody(); 

				}
				break;
			case 9 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:74: InitTitle
				{
				mInitTitle(); 

				}
				break;
			case 10 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:84: EndTitle
				{
				mEndTitle(); 

				}
				break;
			case 11 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:93: InitScript
				{
				mInitScript(); 

				}
				break;
			case 12 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:104: EndScript
				{
				mEndScript(); 

				}
				break;
			case 13 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:114: InitDiv
				{
				mInitDiv(); 

				}
				break;
			case 14 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:122: EndDiv
				{
				mEndDiv(); 

				}
				break;
			case 15 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:129: InitH1
				{
				mInitH1(); 

				}
				break;
			case 16 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:136: EndH1
				{
				mEndH1(); 

				}
				break;
			case 17 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:142: InitP
				{
				mInitP(); 

				}
				break;
			case 18 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:148: EndP
				{
				mEndP(); 

				}
				break;
			case 19 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:153: Br
				{
				mBr(); 

				}
				break;
			case 20 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:156: NoTags
				{
				mNoTags(); 

				}
				break;
			case 21 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:163: NoScripts
				{
				mNoScripts(); 

				}
				break;

		}
	}



}
