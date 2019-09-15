package ru.tereshkina.plugin;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.apache.commons.lang.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import ru.tereshkina.plugin.psi.RefalFiveLambdaTypes;
import ru.tereshkina.plugin.psi.RefalFiveLambdaUtils;
import ru.tereshkina.plugin.psi.impl.RefalFiveLambdaCalleeImpl;
import ru.tereshkina.plugin.psi.impl.RefalFiveLambdaFuncPtrImpl;
import ru.tereshkina.plugin.psi.impl.RefalFiveLambdaResultTermImpl;

import java.util.Collections;

import static ru.tereshkina.plugin.psi.RefalFiveLambdaTypes.FUNC_PTR;


public class RefalFiveLambdaCompletionContributor extends CompletionContributor {
    public RefalFiveLambdaCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(RefalFiveLambdaTypes.VARIABLE).withLanguage(RefalFiveLambdaLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        String[] predecessorVariables = RefalFiveLambdaUtils.getPredecessorPatternVariables(parameters.getPosition().getParent(), true);
                        String[] siblingPatternVariables = RefalFiveLambdaUtils.getSiblingPatternVariables(parameters.getPosition().getParent());
                        String[] potentials = (String[]) ArrayUtils.addAll(predecessorVariables, siblingPatternVariables);
                        if (potentials.length > 0) {
                            for (String var : potentials) {
                                resultSet.addElement(LookupElementBuilder.create(var));
                            }
                        }
                    }
                }
        );

        extend(CompletionType.BASIC,
                //бло исправление
                PlatformPatterns.psiElement(RefalFiveLambdaTypes.NAME).withLanguage(RefalFiveLambdaLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement elem = parameters.getPosition().getParent();
                        PsiElement parent = null;
                        if (elem != null) {
                            parent = elem.getParent();
                        }
                        if (parent instanceof RefalFiveLambdaFuncPtrImpl
                                || parent instanceof RefalFiveLambdaResultTermImpl
                                || parent instanceof RefalFiveLambdaCalleeImpl) {
                            String[] functionNames = RefalFiveLambdaUtils.getAvailableFunctionNames(parameters.getPosition());
                            for (String functionName : functionNames) {
                                resultSet.addElement(LookupElementBuilder.create(functionName));
                            }
                        }
                    }
                }
        );


    }


}