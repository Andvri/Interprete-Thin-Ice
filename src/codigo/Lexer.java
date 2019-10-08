/* The following code was generated by JFlex 1.4.3 on 08/10/2019 23:10 */

package codigo;
import static codigo.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 08/10/2019 23:10 from the specification file
 * <tt>/home/andvri/NetBeansProjects/Interprete-Thin-Ice/src/codigo/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\47\2\0\1\3\22\0\1\3\1\45\6\0\1\14"+
    "\1\15\1\36\1\34\1\3\1\35\1\0\1\37\12\2\1\32\1\46"+
    "\1\41\1\33\1\42\2\0\16\1\1\44\11\1\1\43\1\1\1\12"+
    "\1\0\1\13\1\0\1\1\1\0\1\10\1\1\1\25\1\40\1\20"+
    "\1\50\1\7\1\27\1\24\2\1\1\23\1\11\1\21\1\6\1\4"+
    "\1\30\1\5\1\26\1\22\1\31\5\1\1\16\1\0\1\17\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\3\2\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\6\2\1\1\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\10\2\1\27\2\2\1\30\1\4\1\31"+
    "\1\32\1\33\4\2\1\34\5\2\1\35\2\2\1\36"+
    "\2\2\1\37\1\2\1\40\5\2\1\41\1\2\1\42"+
    "\1\43\1\44\1\2\1\45";

  private static int [] zzUnpackAction() {
    int [] result = new int[80];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\173\0\244\0\315\0\366\0\u011f"+
    "\0\51\0\51\0\51\0\51\0\51\0\51\0\u0148\0\u0171"+
    "\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e\0\51\0\51\0\51"+
    "\0\51\0\u0267\0\u0290\0\u02b9\0\122\0\122\0\51\0\51"+
    "\0\51\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386\0\u03af\0\u03d8"+
    "\0\u0401\0\u042a\0\u0453\0\u047c\0\51\0\u04a5\0\51\0\51"+
    "\0\51\0\u04ce\0\u04f7\0\u0520\0\u0549\0\122\0\u0572\0\u059b"+
    "\0\u05c4\0\u05ed\0\u0616\0\122\0\u063f\0\u0668\0\122\0\u0691"+
    "\0\u06ba\0\122\0\u06e3\0\122\0\u070c\0\u0735\0\u075e\0\u0787"+
    "\0\u07b0\0\122\0\u07d9\0\122\0\122\0\122\0\u0802\0\122";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[80];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\3\3\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\3"+
    "\1\20\1\21\2\3\1\22\1\23\1\24\1\3\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\3\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\52\0\2\3"+
    "\1\0\6\3\6\0\12\3\6\0\1\3\2\0\2\3"+
    "\3\0\1\3\2\0\1\4\51\0\1\5\46\0\2\3"+
    "\1\0\1\3\1\43\2\3\1\44\1\3\6\0\12\3"+
    "\6\0\1\3\2\0\2\3\3\0\1\3\1\0\2\3"+
    "\1\0\6\3\6\0\1\45\11\3\6\0\1\3\2\0"+
    "\2\3\3\0\1\3\1\0\2\3\1\0\2\3\1\46"+
    "\3\3\6\0\12\3\6\0\1\3\2\0\2\3\3\0"+
    "\1\3\1\0\2\3\1\0\6\3\6\0\1\3\1\47"+
    "\10\3\6\0\1\3\2\0\2\3\3\0\1\3\1\0"+
    "\2\3\1\0\1\3\1\50\4\3\6\0\12\3\6\0"+
    "\1\3\2\0\2\3\3\0\1\3\1\0\2\3\1\0"+
    "\2\3\1\51\3\3\6\0\12\3\6\0\1\3\2\0"+
    "\2\3\3\0\1\3\1\0\2\3\1\0\6\3\6\0"+
    "\4\3\1\52\5\3\6\0\1\3\2\0\2\3\3\0"+
    "\1\3\1\0\2\3\1\0\4\3\1\53\1\3\6\0"+
    "\12\3\6\0\1\3\2\0\2\3\3\0\1\3\1\0"+
    "\2\3\1\0\6\3\6\0\11\3\1\54\6\0\1\3"+
    "\2\0\2\3\3\0\1\3\33\0\1\55\54\0\1\56"+
    "\44\0\1\57\6\0\1\60\41\0\1\61\16\0\2\3"+
    "\1\0\4\3\1\62\1\3\6\0\12\3\6\0\1\3"+
    "\2\0\2\3\3\0\1\3\1\0\2\3\1\0\2\3"+
    "\1\63\3\3\6\0\12\3\6\0\1\3\2\0\2\3"+
    "\3\0\1\3\1\0\2\3\1\0\1\3\1\64\4\3"+
    "\6\0\12\3\6\0\1\3\2\0\2\3\3\0\1\3"+
    "\1\0\2\3\1\0\1\65\5\3\6\0\12\3\6\0"+
    "\1\3\2\0\2\3\3\0\1\3\1\0\2\3\1\0"+
    "\6\3\6\0\12\3\6\0\1\66\2\0\2\3\3\0"+
    "\1\3\1\0\2\3\1\0\6\3\6\0\2\3\1\67"+
    "\7\3\6\0\1\3\2\0\2\3\3\0\1\3\1\0"+
    "\2\3\1\0\6\3\6\0\11\3\1\70\6\0\1\3"+
    "\2\0\2\3\3\0\1\3\1\0\2\3\1\0\3\3"+
    "\1\71\2\3\6\0\12\3\6\0\1\3\2\0\2\3"+
    "\3\0\1\3\1\0\2\3\1\0\6\3\6\0\1\3"+
    "\1\72\10\3\6\0\1\3\2\0\2\3\3\0\1\3"+
    "\1\0\2\3\1\0\6\3\6\0\6\3\1\73\3\3"+
    "\6\0\1\3\2\0\2\3\3\0\1\3\1\0\2\3"+
    "\1\0\6\3\6\0\1\74\11\3\6\0\1\3\2\0"+
    "\2\3\3\0\1\3\47\56\1\0\1\56\1\0\2\3"+
    "\1\0\6\3\6\0\3\3\1\75\6\3\6\0\1\3"+
    "\2\0\2\3\3\0\1\3\1\0\2\3\1\0\3\3"+
    "\1\76\2\3\6\0\12\3\6\0\1\3\2\0\2\3"+
    "\3\0\1\3\1\0\2\3\1\0\4\3\1\77\1\3"+
    "\6\0\12\3\6\0\1\3\2\0\2\3\3\0\1\3"+
    "\1\0\2\3\1\0\6\3\6\0\4\3\1\100\5\3"+
    "\6\0\1\3\2\0\2\3\3\0\1\3\1\0\2\3"+
    "\1\0\6\3\6\0\1\101\11\3\6\0\1\3\2\0"+
    "\2\3\3\0\1\3\1\0\2\3\1\0\6\3\6\0"+
    "\1\102\11\3\6\0\1\3\2\0\2\3\3\0\1\3"+
    "\1\0\2\3\1\0\6\3\6\0\4\3\1\103\5\3"+
    "\6\0\1\3\2\0\2\3\3\0\1\3\1\0\2\3"+
    "\1\0\2\3\1\104\3\3\6\0\12\3\6\0\1\3"+
    "\2\0\2\3\3\0\1\3\1\0\2\3\1\0\6\3"+
    "\6\0\2\3\1\105\7\3\6\0\1\3\2\0\2\3"+
    "\3\0\1\3\1\0\2\3\1\0\6\3\6\0\6\3"+
    "\1\70\3\3\6\0\1\3\2\0\2\3\3\0\1\3"+
    "\1\0\2\3\1\0\1\3\1\106\4\3\6\0\12\3"+
    "\6\0\1\3\2\0\2\3\3\0\1\3\1\0\2\3"+
    "\1\0\6\3\6\0\2\3\1\107\7\3\6\0\1\3"+
    "\2\0\2\3\3\0\1\3\1\0\2\3\1\0\1\3"+
    "\1\110\4\3\6\0\12\3\6\0\1\3\2\0\2\3"+
    "\3\0\1\3\1\0\2\3\1\0\6\3\6\0\5\3"+
    "\1\111\4\3\6\0\1\3\2\0\2\3\3\0\1\3"+
    "\1\0\2\3\1\0\4\3\1\112\1\3\6\0\12\3"+
    "\6\0\1\3\2\0\2\3\3\0\1\3\1\0\2\3"+
    "\1\0\4\3\1\113\1\3\6\0\12\3\6\0\1\3"+
    "\2\0\2\3\3\0\1\3\1\0\2\3\1\0\4\3"+
    "\1\114\1\3\6\0\12\3\6\0\1\3\2\0\2\3"+
    "\3\0\1\3\1\0\2\3\1\0\2\3\1\115\3\3"+
    "\6\0\12\3\6\0\1\3\2\0\2\3\3\0\1\3"+
    "\1\0\2\3\1\0\2\3\1\116\3\3\6\0\12\3"+
    "\6\0\1\3\2\0\2\3\3\0\1\3\1\0\2\3"+
    "\1\0\5\3\1\117\6\0\12\3\6\0\1\3\2\0"+
    "\2\3\3\0\1\3\1\0\2\3\1\0\4\3\1\120"+
    "\1\3\6\0\12\3\6\0\1\3\2\0\2\3\3\0"+
    "\1\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2091];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\6\1\6\11\7\1\4\11\5\1\3\11"+
    "\13\1\1\11\1\1\3\11\37\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[80];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 120) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 30: 
          { lexeme=yytext(); return Para;
          }
        case 38: break;
        case 2: 
          { lexeme=yytext(); return Identificador;
          }
        case 39: break;
        case 28: 
          { lexeme=yytext(); return Modulo;
          }
        case 40: break;
        case 20: 
          { lexeme=yytext(); return Negacion_logica;
          }
        case 41: break;
        case 16: 
          { lexeme=yytext(); return Menor;
          }
        case 42: break;
        case 9: 
          { lexeme=yytext(); return Llave_a;
          }
        case 43: break;
        case 6: 
          { lexeme=yytext(); return Corchete_c;
          }
        case 44: break;
        case 22: 
          { return Linea;
          }
        case 45: break;
        case 29: 
          { lexeme=yytext(); return Que;
          }
        case 46: break;
        case 36: 
          { lexeme=yytext(); return Logico;
          }
        case 47: break;
        case 34: 
          { lexeme=yytext(); return Repita;
          }
        case 48: break;
        case 15: 
          { lexeme=yytext(); return Division;
          }
        case 49: break;
        case 32: 
          { lexeme=yytext(); return Sino;
          }
        case 50: break;
        case 24: 
          { lexeme=yytext(); return Asignacion;
          }
        case 51: break;
        case 3: 
          { lexeme=yytext(); return Numero;
          }
        case 52: break;
        case 21: 
          { lexeme=yytext(); return Punto_coma;
          }
        case 53: break;
        case 10: 
          { lexeme=yytext(); return Llave_c;
          }
        case 54: break;
        case 7: 
          { lexeme=yytext(); return Parentesis_a;
          }
        case 55: break;
        case 27: 
          { lexeme=yytext(); return Mayor_igual;
          }
        case 56: break;
        case 37: 
          { lexeme=yytext(); return Programa;
          }
        case 57: break;
        case 33: 
          { lexeme=yytext(); return Hasta;
          }
        case 58: break;
        case 19: 
          { lexeme=yytext(); return O_logico;
          }
        case 59: break;
        case 13: 
          { lexeme=yytext(); return Resta;
          }
        case 60: break;
        case 17: 
          { lexeme=yytext(); return Mayor;
          }
        case 61: break;
        case 26: 
          { lexeme=yytext(); return Diferencia;
          }
        case 62: break;
        case 5: 
          { lexeme=yytext(); return Corchete_a;
          }
        case 63: break;
        case 31: 
          { lexeme=yytext(); return Booleano;
          }
        case 64: break;
        case 8: 
          { lexeme=yytext(); return Parentesis_c;
          }
        case 65: break;
        case 23: 
          { lexeme=yytext(); return Si;
          }
        case 66: break;
        case 14: 
          { lexeme=yytext(); return Multiplicacion;
          }
        case 67: break;
        case 1: 
          { return ERROR;
          }
        case 68: break;
        case 35: 
          { lexeme=yytext(); return Entero;
          }
        case 69: break;
        case 11: 
          { lexeme=yytext(); return Igual;
          }
        case 70: break;
        case 18: 
          { lexeme=yytext(); return Y_logico;
          }
        case 71: break;
        case 4: 
          { /*Ignore*/
          }
        case 72: break;
        case 25: 
          { lexeme=yytext(); return Menor_igual;
          }
        case 73: break;
        case 12: 
          { lexeme=yytext(); return Suma;
          }
        case 74: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
