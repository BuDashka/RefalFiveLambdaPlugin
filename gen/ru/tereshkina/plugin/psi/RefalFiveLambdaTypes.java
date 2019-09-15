// This is a generated file. Not intended for manual editing.
package ru.tereshkina.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ru.tereshkina.plugin.psi.impl.*;

public interface RefalFiveLambdaTypes {

  IElementType ASSIGNMENT_CORRECT = new RefalFiveLambdaElementType("ASSIGNMENT_CORRECT");
  IElementType ASSIGNMENT_IN_CORRECT = new RefalFiveLambdaElementType("ASSIGNMENT_IN_CORRECT");
  IElementType ATOM = new RefalFiveLambdaElementType("ATOM");
  IElementType BLOCK = new RefalFiveLambdaElementType("BLOCK");
  IElementType CALLEE = new RefalFiveLambdaElementType("CALLEE");
  IElementType CARET_DEF = new RefalFiveLambdaElementType("CARET_DEF");
  IElementType COMMENT = new RefalFiveLambdaElementType("COMMENT");
  IElementType CONDITION_ASSIGNMENT = new RefalFiveLambdaElementType("CONDITION_ASSIGNMENT");
  IElementType CONDITION_CORRECT = new RefalFiveLambdaElementType("CONDITION_CORRECT");
  IElementType CONDITION_IN_CORRECT = new RefalFiveLambdaElementType("CONDITION_IN_CORRECT");
  IElementType ENUM_DEFINITION = new RefalFiveLambdaElementType("ENUM_DEFINITION");
  IElementType EXTERNAL_DECLARATION = new RefalFiveLambdaElementType("EXTERNAL_DECLARATION");
  IElementType FORWARD_DECLARATION = new RefalFiveLambdaElementType("FORWARD_DECLARATION");
  IElementType FUNC_NAME = new RefalFiveLambdaElementType("FUNC_NAME");
  IElementType FUNC_PTR = new RefalFiveLambdaElementType("FUNC_PTR");
  IElementType IDENTIFIER = new RefalFiveLambdaElementType("IDENTIFIER");
  IElementType INCLUDE_DEC = new RefalFiveLambdaElementType("INCLUDE_DEC");
  IElementType KEYWORD_FUNCTION = new RefalFiveLambdaElementType("KEYWORD_FUNCTION");
  IElementType NAME_LIST = new RefalFiveLambdaElementType("NAME_LIST");
  IElementType NATIVE_INS = new RefalFiveLambdaElementType("NATIVE_INS");
  IElementType PATTERN = new RefalFiveLambdaElementType("PATTERN");
  IElementType PATTERN_RECOVER = new RefalFiveLambdaElementType("PATTERN_RECOVER");
  IElementType PATTERN_TERM = new RefalFiveLambdaElementType("PATTERN_TERM");
  IElementType PROGRAM_ELEMENT = new RefalFiveLambdaElementType("PROGRAM_ELEMENT");
  IElementType REDEFINITION_VARIABLE = new RefalFiveLambdaElementType("REDEFINITION_VARIABLE");
  IElementType RESULT = new RefalFiveLambdaElementType("RESULT");
  IElementType RESULT_EX = new RefalFiveLambdaElementType("RESULT_EX");
  IElementType RESULT_TERM = new RefalFiveLambdaElementType("RESULT_TERM");
  IElementType SENTENCE = new RefalFiveLambdaElementType("SENTENCE");
  IElementType SENTENCES = new RefalFiveLambdaElementType("SENTENCES");
  IElementType SIMPLE_FUNCTION = new RefalFiveLambdaElementType("SIMPLE_FUNCTION");
  IElementType SPEC_DIRECTIVE = new RefalFiveLambdaElementType("SPEC_DIRECTIVE");
  IElementType SUGER_CALL = new RefalFiveLambdaElementType("SUGER_CALL");
  IElementType SWAP_DEFINITION = new RefalFiveLambdaElementType("SWAP_DEFINITION");
  IElementType VAR = new RefalFiveLambdaElementType("VAR");

