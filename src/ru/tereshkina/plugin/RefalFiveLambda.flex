package ru.tereshkina.plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import ru.tereshkina.plugin.psi.RefalFiveLambdaTypes;
import com.intellij.psi.TokenType;

%%

%class RefalFiveLambdaLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
FIRST_NAME_CHAR=[a-zA-Z]            //added Small a-z
NAME_CHAR=[a-zA-Z_\-0-9]
VARIABLE_TYPE = "s"|"t"|"e"

MULTILINE_COMMENT=(("/*"|"/**")[^"*"]{COMMENT_TAIL})|"/*"
COMMENT_TAIL=([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
//END_OF_LINE_COMMENT=("/""/"|"*")[^\r\n]*
LINE_COMMENT = "*"[^\r\n]*

CPP_INLINE = "%%"\n(([^%\n].*|%|%[^%\n].*)?\n)*%%

//STRING_LITERAL=\'([^\\\'\r\n]|{ESCAPE_SEQUENCE})*\'
//CHAR_LETERAL = \"([^\\\'\r\n]|{ESCAPE_SEQUENCE})*\"
//ESCAPE_SEQUENCE=\\[^\r\n\t\\\"\'\<\>\(\)]
STRING_LITERAL=\'([^\\\'\r\n]|{ESCAPE_SEQUENCE})*\'
CHAR_LETERAL = \"([^\\\"\r\n]|{ESCAPE_SEQUENCE})*\"
ESCAPE_SEQUENCE=\\([rnt\\\"\'\<\>\(\)]|x[0-9a-fA-F][0-9a-fA-F])


DIGIT=[0-9]
DECIMAL_INTEGER_LITERAL={DIGIT}+
INTEGER_LITERAL={DECIMAL_INTEGER_LITERAL}


%state CPP_INLINE

%%

//<CPP_INLINE> {
  //  ^{CPP_INLINE_DELIMETER}$    { yybegin(YYINITIAL); return RefalFiveLambdaTypes.CPP_INLINE; }
    //. { yybegin(CPP_INLINE); }
//}

<YYINITIAL> {

  //  ^{CPP_INLINE_DELIMETER}$       { yybegin(CPP_INLINE); }

    "$ENUM"         { return RefalFiveLambdaTypes.ENUM; }
    "$EENUM"        { return RefalFiveLambdaTypes.EENUM; }
    "$SWAP"         { return RefalFiveLambdaTypes.SWAP; }
    "$ESWAP"        { return RefalFiveLambdaTypes.ESWAP; }
    "$INCLUDE"      { return RefalFiveLambdaTypes.INCLUDE; }
    "$EXTERN"       { return RefalFiveLambdaTypes.EXTERN; }
    "$EXTRN"        { return RefalFiveLambdaTypes.EXTRN; }
    "$EXTERNAL"     { return RefalFiveLambdaTypes.EXTERNALL; }
    "$ENTRY"        { return RefalFiveLambdaTypes.ENTRY; }
    "$INLINE"       { return RefalFiveLambdaTypes.INLINE; }
    "$DRIVE"        { return RefalFiveLambdaTypes.DRIVE; }
    "$SPEC"         { return RefalFiveLambdaTypes.SPEC; }
    "$FORWARD"      { return RefalFiveLambdaTypes.FORWARD; }


    "#"  { return RefalFiveLambdaTypes.SHARP; }
    "&"  { return RefalFiveLambdaTypes.AMPERSAND; }
    ","  { return RefalFiveLambdaTypes.COMMA; }
    ";"  { return RefalFiveLambdaTypes.SEMICOLON; }
    ":"  { return RefalFiveLambdaTypes.COLON; }
    "{"  { return RefalFiveLambdaTypes.LBRACE; }
    "}"  { return RefalFiveLambdaTypes.RBRACE; }
    "("  { return RefalFiveLambdaTypes.LPAREN; }
    ")"  { return RefalFiveLambdaTypes.RPAREN; }
    "["  { return RefalFiveLambdaTypes.LBRACKET; }
    "]"  { return RefalFiveLambdaTypes.RBRACKET; }
    "<"  { return RefalFiveLambdaTypes.LCHEVRON; }
    ">"  { return RefalFiveLambdaTypes.RCHEVRON; }
    "="  { return RefalFiveLambdaTypes.EQUAL; }
    "\^"  { return RefalFiveLambdaTypes.CARET; }
    "<+" { return RefalFiveLambdaTypes.ADD; }
    "<-" { return RefalFiveLambdaTypes.SUB; }
    "<*" { return RefalFiveLambdaTypes.MUL; }
    "</" { return RefalFiveLambdaTypes.DIV; }
    "<%" { return RefalFiveLambdaTypes.MOD; }
    "<?" { return RefalFiveLambdaTypes.RESIDUE; }


    {VARIABLE_TYPE}"."{NAME_CHAR}+      { return RefalFiveLambdaTypes.VARIABLE; }
    {FIRST_NAME_CHAR}{NAME_CHAR}*       { return RefalFiveLambdaTypes.NAME; }

    {MULTILINE_COMMENT}    { return RefalFiveLambdaTypes.MULTILINE_COMMENT; }
    //{END_OF_LINE_COMMENT}  { return RefalFiveLambdaTypes.END_OF_LINE_COMMENT; }
    {LINE_COMMENT}         { return RefalFiveLambdaTypes.LINE_COMMENT; }

    {STRING_LITERAL}       { return RefalFiveLambdaTypes.QUOTEDSTRING; }
    {CHAR_LETERAL}         { return RefalFiveLambdaTypes.COMPOUND; }
    {INTEGER_LITERAL}      { return RefalFiveLambdaTypes.INTEGER_LITERAL; }

    ({CRLF}|{WHITE_SPACE})+ { return TokenType.WHITE_SPACE; }
    {CPP_INLINE}            {return RefalFiveLambdaTypes.NATIVE_IN;}


    .                       { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}
