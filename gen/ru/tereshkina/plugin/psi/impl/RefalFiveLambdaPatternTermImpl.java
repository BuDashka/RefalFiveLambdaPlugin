// This is a generated file. Not intended for manual editing.
package ru.tereshkina.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ru.tereshkina.plugin.psi.RefalFiveLambdaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ru.tereshkina.plugin.psi.*;

public class RefalFiveLambdaPatternTermImpl extends ASTWrapperPsiElement implements RefalFiveLambdaPatternTerm {

  public RefalFiveLambdaPatternTermImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RefalFiveLambdaVisitor visitor) {
    visitor.visitPatternTerm(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RefalFiveLambdaVisitor) accept((RefalFiveLambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RefalFiveLambdaAssignmentCorrect getAssignmentCorrect() {
    return findChildByClass(RefalFiveLambdaAssignmentCorrect.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaAtom getAtom() {
    return findChildByClass(RefalFiveLambdaAtom.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaConditionCorrect getConditionCorrect() {
    return findChildByClass(RefalFiveLambdaConditionCorrect.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaPattern getPattern() {
    return findChildByClass(RefalFiveLambdaPattern.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaRedefinitionVariable getRedefinitionVariable() {
    return findChildByClass(RefalFiveLambdaRedefinitionVariable.class);
  }

}
