package ru.tereshkina.plugin.psi;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Contract;
import ru.tereshkina.plugin.psi.impl.RefalFiveLambdaKeywordFunctionImpl;
import ru.tereshkina.plugin.psi.impl.RefalFiveLambdaSimpleFunctionImpl;

import java.util.*;

public class RefalFiveLambdaUtils {
    public static final String SAMPLE = "/*\n" +
            "  Multiple line comments are allowed.\n" +
            "*/\n" +
            "\n" +
            "// And single line comments too.\n" +
            "\n" +
            "//FROM Library\n" +
            "$EXTERN WriteLine;\n" +
            "\n" +
            "//FROM LibraryEx\n" +
            "$EXTERN SaveFile, LoadFile, ArgList;\n" +
            "\n" +
            "$ENUM Encapsulated;\n" +
            "\n" +
            "$EENUM ExportedEnum;\n" +
            "$SWAP LocalVariable;\n" +
            "$ESWAP GlobalVariable;\n" +
            "$LABEL Success, Fails;  // Deprecated keyword\n" +
            "\n" +
            "$ENTRY CreateEncapsulated {\n" +
            "  /* comment */ = #Fails;\n" +
            "\n" +
            "  e.X = [Encapsulated e.X] #Success;\n" +
            "}\n" +
            "\n" +
            "$FORWARD Main;  // Previously it was mandatory, now it is ignored\n" +
            "\n" +
            "$ENTRY Go {\n" +
            "  = <Main <ArgList>>;\n" +
            "}\n" +
            "\n" +
            "%%\n" +
            "void f() {\n" +
            "  // C++ inline code\n" +
            "  for (int i = 0; i < 100; ++i)\n" +
            "    printf(\"%i = 0x%x\n\", i);\n" +
            "\n" +
            "  bool x = 1 < 2 && 3 > 1;\n" +
            "}\n" +
            "%%\n" +
            "\n" +
            "Main {\n" +
            "  (e.ProgName) =\n" +
            "    <WriteLine 'Arguments not found' 10 12>\n" +
            "\n" +
            "  (e.ProgName) e.Files =\n" +
            "    <Map\n" +
            "      {\n" +
            "        (e.NextFile) =\n" +
            "          <SaveFile\n" +
            "            (e.NextFile '.out')\n" +
            "            <LoadFile e.NextFile>\n" +
            "          >;\n" +
            "      }\n" +
            "      e.Files\n" +
            "    >;\n" +
            "}\n" +
            "\n" +
            "$ENTRY NativeFunction {\n" +
            "%%\n" +
            "  // Inline code could be inside functions\n" +
            "  return refalrts::cRecognitionImpossible;\n" +
            "%%\n" +
            "}\n";

    public static boolean isSentence(PsiElement element) {
        return element.toString().equals("RefalFiveLambdaSentenceImpl(SENTENCE)");
    }

    public static boolean isAssignment(PsiElement element) {
        return element.toString().equals("RefalFiveLambdaAssignmentCorrectImpl(ASSIGNMENT_CORRECT)");
    }

    public static boolean isVar(PsiElement element) {
        return element.toString().equals("RefalFiveLambdaVarImpl(VAR)");
    }

    @Contract("_ -> !null")
    public static TextRange getTextRange(PsiElement element) {
        return new TextRange(element.getTextRange().getStartOffset(),
                element.getTextRange().getEndOffset());
    }

    public static boolean isAssignmentVariable(PsiElement element) {
        PsiElement top = element;
        if (!element.toString().equals("RefalFiveLambdaVarImpl(VAR)"))
            return false;

        while (top.getParent() != null) {
            if (top.toString().equals("RefalFiveLambdaAssignmentAssignmentImpl(CONDITION_ASSIGNMENT)")) {
                return true;
            }
            if (!top.toString().equals("RefalFiveLambdaAssignmentCorrectExImpl(ASSIGNMENT_CORRECT)")) {
                return false;
            }
            top = top.getParent();
        }

        return false;
    }

    public static boolean isPatternVariable(PsiElement element) {
        PsiElement top = element;
        if (!element.toString().equals("RefalFiveLambdaVarImpl(VAR)"))
            return false;

        while (top.getParent() != null) {
            if (top.toString().equals("RefalFiveLambdaPatternImpl(PATTERN)"))
                return true;

            //if (top.toString().equals("RefalFiveLambdaResultTermImpl(RESULT_TERM)")) {
              //  return false;
            //}
            top = top.getParent();
        }

        return false;
    }


