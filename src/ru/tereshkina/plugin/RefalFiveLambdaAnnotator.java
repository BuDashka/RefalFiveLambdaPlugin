package ru.tereshkina.plugin;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import ru.tereshkina.plugin.psi.RefalFiveLambdaUtils;

import java.util.Arrays;
import java.util.List;

public class RefalFiveLambdaAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement psiElement, @NotNull AnnotationHolder annotationHolder) {
        if (RefalFiveLambdaUtils.isVar(psiElement)) {
            String[] potentialVariables = RefalFiveLambdaUtils.getPredecessorPatternVariables(psiElement, false);
            boolean isPatternVariable = RefalFiveLambdaUtils.isPatternVariable(psiElement);
          //  boolean isAssignmentVariable = RefalFiveLambdaUtils.isAssignmentVariable(psiElement);
            boolean isInPotentialVariables = Arrays.asList(potentialVariables).contains(psiElement.getText());
            if (!isPatternVariable && !isInPotentialVariables) {
                annotationHolder.createErrorAnnotation(RefalFiveLambdaUtils.getTextRange(psiElement), "Unresolved variable");
            }
            if (isPatternVariable && isInPotentialVariables) {
                boolean isRedefinitionVariable = RefalFiveLambdaUtils.isRedefinitonVariable(psiElement);
                if (!isRedefinitionVariable) {
                    annotationHolder.createWeakWarningAnnotation(RefalFiveLambdaUtils.getTextRange(psiElement),
                            "Variable is already defined");
                }
            }

        }

        if (psiElement.toString().equals("PsiElement(RefalFiveLambdaTokenType.NAME)") &&
                psiElement.getParent().toString().equals("RefalFiveLambdaFuncNameImpl(FUNC_NAME)")) {
           // System.out.println(psiElement.getParent().getParent().toString());
            if (!psiElement.getParent().getParent().toString().equals("RefalFiveLambdaKeywordFunctionImpl(KEYWORD_FUNCTION)") &&
                !psiElement.getParent().getParent().toString().equals("RefalFiveLambdaSimpleFunctionImpl(SIMPLE_FUNCTION)")) {
                String[] functionNames = RefalFiveLambdaUtils.getAvailableFunctionNames(psiElement);

                if (!Arrays.asList(functionNames).contains(psiElement.getText())) {
                    annotationHolder.createErrorAnnotation(RefalFiveLambdaUtils.getTextRange(psiElement), "Unresolved function");
                }
            }
        }
    }
}
