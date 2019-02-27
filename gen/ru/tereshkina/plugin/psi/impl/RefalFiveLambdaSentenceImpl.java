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

public class RefalFiveLambdaSentenceImpl extends ASTWrapperPsiElement implements RefalFiveLambdaSentence {

  public RefalFiveLambdaSentenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RefalFiveLambdaVisitor visitor) {
    visitor.visitSentence(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RefalFiveLambdaVisitor) accept((RefalFiveLambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RefalFiveLambdaBlock getBlock() {
    return findChildByClass(RefalFiveLambdaBlock.class);
  }

  @Override
  @NotNull
  public List<RefalFiveLambdaConditionAssignment> getConditionAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RefalFiveLambdaConditionAssignment.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaPattern getPattern() {
    return findChildByClass(RefalFiveLambdaPattern.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaResultEx getResultEx() {
    return findChildByClass(RefalFiveLambdaResultEx.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaPatternRecover getPatternRecover() {
    return findChildByClass(RefalFiveLambdaPatternRecover.class);
  }

}
