package ru.tereshkina.plugin;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.apache.commons.lang.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import ru.tereshkina.plugin.psi.RefalFiveLambdaTypes;
import ru.tereshkina.plugin.psi.RefalFiveLambdaUtils;

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
        //                System.out.println("addCompletions");
          //              System.out.println("0:" + parameters.getPosition().toString());
            //            System.out.println("0:" + parameters.getPosition().getParent().toString());
              //          System.out.println("0:" + parameters.getPosition().getParent().getParent().toString());
                        if (parameters.getPosition().getParent().getParent().
                                        toString().equals("RefalFiveLambdaFuncPtrImpl(FUNC_PTR)") ||
                                parameters.getPosition().getParent().getParent().
                                toString().equals("RefalFiveLambdaResultTermImpl(RESULT_TERM)") ||
                                parameters.getPosition().getParent().getParent().
                                        toString().equals("RefalFiveLambdaCalleeImpl(CALLEE)"))
                        {
                //            System.out.println("1:" + parameters.getPosition().toString());
                            String[] functionNames = RefalFiveLambdaUtils.getAvailableFunctionNames(parameters.getPosition());
                            for (String functionName : functionNames) {
                                resultSet.addElement(LookupElementBuilder.create(functionName));
                            }
                  //          System.out.println("3:" + parameters.getPosition().toString());
                        }
                    }
                }
        );


    }


}