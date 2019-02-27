// This is a generated file. Not intended for manual editing.
package ru.tereshkina.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ru.tereshkina.plugin.psi.RefalFiveLambdaTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RefalFiveLambdaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ASSIGNMENT_CORRECT) {
      r = AssignmentCorrect(b, 0);
    }
    else if (t == ASSIGNMENT_IN_CORRECT) {
      r = AssignmentInCorrect(b, 0);
    }
    else if (t == ATOM) {
      r = Atom(b, 0);
    }
    else if (t == BLOCK) {
      r = Block(b, 0);
    }
    else if (t == CALLEE) {
      r = Callee(b, 0);
    }
    else if (t == CARET_DEF) {
      r = CaretDef(b, 0);
    }
    else if (t == COMMENT) {
      r = Comment(b, 0);
    }
    else if (t == CONDITION_ASSIGNMENT) {
      r = ConditionAssignment(b, 0);
    }
    else if (t == CONDITION_CORRECT) {
      r = ConditionCorrect(b, 0);
    }
    else if (t == CONDITION_IN_CORRECT) {
      r = ConditionInCorrect(b, 0);
    }
    else if (t == FUNC_NAME) {
      r = FuncName(b, 0);
    }
    else if (t == FUNC_PTR) {
      r = FuncPtr(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = Identifier(b, 0);
    }
    else if (t == INCLUDE_DEC) {
      r = IncludeDec(b, 0);
    }
    else if (t == KEYWORD_FUNCTION) {
      r = KeywordFunction(b, 0);
    }
    else if (t == NAME_LIST) {
      r = NameList(b, 0);
    }
    else if (t == NATIVE_INS) {
      r = NativeIns(b, 0);
    }
    else if (t == PATTERN) {
      r = Pattern(b, 0);
    }
    else if (t == PATTERN_TERM) {
      r = PatternTerm(b, 0);
    }
    else if (t == PROGRAM_ELEMENT) {
      r = ProgramElement(b, 0);
    }
    else if (t == REDEFINITION_VARIABLE) {
      r = RedefinitionVariable(b, 0);
    }
    else if (t == RESULT) {
      r = Result(b, 0);
    }
    else if (t == RESULT_EX) {
      r = ResultEx(b, 0);
    }
    else if (t == RESULT_TERM) {
      r = ResultTerm(b, 0);
    }
    else if (t == SENTENCE) {
      r = Sentence(b, 0);
    }
    else if (t == SENTENCES) {
      r = Sentences(b, 0);
    }
    else if (t == SIMPLE_FUNCTION) {
      r = SimpleFunction(b, 0);
    }
    else if (t == SUGER_CALL) {
      r = SugerCall(b, 0);
    }
    else if (t == VAR) {
      r = Var(b, 0);
    }
    else if (t == ENUM_DEFINITION) {
      r = enumDefinition(b, 0);
    }
    else if (t == EXTERNAL_DECLARATION) {
      r = externalDeclaration(b, 0);
    }
    else if (t == FORWARD_DECLARATION) {
      r = forwardDeclaration(b, 0);
    }
    else if (t == PATTERN_RECOVER) {
      r = patternRecover(b, 0);
    }
    else if (t == SWAP_DEFINITION) {
      r = swapDefinition(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Program(b, l + 1);
  }

  /* ********************************************************** */
  // EQUAL ResultEx COLON Pattern
  public static boolean AssignmentCorrect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentCorrect")) return false;
    if (!nextTokenIs(b, EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && ResultEx(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Pattern(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_CORRECT, r);
    return r;
  }

  /* ********************************************************** */
  // EQUAL ResultEx SHARP Pattern
  public static boolean AssignmentInCorrect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentInCorrect")) return false;
    if (!nextTokenIs(b, EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && ResultEx(b, l + 1);
    r = r && consumeToken(b, SHARP);
    r = r && Pattern(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_IN_CORRECT, r);
    return r;
  }

  /* ********************************************************** */
  // QUOTEDSTRING
  //     | COMPOUND
  //     | INTEGER_LITERAL
  //     | Identifier
  //     | FuncPtr
  public static boolean Atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, QUOTEDSTRING);
    if (!r) r = consumeToken(b, COMPOUND);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = Identifier(b, l + 1);
    if (!r) r = FuncPtr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE Sentences RBRACE
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && Sentences(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET FuncName Result RBRACKET
  static boolean BracketResultTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BracketResultTerm")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && FuncName(b, l + 1);
    r = r && Result(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FuncName
  //     | FuncPtr
  //     | Var
  //     | ChevronResultTerm
  //     | Block
  public static boolean Callee(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Callee")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALLEE, "<callee>");
    r = FuncName(b, l + 1);
    if (!r) r = FuncPtr(b, l + 1);
    if (!r) r = Var(b, l + 1);
    if (!r) r = ChevronResultTerm(b, l + 1);
    if (!r) r = Block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CARET
  public static boolean CaretDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaretDef")) return false;
    if (!nextTokenIs(b, CARET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CARET);
    exit_section_(b, m, CARET_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // LCHEVRON Callee Result RCHEVRON
  static boolean ChevronResultTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ChevronResultTerm")) return false;
    if (!nextTokenIs(b, LCHEVRON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCHEVRON);
    r = r && Callee(b, l + 1);
    r = r && Result(b, l + 1);
    r = r && consumeToken(b, RCHEVRON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MULTILINE_COMMENT
  //            // | END_OF_LINE_COMMENT
  //             | LINE_COMMENT
  public static boolean Comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comment")) return false;
    if (!nextTokenIs(b, "<comment>", LINE_COMMENT, MULTILINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, MULTILINE_COMMENT);
    if (!r) r = consumeToken(b, LINE_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ConditionInCorrect | AssignmentInCorrect
  public static boolean ConditionAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionAssignment")) return false;
    if (!nextTokenIs(b, "<condition assignment>", COMMA, EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION_ASSIGNMENT, "<condition assignment>");
    r = ConditionInCorrect(b, l + 1);
    if (!r) r = AssignmentInCorrect(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMA ResultEx COLON Pattern
  public static boolean ConditionCorrect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionCorrect")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ResultEx(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Pattern(b, l + 1);
    exit_section_(b, m, CONDITION_CORRECT, r);
    return r;
  }

  /* ********************************************************** */
  // COMMA ResultEx SHARP Pattern
  public static boolean ConditionInCorrect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionInCorrect")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ResultEx(b, l + 1);
    r = r && consumeToken(b, SHARP);
    r = r && Pattern(b, l + 1);
    exit_section_(b, m, CONDITION_IN_CORRECT, r);
    return r;
  }

  /* ********************************************************** */
  // NAME
  public static boolean FuncName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FuncName")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, FUNC_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // AMPERSAND FuncName
  public static boolean FuncPtr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FuncPtr")) return false;
    if (!nextTokenIs(b, AMPERSAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AMPERSAND);
    r = r && FuncName(b, l + 1);
    exit_section_(b, m, FUNC_PTR, r);
    return r;
  }

  /* ********************************************************** */
  // NAME
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // INCLUDE COMPOUND SEMICOLON
  public static boolean IncludeDec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IncludeDec")) return false;
    if (!nextTokenIs(b, INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INCLUDE, COMPOUND, SEMICOLON);
    exit_section_(b, m, INCLUDE_DEC, r);
    return r;
  }

  /* ********************************************************** */
  // (ENTRY | INLINE | DRIVE )? FuncName (Block | (COMMA FuncName)* SEMICOLON)
  public static boolean KeywordFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordFunction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORD_FUNCTION, "<keyword function>");
    r = KeywordFunction_0(b, l + 1);
    r = r && FuncName(b, l + 1);
    r = r && KeywordFunction_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ENTRY | INLINE | DRIVE )?
  private static boolean KeywordFunction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordFunction_0")) return false;
    KeywordFunction_0_0(b, l + 1);
    return true;
  }

  // ENTRY | INLINE | DRIVE
  private static boolean KeywordFunction_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordFunction_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTRY);
    if (!r) r = consumeToken(b, INLINE);
    if (!r) r = consumeToken(b, DRIVE);
    exit_section_(b, m, null, r);
    return r;
  }

  // Block | (COMMA FuncName)* SEMICOLON
  private static boolean KeywordFunction_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordFunction_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Block(b, l + 1);
    if (!r) r = KeywordFunction_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA FuncName)* SEMICOLON
  private static boolean KeywordFunction_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordFunction_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KeywordFunction_2_1_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA FuncName)*
  private static boolean KeywordFunction_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordFunction_2_1_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!KeywordFunction_2_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KeywordFunction_2_1_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA FuncName
  private static boolean KeywordFunction_2_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordFunction_2_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FuncName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAME (COMMA NAME)* SEMICOLON
  public static boolean NameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameList")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    r = r && NameList_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, NAME_LIST, r);
    return r;
  }

  // (COMMA NAME)*
  private static boolean NameList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!NameList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NameList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA NAME
  private static boolean NameList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NATIVE_IN
  public static boolean NativeIns(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NativeIns")) return false;
    if (!nextTokenIs(b, NATIVE_IN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NATIVE_IN);
    exit_section_(b, m, NATIVE_INS, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN Result RPAREN
  static boolean ParenResultTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenResultTerm")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Result(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PatternTerm*
  public static boolean Pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pattern")) return false;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    int c = current_position_(b);
    while (true) {
      if (!PatternTerm(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Pattern", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // Atom
  //     | patternTermParens
  //     | patternTermBrackets
  //     | RedefinitionVariable
  //     //добавлено
  //     | AssignmentCorrect
  //     | ConditionCorrect
  public static boolean PatternTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_TERM, "<pattern term>");
    r = Atom(b, l + 1);
    if (!r) r = patternTermParens(b, l + 1);
    if (!r) r = patternTermBrackets(b, l + 1);
    if (!r) r = RedefinitionVariable(b, l + 1);
    if (!r) r = AssignmentCorrect(b, l + 1);
    if (!r) r = ConditionCorrect(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ProgramElement*
  static boolean Program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Program")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ProgramElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Program", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // IncludeDec
  //   | externalDeclaration
  //   | enumDefinition
  //   | swapDefinition
  //   | forwardDeclaration
  //  // | ForceEntry
  //   | SimpleFunction
  //  // | Comment
  //   | NativeIns
  //   |KeywordFunction
  //  // | Comment
  //   | SEMICOLON
  public static boolean ProgramElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ProgramElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROGRAM_ELEMENT, "<program element>");
    r = IncludeDec(b, l + 1);
    if (!r) r = externalDeclaration(b, l + 1);
    if (!r) r = enumDefinition(b, l + 1);
    if (!r) r = swapDefinition(b, l + 1);
    if (!r) r = forwardDeclaration(b, l + 1);
    if (!r) r = SimpleFunction(b, l + 1);
    if (!r) r = NativeIns(b, l + 1);
    if (!r) r = KeywordFunction(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Var (CaretDef)?
  public static boolean RedefinitionVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RedefinitionVariable")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Var(b, l + 1);
    r = r && RedefinitionVariable_1(b, l + 1);
    exit_section_(b, m, REDEFINITION_VARIABLE, r);
    return r;
  }

  // (CaretDef)?
  private static boolean RedefinitionVariable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RedefinitionVariable_1")) return false;
    RedefinitionVariable_1_0(b, l + 1);
    return true;
  }

  // (CaretDef)
  private static boolean RedefinitionVariable_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RedefinitionVariable_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CaretDef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ResultTerm*
  public static boolean Result(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Result")) return false;
    Marker m = enter_section_(b, l, _NONE_, RESULT, "<result>");
    int c = current_position_(b);
    while (true) {
      if (!ResultTerm(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Result", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // Result (COLON Block)*
  public static boolean ResultEx(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResultEx")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESULT_EX, "<result ex>");
    r = Result(b, l + 1);
    r = r && ResultEx_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COLON Block)*
  private static boolean ResultEx_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResultEx_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ResultEx_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ResultEx_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COLON Block
  private static boolean ResultEx_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResultEx_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Atom
  //     | ParenResultTerm
  //     | BracketResultTerm
  //     | SugerCall Result RCHEVRON
  //     | ChevronResultTerm
  //     | Block
  //     | Var
  public static boolean ResultTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResultTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESULT_TERM, "<result term>");
    r = Atom(b, l + 1);
    if (!r) r = ParenResultTerm(b, l + 1);
    if (!r) r = BracketResultTerm(b, l + 1);
    if (!r) r = ResultTerm_3(b, l + 1);
    if (!r) r = ChevronResultTerm(b, l + 1);
    if (!r) r = Block(b, l + 1);
    if (!r) r = Var(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SugerCall Result RCHEVRON
  private static boolean ResultTerm_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResultTerm_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SugerCall(b, l + 1);
    r = r && Result(b, l + 1);
    r = r && consumeToken(b, RCHEVRON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sentenceCorrect | sentenceRecover
  public static boolean Sentence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Sentence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SENTENCE, "<sentence>");
    r = sentenceCorrect(b, l + 1);
    if (!r) r = sentenceRecover(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (Sentence   (SEMICOLON  Sentence)* (SEMICOLON )?) | NativeIns
  public static boolean Sentences(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Sentences")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SENTENCES, "<sentences>");
    r = Sentences_0(b, l + 1);
    if (!r) r = NativeIns(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Sentence   (SEMICOLON  Sentence)* (SEMICOLON )?
  private static boolean Sentences_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Sentences_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Sentence(b, l + 1);
    r = r && Sentences_0_1(b, l + 1);
    r = r && Sentences_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SEMICOLON  Sentence)*
  private static boolean Sentences_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Sentences_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Sentences_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Sentences_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // SEMICOLON  Sentence
  private static boolean Sentences_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Sentences_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    r = r && Sentence(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SEMICOLON )?
  private static boolean Sentences_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Sentences_0_2")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // FuncName Block
  public static boolean SimpleFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleFunction")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FuncName(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, SIMPLE_FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // ADD
  //     | SUB
  //     | MUL
  //     | DIV
  //     | MOD
  //     | RESIDUE
  public static boolean SugerCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SugerCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUGER_CALL, "<suger call>");
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, RESIDUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE
  public static boolean Var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE);
    exit_section_(b, m, VAR, r);
    return r;
  }

  /* ********************************************************** */
  // (ENUM | EENUM) NameList
  public static boolean enumDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDefinition")) return false;
    if (!nextTokenIs(b, "<enum definition>", EENUM, ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEFINITION, "<enum definition>");
    r = enumDefinition_0(b, l + 1);
    r = r && NameList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ENUM | EENUM
  private static boolean enumDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, EENUM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (EXTERN | EXTRN | EXTERNALL ) NameList
  public static boolean externalDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTERNAL_DECLARATION, "<external declaration>");
    r = externalDeclaration_0(b, l + 1);
    r = r && NameList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXTERN | EXTRN | EXTERNALL
  private static boolean externalDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTERN);
    if (!r) r = consumeToken(b, EXTRN);
    if (!r) r = consumeToken(b, EXTERNALL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FORWARD NameList
  public static boolean forwardDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forwardDeclaration")) return false;
    if (!nextTokenIs(b, FORWARD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORWARD);
    r = r && NameList(b, l + 1);
    exit_section_(b, m, FORWARD_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // PatternTerm+
  public static boolean patternRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_RECOVER, "<pattern recover>");
    r = PatternTerm(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!PatternTerm(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "patternRecover", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET NAME Pattern RPAREN
  static boolean patternTermBrackets(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternTermBrackets")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, NAME);
    r = r && Pattern(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN Pattern RPAREN
  static boolean patternTermParens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternTermParens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Pattern(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Pattern ConditionAssignment* ( EQUAL ResultEx | COMMA ResultEx COLON Block )
  static boolean sentenceCorrect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentenceCorrect")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Pattern(b, l + 1);
    r = r && sentenceCorrect_1(b, l + 1);
    r = r && sentenceCorrect_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ConditionAssignment*
  private static boolean sentenceCorrect_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentenceCorrect_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ConditionAssignment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sentenceCorrect_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // EQUAL ResultEx | COMMA ResultEx COLON Block
  private static boolean sentenceCorrect_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentenceCorrect_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sentenceCorrect_2_0(b, l + 1);
    if (!r) r = sentenceCorrect_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUAL ResultEx
  private static boolean sentenceCorrect_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentenceCorrect_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && ResultEx(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA ResultEx COLON Block
  private static boolean sentenceCorrect_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentenceCorrect_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ResultEx(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // patternRecover
  static boolean sentenceRecover(PsiBuilder b, int l) {
    return patternRecover(b, l + 1);
  }

  /* ********************************************************** */
  // (SWAP | ESWAP) NameList
  public static boolean swapDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "swapDefinition")) return false;
    if (!nextTokenIs(b, "<swap definition>", ESWAP, SWAP)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWAP_DEFINITION, "<swap definition>");
    r = swapDefinition_0(b, l + 1);
    r = r && NameList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SWAP | ESWAP
  private static boolean swapDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "swapDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWAP);
    if (!r) r = consumeToken(b, ESWAP);
    exit_section_(b, m, null, r);
    return r;
  }

}
