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

public class RefalFiveLambdaConditionAssignmentImpl extends ASTWrapperPsiElement implements RefalFiveLambdaConditionAssignment {

  public RefalFiveLambdaConditionAssignmentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RefalFiveLambdaVisitor visitor) {
    visitor.visitConditionAssignment(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RefalFiveLambdaVisitor) accept((RefalFiveLambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RefalFiveLambdaAssignmentInCorrect getAssignmentInCorrect() {
    return findChildByClass(RefalFiveLambdaAssignmentInCorrect.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaConditionInCorrect getConditionInCorrect() {
    return findChildByClass(RefalFiveLambdaConditionInCorrect.class);
  }

}
