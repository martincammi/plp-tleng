// $ANTLR 3.5 C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g 2013-07-12 00:21:45

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
	public static final int NoTags=21;
	public static final int WS=22;

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

	// $ANTLR start "InitHTML"
	public final void mInitHTML() throws RecognitionException {
		try {
			int _type = InitHTML;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:91:10: ( '<html>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:91:12: '<html>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:92:8: ( '</html>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:92:10: '</html>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:93:10: ( '<head>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:93:12: '<head>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:94:9: ( '</head>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:94:11: '</head>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:95:10: ( '<body>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:95:12: '<body>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:96:9: ( '</body>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:96:11: '</body>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:97:11: ( '<title>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:97:13: '<title>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:98:10: ( '</title>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:98:12: '</title>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:99:12: ( '<script>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:99:14: '<script>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:100:11: ( '</script>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:100:13: '</script>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:101:9: ( '<div>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:101:11: '<div>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:102:8: ( '</div>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:102:10: '</div>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:103:8: ( '<h1>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:103:10: '<h1>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:104:7: ( '</h1>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:104:9: '</h1>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:105:7: ( '<p>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:105:9: '<p>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:106:6: ( '</p>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:106:8: '</p>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:107:4: ( '<br>' )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:107:6: '<br>'
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
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:108:8: ( (~ ( '<' | '>' ) )* )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:108:10: (~ ( '<' | '>' ) )*
			{
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:108:10: (~ ( '<' | '>' ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= ';')||LA1_0=='='||(LA1_0 >= '?' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= ';')||input.LA(1)=='='||(input.LA(1) >= '?' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NoTags"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:111:5: ( ( ' ' | '\\t' | '\\r' | '\\n' | '<!--' ( ( . )* ) '-->' ) )
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:111:9: ( ' ' | '\\t' | '\\r' | '\\n' | '<!--' ( ( . )* ) '-->' )
			{
			// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:111:9: ( ' ' | '\\t' | '\\r' | '\\n' | '<!--' ( ( . )* ) '-->' )
			int alt3=5;
			switch ( input.LA(1) ) {
			case ' ':
				{
				alt3=1;
				}
				break;
			case '\t':
				{
				alt3=2;
				}
				break;
			case '\r':
				{
				alt3=3;
				}
				break;
			case '\n':
				{
				alt3=4;
				}
				break;
			case '<':
				{
				alt3=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:111:10: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:112:8: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:113:8: '\\r'
					{
					match('\r'); 
					}
					break;
				case 4 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:114:8: '\\n'
					{
					match('\n'); 
					}
					break;
				case 5 :
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:115:8: '<!--' ( ( . )* ) '-->'
					{
					match("<!--"); 

					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:115:14: ( ( . )* )
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:115:15: ( . )*
					{
					// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:115:15: ( . )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0=='-') ) {
							int LA2_1 = input.LA(2);
							if ( (LA2_1=='-') ) {
								int LA2_3 = input.LA(3);
								if ( (LA2_3=='>') ) {
									alt2=2;
								}
								else if ( ((LA2_3 >= '\u0000' && LA2_3 <= '=')||(LA2_3 >= '?' && LA2_3 <= '\uFFFF')) ) {
									alt2=1;
								}

							}
							else if ( ((LA2_1 >= '\u0000' && LA2_1 <= ',')||(LA2_1 >= '.' && LA2_1 <= '\uFFFF')) ) {
								alt2=1;
							}

						}
						else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ',')||(LA2_0 >= '.' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:115:15: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop2;
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

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:8: ( InitHTML | EndHTML | InitHead | EndHead | InitBody | EndBody | InitTitle | EndTitle | InitScript | EndScript | InitDiv | EndDiv | InitH1 | EndH1 | InitP | EndP | Br | NoTags | WS )
		int alt4=19;
		switch ( input.LA(1) ) {
		case '<':
			{
			switch ( input.LA(2) ) {
			case 'h':
				{
				switch ( input.LA(3) ) {
				case 't':
					{
					alt4=1;
					}
					break;
				case 'e':
					{
					alt4=3;
					}
					break;
				case '1':
					{
					alt4=13;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 4, 7, input);
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
						alt4=2;
						}
						break;
					case 'e':
						{
						alt4=4;
						}
						break;
					case '1':
						{
						alt4=14;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 18, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case 'b':
					{
					alt4=6;
					}
					break;
				case 't':
					{
					alt4=8;
					}
					break;
				case 's':
					{
					alt4=10;
					}
					break;
				case 'd':
					{
					alt4=12;
					}
					break;
				case 'p':
					{
					alt4=16;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 4, 8, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case 'b':
				{
				int LA4_9 = input.LA(3);
				if ( (LA4_9=='o') ) {
					alt4=5;
				}
				else if ( (LA4_9=='r') ) {
					alt4=17;
				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 4, 9, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 't':
				{
				alt4=7;
				}
				break;
			case 's':
				{
				alt4=9;
				}
				break;
			case 'd':
				{
				alt4=11;
				}
				break;
			case 'p':
				{
				alt4=15;
				}
				break;
			case '!':
				{
				alt4=19;
				}
				break;
			default:
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 4, 1, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}
			}
			break;
		case ' ':
			{
			alt4=18;
			}
			break;
		case '\t':
			{
			alt4=18;
			}
			break;
		case '\r':
			{
			alt4=18;
			}
			break;
		case '\n':
			{
			alt4=18;
			}
			break;
		default:
			alt4=18;
		}
		switch (alt4) {
			case 1 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:10: InitHTML
				{
				mInitHTML(); 

				}
				break;
			case 2 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:19: EndHTML
				{
				mEndHTML(); 

				}
				break;
			case 3 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:27: InitHead
				{
				mInitHead(); 

				}
				break;
			case 4 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:36: EndHead
				{
				mEndHead(); 

				}
				break;
			case 5 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:44: InitBody
				{
				mInitBody(); 

				}
				break;
			case 6 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:53: EndBody
				{
				mEndBody(); 

				}
				break;
			case 7 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:61: InitTitle
				{
				mInitTitle(); 

				}
				break;
			case 8 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:71: EndTitle
				{
				mEndTitle(); 

				}
				break;
			case 9 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:80: InitScript
				{
				mInitScript(); 

				}
				break;
			case 10 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:91: EndScript
				{
				mEndScript(); 

				}
				break;
			case 11 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:101: InitDiv
				{
				mInitDiv(); 

				}
				break;
			case 12 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:109: EndDiv
				{
				mEndDiv(); 

				}
				break;
			case 13 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:116: InitH1
				{
				mInitH1(); 

				}
				break;
			case 14 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:123: EndH1
				{
				mEndH1(); 

				}
				break;
			case 15 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:129: InitP
				{
				mInitP(); 

				}
				break;
			case 16 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:135: EndP
				{
				mEndP(); 

				}
				break;
			case 17 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:140: Br
				{
				mBr(); 

				}
				break;
			case 18 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:143: NoTags
				{
				mNoTags(); 

				}
				break;
			case 19 :
				// C:\\Users\\Anita\\workspace\\TLENG-TP2\\src\\com\\tleng\\grammar\\PrettyPrint.g:1:150: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