    private static String[] getVariablesRec(PsiElement top) {
        PsiElement[] aChildren = top.getChildren();
        List<String> lChildVariables = new ArrayList<>();
        for (PsiElement child : aChildren) {
            if (child.toString().equals("RefalFiveLambdaVarImpl(VAR)")) {
                lChildVariables.add(child.getText());
            } else if (child.getChildren().length > 0) {
                String[] result = getVariablesRec(child);
                Collections.addAll(lChildVariables, result);
            }
        }
        String[] aChildVariables = new String[lChildVariables.size()];
        return lChildVariables.toArray(aChildVariables);
    }

    public static String[] getSiblingPatternVariables(PsiElement element) {
        PsiElement top = element;
        List<String> lVariables = new ArrayList<>();
        while (top != null) {
            if (isSentence(top)) {
                break;
            }
            top = top.getParent();
        }

        if (top == null)
            return null;

        for (PsiElement sentence : top.getParent().getChildren()) {
            if (isSentence(sentence)) {
                PsiElement pattern = sentence.getFirstChild();
                String[] tempVariables = getVariablesRec(pattern);
                Collections.addAll(lVariables, tempVariables);
            }
        }
       // for (PsiElement sentence : top.getParent().getChildren()) {
            //if (isSentence(sentence)) {
               // PsiElement conditionAssignment = sentence.getSecon ();
            //    String[] tempVares = getVariablesRec(conditionAssignment);
             //   Collections.addAll(lVariables, tempVares);
            //}
        //}

        String[] aVariables = new String[lVariables.size()];
        return lVariables.toArray(aVariables);
    }


    public static String[] getPredecessorPatternVariables(PsiElement element, boolean includePredecessorPattern) {
        PsiElement top = element;
        List<String> lVariables = new ArrayList<>();
        boolean isMoreThanPredecessor = includePredecessorPattern;

        while (top.getParent() != null) {
            if (isSentence(top.getParent())) {
                boolean isPattern = top.toString().equals("RefalFiveLambdaPatternImpl(PATTERN)");
                boolean isAssignment = top.toString().equals("RefalFiveLambdaAssignmentCorrectExImpl(ASSIGNMENT_CORRECT)");

                if (!isPattern || isMoreThanPredecessor) {
                    String[] tempVariables = getVariablesRec(top.getParent().getFirstChild());
                    Collections.addAll(lVariables, tempVariables);
                    isMoreThanPredecessor = true;
                }
                /*else if (!isAssignment || isMoreThanPredecessorA) {
                    String[] tempVariables = getVariablesRec(top.getParent().getFirstChild());
                    Collections.addAll(lVariables, tempVariables);
                    isMoreThanPredecessorA = true;
                }*/
            }
            top = top.getParent();
        }
        String[] aVariables = new String[lVariables.size()];
        return lVariables.toArray(aVariables);
    }

   /* public static String[] getPredecessorAssignmentVariables(PsiElement element, boolean includePredecessorAssignment) {
        PsiElement top = element;
        List<String> lVariables = new ArrayList<>();
        boolean isMoreThanPredecessor = includePredecessorAssignment;

        while (top.getParent() != null) {
            if (isSentence(top.getParent())) {
                boolean isAssignment = top.toString().equals("RefalFiveLambdaAssignmentCorrectExImpl(ASSIGNMENT_CORRECT)");
                if (!isAssignment || isMoreThanPredecessor) {
                    String[] tempVariables = getVariablesRec(top.getParent().getFirstChild());
                    Collections.addAll(lVariables, tempVariables);
                    isMoreThanPredecessor = true;
                }
            }
            top = top.getParent();
        }
        String[] aVariables = new String[lVariables.size()];
        return lVariables.toArray(aVariables);
    }
*/
    public static boolean isRedefinitonVariable(PsiElement element) {
        if (!element.toString().equals("RefalFiveLambdaVarImpl(VAR)"))
            return false;

        if (element.getParent().toString().equals("RefalFiveLambdaRedefinitionVariableImpl(REDEFINITION_VARIABLE)"))
            return true;

        return false;
    }



