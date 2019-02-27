// This is a generated file. Not intended for manual editing.
package ru.tereshkina.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RefalFiveLambdaSentence extends PsiElement {

  @Nullable
  RefalFiveLambdaBlock getBlock();

  @NotNull
  List<RefalFiveLambdaConditionAssignment> getConditionAssignmentList();

  @Nullable
  RefalFiveLambdaPattern getPattern();

  @Nullable
  RefalFiveLambdaResultEx getResultEx();

  @Nullable
  RefalFiveLambdaPatternRecover getPatternRecover();

}