  IElementType ADD = new RefalFiveLambdaTokenType("ADD");
  IElementType AMPERSAND = new RefalFiveLambdaTokenType("AMPERSAND");
  IElementType CARET = new RefalFiveLambdaTokenType("CARET");
  IElementType COLON = new RefalFiveLambdaTokenType("COLON");
  IElementType COMMA = new RefalFiveLambdaTokenType("COMMA");
  IElementType COMPOUND = new RefalFiveLambdaTokenType("COMPOUND");
  IElementType DIV = new RefalFiveLambdaTokenType("DIV");
  IElementType DRIVE = new RefalFiveLambdaTokenType("DRIVE");
  IElementType EENUM = new RefalFiveLambdaTokenType("EENUM");
  IElementType ENTRY = new RefalFiveLambdaTokenType("ENTRY");
  IElementType ENUM = new RefalFiveLambdaTokenType("ENUM");
  IElementType EQUAL = new RefalFiveLambdaTokenType("EQUAL");
  IElementType ESWAP = new RefalFiveLambdaTokenType("ESWAP");
  IElementType EXTERN = new RefalFiveLambdaTokenType("EXTERN");
  IElementType EXTERNALL = new RefalFiveLambdaTokenType("EXTERNALL");
  IElementType EXTRN = new RefalFiveLambdaTokenType("EXTRN");
  IElementType FORWARD = new RefalFiveLambdaTokenType("FORWARD");
  IElementType INCLUDE = new RefalFiveLambdaTokenType("INCLUDE");
  IElementType INLINE = new RefalFiveLambdaTokenType("INLINE");
  IElementType INTEGER_LITERAL = new RefalFiveLambdaTokenType("INTEGER_LITERAL");
  IElementType LBRACE = new RefalFiveLambdaTokenType("LBRACE");
  IElementType LBRACKET = new RefalFiveLambdaTokenType("LBRACKET");
  IElementType LCHEVRON = new RefalFiveLambdaTokenType("LCHEVRON");
  IElementType LINE_COMMENT = new RefalFiveLambdaTokenType("LINE_COMMENT");
  IElementType LPAREN = new RefalFiveLambdaTokenType("LPAREN");
  IElementType MOD = new RefalFiveLambdaTokenType("MOD");
  IElementType MUL = new RefalFiveLambdaTokenType("MUL");
  IElementType MULTILINE_COMMENT = new RefalFiveLambdaTokenType("MULTILINE_COMMENT");
  IElementType NAME = new RefalFiveLambdaTokenType("NAME");
  IElementType NATIVE_IN = new RefalFiveLambdaTokenType("NATIVE_IN");
  IElementType QUOTEDSTRING = new RefalFiveLambdaTokenType("QUOTEDSTRING");
  IElementType RBRACE = new RefalFiveLambdaTokenType("RBRACE");
  IElementType RBRACKET = new RefalFiveLambdaTokenType("RBRACKET");
  IElementType RCHEVRON = new RefalFiveLambdaTokenType("RCHEVRON");
  IElementType RESIDUE = new RefalFiveLambdaTokenType("RESIDUE");
  IElementType RPAREN = new RefalFiveLambdaTokenType("RPAREN");
  IElementType SEMICOLON = new RefalFiveLambdaTokenType("SEMICOLON");
  IElementType SHARP = new RefalFiveLambdaTokenType("SHARP");
  IElementType SPEC = new RefalFiveLambdaTokenType("SPEC");
  IElementType SUB = new RefalFiveLambdaTokenType("SUB");
  IElementType SWAP = new RefalFiveLambdaTokenType("SWAP");
  IElementType VARIABLE = new RefalFiveLambdaTokenType("VARIABLE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGNMENT_CORRECT) {
        return new RefalFiveLambdaAssignmentCorrectImpl(node);
      }
      else if (type == ASSIGNMENT_IN_CORRECT) {
        return new RefalFiveLambdaAssignmentInCorrectImpl(node);
      }
      else if (type == ATOM) {
        return new RefalFiveLambdaAtomImpl(node);
      }
      else if (type == BLOCK) {
        return new RefalFiveLambdaBlockImpl(node);
      }
      else if (type == CALLEE) {
        return new RefalFiveLambdaCalleeImpl(node);
      }
      else if (type == CARET_DEF) {
        return new RefalFiveLambdaCaretDefImpl(node);
      }
      else if (type == COMMENT) {
        return new RefalFiveLambdaCommentImpl(node);
      }
      else if (type == CONDITION_ASSIGNMENT) {
        return new RefalFiveLambdaConditionAssignmentImpl(node);
      }
      else if (type == CONDITION_CORRECT) {
        return new RefalFiveLambdaConditionCorrectImpl(node);
      }
      else if (type == CONDITION_IN_CORRECT) {
        return new RefalFiveLambdaConditionInCorrectImpl(node);
      }
      else if (type == ENUM_DEFINITION) {
        return new RefalFiveLambdaEnumDefinitionImpl(node);
      }
      else if (type == EXTERNAL_DECLARATION) {
        return new RefalFiveLambdaExternalDeclarationImpl(node);
      }
      else if (type == FORWARD_DECLARATION) {
        return new RefalFiveLambdaForwardDeclarationImpl(node);
      }
      else if (type == FUNC_NAME) {
        return new RefalFiveLambdaFuncNameImpl(node);
      }
      else if (type == FUNC_PTR) {
        return new RefalFiveLambdaFuncPtrImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new RefalFiveLambdaIdentifierImpl(node);
      }
      else if (type == INCLUDE_DEC) {
        return new RefalFiveLambdaIncludeDecImpl(node);
      }
      else if (type == KEYWORD_FUNCTION) {
        return new RefalFiveLambdaKeywordFunctionImpl(node);
      }
      else if (type == NAME_LIST) {
        return new RefalFiveLambdaNameListImpl(node);
      }
      else if (type == NATIVE_INS) {
        return new RefalFiveLambdaNativeInsImpl(node);
      }
      else if (type == PATTERN) {
        return new RefalFiveLambdaPatternImpl(node);
      }
      else if (type == PATTERN_RECOVER) {
        return new RefalFiveLambdaPatternRecoverImpl(node);
      }
      else if (type == PATTERN_TERM) {
        return new RefalFiveLambdaPatternTermImpl(node);
      }
      else if (type == PROGRAM_ELEMENT) {
        return new RefalFiveLambdaProgramElementImpl(node);
      }
      else if (type == REDEFINITION_VARIABLE) {
        return new RefalFiveLambdaRedefinitionVariableImpl(node);
      }
      else if (type == RESULT) {
        return new RefalFiveLambdaResultImpl(node);
      }
      else if (type == RESULT_EX) {
        return new RefalFiveLambdaResultExImpl(node);
      }
      else if (type == RESULT_TERM) {
        return new RefalFiveLambdaResultTermImpl(node);
      }
      else if (type == SENTENCE) {
        return new RefalFiveLambdaSentenceImpl(node);
      }
      else if (type == SENTENCES) {
        return new RefalFiveLambdaSentencesImpl(node);
      }
      else if (type == SIMPLE_FUNCTION) {
        return new RefalFiveLambdaSimpleFunctionImpl(node);
      }
      else if (type == SPEC_DIRECTIVE) {
        return new RefalFiveLambdaSpecDirectiveImpl(node);
      }
      else if (type == SUGER_CALL) {
        return new RefalFiveLambdaSugerCallImpl(node);
      }
      else if (type == SWAP_DEFINITION) {
        return new RefalFiveLambdaSwapDefinitionImpl(node);
      }
      else if (type == VAR) {
        return new RefalFiveLambdaVarImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
