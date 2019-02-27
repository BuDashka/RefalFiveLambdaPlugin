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

public class RefalFiveLambdaResultExImpl extends ASTWrapperPsiElement implements RefalFiveLambdaResultEx {

  public RefalFiveLambdaResultExImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RefalFiveLambdaVisitor visitor) {
    visitor.visitResultEx(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RefalFiveLambdaVisitor) accept((RefalFiveLambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RefalFiveLambdaBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RefalFiveLambdaBlock.class);
  }

  @Override
  @NotNull
  public RefalFiveLambdaResult getResult() {
    return findNotNullChildByClass(RefalFiveLambdaResult.class);
  }

}
