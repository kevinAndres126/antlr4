// Generated from /home/kevin/Documents/Compiladores/PrograCompi2/2.0/antlr4/src/lexerInterprete.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lexerInterprete extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PyCOMA=1, DP=2, COMA=3, ASIGN=4, PIZQ=5, PDER=6, LLAVEIZQ=7, LLAVEDER=8, 
		CORCHETEIZQ=9, CORCHETEDER=10, II=11, MAYORK=12, MENORK=13, MAYORIGUALK=14, 
		MENORIGUALK=15, SUMA=16, RESTA=17, MUL=18, DIV=19, LET=20, RETURN=21, 
		TRUE=22, FALSE=23, LEN=24, FIST=25, LAST=26, REST=27, PUSH=28, FN=29, 
		PUTS=30, IF=31, ELSE=32, INTEGER=33, ID=34, STRING=35, LINE_COMMENT=36, 
		SPECIAL_COMMENT=37, WS=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PyCOMA", "DP", "COMA", "ASIGN", "PIZQ", "PDER", "LLAVEIZQ", "LLAVEDER", 
		"CORCHETEIZQ", "CORCHETEDER", "II", "MAYORK", "MENORK", "MAYORIGUALK", 
		"MENORIGUALK", "SUMA", "RESTA", "MUL", "DIV", "LET", "RETURN", "TRUE", 
		"FALSE", "LEN", "FIST", "LAST", "REST", "PUSH", "FN", "PUTS", "IF", "ELSE", 
		"INTEGER", "ID", "STRING", "LETTER", "DIGIT", "LINE_COMMENT", "SPECIAL_COMMENT", 
		"DELIMITED_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "','", "'='", "'('", "')'", "'{'", "'}'", "'['", "']'", 
		"'=='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'let'", 
		"'return'", "'true'", "'false'", "'len'", "'first'", "'last'", "'rest'", 
		"'push'", "'fn'", "'puts'", "'if'", "'else'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PyCOMA", "DP", "COMA", "ASIGN", "PIZQ", "PDER", "LLAVEIZQ", "LLAVEDER", 
		"CORCHETEIZQ", "CORCHETEDER", "II", "MAYORK", "MENORK", "MAYORIGUALK", 
		"MENORIGUALK", "SUMA", "RESTA", "MUL", "DIV", "LET", "RETURN", "TRUE", 
		"FALSE", "LEN", "FIST", "LAST", "REST", "PUSH", "FN", "PUTS", "IF", "ELSE", 
		"INTEGER", "ID", "STRING", "LINE_COMMENT", "SPECIAL_COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public lexerInterprete(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "G4/lexerInterprete.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u010e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\7\"\u00c0"+
		"\n\"\f\"\16\"\u00c3\13\"\3#\3#\3#\7#\u00c8\n#\f#\16#\u00cb\13#\3$\3$\3"+
		"$\3$\7$\u00d1\n$\f$\16$\u00d4\13$\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\7"+
		"\'\u00e0\n\'\f\'\16\'\u00e3\13\'\3\'\5\'\u00e6\n\'\3\'\3\'\3\'\3\'\3("+
		"\3(\3(\3(\3(\3(\7(\u00f2\n(\f(\16(\u00f5\13(\3(\3(\3(\3(\3(\3)\3)\3)\3"+
		")\7)\u0100\n)\f)\16)\u0103\13)\3)\3)\3)\3*\6*\u0109\n*\r*\16*\u010a\3"+
		"*\3*\5\u00e1\u00f3\u0101\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I\2K\2M&O\'Q\2S(\3\2\5\3\2$$\5"+
		"\2C\\aac|\5\2\13\f\17\17\"\"\2\u0116\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2S\3\2\2\2"+
		"\3U\3\2\2\2\5W\3\2\2\2\7Y\3\2\2\2\t[\3\2\2\2\13]\3\2\2\2\r_\3\2\2\2\17"+
		"a\3\2\2\2\21c\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31l\3\2\2\2"+
		"\33n\3\2\2\2\35p\3\2\2\2\37s\3\2\2\2!v\3\2\2\2#x\3\2\2\2%z\3\2\2\2\'|"+
		"\3\2\2\2)~\3\2\2\2+\u0082\3\2\2\2-\u0089\3\2\2\2/\u008e\3\2\2\2\61\u0094"+
		"\3\2\2\2\63\u0098\3\2\2\2\65\u009e\3\2\2\2\67\u00a3\3\2\2\29\u00a8\3\2"+
		"\2\2;\u00ad\3\2\2\2=\u00b0\3\2\2\2?\u00b5\3\2\2\2A\u00b8\3\2\2\2C\u00bd"+
		"\3\2\2\2E\u00c4\3\2\2\2G\u00cc\3\2\2\2I\u00d7\3\2\2\2K\u00d9\3\2\2\2M"+
		"\u00db\3\2\2\2O\u00eb\3\2\2\2Q\u00fb\3\2\2\2S\u0108\3\2\2\2UV\7=\2\2V"+
		"\4\3\2\2\2WX\7<\2\2X\6\3\2\2\2YZ\7.\2\2Z\b\3\2\2\2[\\\7?\2\2\\\n\3\2\2"+
		"\2]^\7*\2\2^\f\3\2\2\2_`\7+\2\2`\16\3\2\2\2ab\7}\2\2b\20\3\2\2\2cd\7\177"+
		"\2\2d\22\3\2\2\2ef\7]\2\2f\24\3\2\2\2gh\7_\2\2h\26\3\2\2\2ij\7?\2\2jk"+
		"\7?\2\2k\30\3\2\2\2lm\7@\2\2m\32\3\2\2\2no\7>\2\2o\34\3\2\2\2pq\7@\2\2"+
		"qr\7?\2\2r\36\3\2\2\2st\7>\2\2tu\7?\2\2u \3\2\2\2vw\7-\2\2w\"\3\2\2\2"+
		"xy\7/\2\2y$\3\2\2\2z{\7,\2\2{&\3\2\2\2|}\7\61\2\2}(\3\2\2\2~\177\7n\2"+
		"\2\177\u0080\7g\2\2\u0080\u0081\7v\2\2\u0081*\3\2\2\2\u0082\u0083\7t\2"+
		"\2\u0083\u0084\7g\2\2\u0084\u0085\7v\2\2\u0085\u0086\7w\2\2\u0086\u0087"+
		"\7t\2\2\u0087\u0088\7p\2\2\u0088,\3\2\2\2\u0089\u008a\7v\2\2\u008a\u008b"+
		"\7t\2\2\u008b\u008c\7w\2\2\u008c\u008d\7g\2\2\u008d.\3\2\2\2\u008e\u008f"+
		"\7h\2\2\u008f\u0090\7c\2\2\u0090\u0091\7n\2\2\u0091\u0092\7u\2\2\u0092"+
		"\u0093\7g\2\2\u0093\60\3\2\2\2\u0094\u0095\7n\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7p\2\2\u0097\62\3\2\2\2\u0098\u0099\7h\2\2\u0099\u009a\7k\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7u\2\2\u009c\u009d\7v\2\2\u009d\64\3\2\2\2\u009e"+
		"\u009f\7n\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7v\2\2"+
		"\u00a2\66\3\2\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7"+
		"u\2\2\u00a6\u00a7\7v\2\2\u00a78\3\2\2\2\u00a8\u00a9\7r\2\2\u00a9\u00aa"+
		"\7w\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7j\2\2\u00ac:\3\2\2\2\u00ad\u00ae"+
		"\7h\2\2\u00ae\u00af\7p\2\2\u00af<\3\2\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2"+
		"\7w\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4\7u\2\2\u00b4>\3\2\2\2\u00b5\u00b6"+
		"\7k\2\2\u00b6\u00b7\7h\2\2\u00b7@\3\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba"+
		"\7n\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7g\2\2\u00bcB\3\2\2\2\u00bd\u00c1"+
		"\5K&\2\u00be\u00c0\5K&\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2D\3\2\2\2\u00c3\u00c1\3\2\2\2"+
		"\u00c4\u00c9\5I%\2\u00c5\u00c8\5I%\2\u00c6\u00c8\5K&\2\u00c7\u00c5\3\2"+
		"\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00caF\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00d2\7$\2\2\u00cd"+
		"\u00ce\7$\2\2\u00ce\u00d1\7$\2\2\u00cf\u00d1\n\2\2\2\u00d0\u00cd\3\2\2"+
		"\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7$\2\2\u00d6"+
		"H\3\2\2\2\u00d7\u00d8\t\3\2\2\u00d8J\3\2\2\2\u00d9\u00da\4\62;\2\u00da"+
		"L\3\2\2\2\u00db\u00dc\7\61\2\2\u00dc\u00dd\7\61\2\2\u00dd\u00e1\3\2\2"+
		"\2\u00de\u00e0\13\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00e6\7\17\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e8\7\f\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\'"+
		"\2\2\u00eaN\3\2\2\2\u00eb\u00ec\7\61\2\2\u00ec\u00ed\7,\2\2\u00ed\u00f3"+
		"\3\2\2\2\u00ee\u00f2\5O(\2\u00ef\u00f2\5Q)\2\u00f0\u00f2\13\2\2\2\u00f1"+
		"\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f7\7,\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fa\b(\2\2\u00faP\3\2\2\2\u00fb\u00fc\7\61\2\2\u00fc\u00fd"+
		"\7,\2\2\u00fd\u0101\3\2\2\2\u00fe\u0100\13\2\2\2\u00ff\u00fe\3\2\2\2\u0100"+
		"\u0103\3\2\2\2\u0101\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0104\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7,\2\2\u0105\u0106\7\61\2\2\u0106"+
		"R\3\2\2\2\u0107\u0109\t\4\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2"+
		"\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d"+
		"\b*\2\2\u010dT\3\2\2\2\16\2\u00c1\u00c7\u00c9\u00d0\u00d2\u00e1\u00e5"+
		"\u00f1\u00f3\u0101\u010a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}