    public static String[] getAvailableFunctionNames(PsiElement parameters) {
        PsiElement top = parameters;

        List<String> lFunctionNames = new ArrayList<>();
        lFunctionNames.add("Add");
        lFunctionNames.add("Arg");
        lFunctionNames.add("Br");
        lFunctionNames.add("Chr");
        lFunctionNames.add("Card");
        lFunctionNames.add("Cp");
        lFunctionNames.add("Dg");
        lFunctionNames.add("Dgall");
        lFunctionNames.add("Div");
        lFunctionNames.add("Divmod");
        lFunctionNames.add("Explode");
        lFunctionNames.add("First");
        lFunctionNames.add("Get");
        lFunctionNames.add("Implode");
        lFunctionNames.add("Last");
        lFunctionNames.add("Lenw");
        lFunctionNames.add("Lower");
        lFunctionNames.add("Mod");
        lFunctionNames.add("Mul");
        lFunctionNames.add("Numb");
        lFunctionNames.add("Open");
        lFunctionNames.add("Ord");
        lFunctionNames.add("Print");
        lFunctionNames.add("Prout");
        lFunctionNames.add("Put");
        lFunctionNames.add("Putout");
        lFunctionNames.add("Rp");
        lFunctionNames.add("Step");
        lFunctionNames.add("Sub");
        lFunctionNames.add("Symb");
        lFunctionNames.add("Time");
        lFunctionNames.add("Type");
        lFunctionNames.add("Upper");
        lFunctionNames.add("Sysfun");
        lFunctionNames.add("Resudue");
        lFunctionNames.add("GetEnv");
        lFunctionNames.add("Exit");
        lFunctionNames.add("Close");
        lFunctionNames.add("ExistFile");
        lFunctionNames.add("GetCurrentDirrectory");
        lFunctionNames.add("RemoveFile");
        lFunctionNames.add("Implode_Ext");
        lFunctionNames.add("Explode_Ext");
        lFunctionNames.add("TimeElapsed");
        lFunctionNames.add("Compare");
        lFunctionNames.add("DeSysfun");
        lFunctionNames.add("Random");
        lFunctionNames.add("RandomDigit");
        lFunctionNames.add("Write");
        lFunctionNames.add("ListOfBuiltin");
        lFunctionNames.add("SizeOf");
        lFunctionNames.add("GetPID");
        lFunctionNames.add("GetPPID");


        lFunctionNames.add("Map");
        lFunctionNames.add("MapReduce");
        lFunctionNames.add("Inc");
        lFunctionNames.add("Max");


        while (!top.toString().equals("RefalFiveLambdaProgramElementImpl(PROGRAM_ELEMENT)")) {
            top = top.getParent();
        }

        PsiElement parent = top.getParent();
        for (PsiElement programElement : parent.getChildren()) {
            if (programElement.toString().equals("RefalFiveLambdaProgramElementImpl(PROGRAM_ELEMENT)")
                    && programElement.getChildren().length > 0) {
                PsiElement functionDefinition = programElement.getFirstChild();
                if ( functionDefinition instanceof RefalFiveLambdaKeywordFunctionImpl ||
                        functionDefinition instanceof RefalFiveLambdaSimpleFunctionImpl
                        ) {
                    PsiElement[] functionDefinitionChildren = functionDefinition.getChildren();
                    for (PsiElement child : functionDefinitionChildren) {
                        if (child.toString().equals("RefalFiveLambdaFuncNameImpl(FUNC_NAME)")) {
                            lFunctionNames.add(child.getText());
                            break;
                        }
                    }
                }
            }
        }
      //  System.out.println(lFunctionNames);

        while (top.getParent() != null && !top.toString().equals("Refal Five Lambda File"))
            top = top.getParent();

        Set<String> FUNC_CONTAINERS = new HashSet<>();
        FUNC_CONTAINERS.add("RefalFiveLambdaExternalDeclarationImpl(EXTERNAL_DECLARATION)");
        FUNC_CONTAINERS.add("RefalFiveLambdaEnumDefinitionImpl(ENUM_DEFINITION)");
        FUNC_CONTAINERS.add("RefalFiveLambdaSwapDefinitionImpl(SWAP_DEFINITION)");

        for (PsiElement programElement : top.getChildren()) {
            if (programElement.getChildren().length > 0) {
               // System.out.println("1:" + programElement.getFirstChild().toString());
                if (FUNC_CONTAINERS.contains(programElement.getFirstChild().toString())) {
                    PsiElement nameList = programElement.getFirstChild().getLastChild();
                    PsiElement name = nameList.getFirstChild();
                //    System.out.println("3:" +  programElement.getFirstChild().getLastChild().toString());
                  //  System.out.println("4:" +  nameList.getFirstChild().toString());

                    while (name != null) {
                        if (name.toString().equals("PsiElement(RefalFiveLambdaTokenType.NAME)")) {
                            lFunctionNames.add(name.getText());
                        }
                        name = name.getNextSibling();
                    }
                }
              //  System.out.println("5:" +  lFunctionNames);

            }
        }

        String[] aFunctionNames = new String[lFunctionNames.size()];
        return lFunctionNames.toArray(aFunctionNames);
    }
}
