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

public class RefalFiveLambdaProgramElementImpl extends ASTWrapperPsiElement implements RefalFiveLambdaProgramElement {

  public RefalFiveLambdaProgramElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RefalFiveLambdaVisitor visitor) {
    visitor.visitProgramElement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RefalFiveLambdaVisitor) accept((RefalFiveLambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RefalFiveLambdaIncludeDec getIncludeDec() {
    return findChildByClass(RefalFiveLambdaIncludeDec.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaKeywordFunction getKeywordFunction() {
    return findChildByClass(RefalFiveLambdaKeywordFunction.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaNativeIns getNativeIns() {
    return findChildByClass(RefalFiveLambdaNativeIns.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaSimpleFunction getSimpleFunction() {
    return findChildByClass(RefalFiveLambdaSimpleFunction.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaEnumDefinition getEnumDefinition() {
    return findChildByClass(RefalFiveLambdaEnumDefinition.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaExternalDeclaration getExternalDeclaration() {
    return findChildByClass(RefalFiveLambdaExternalDeclaration.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaForwardDeclaration getForwardDeclaration() {
    return findChildByClass(RefalFiveLambdaForwardDeclaration.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaSwapDefinition getSwapDefinition() {
    return findChildByClass(RefalFiveLambdaSwapDefinition.class);
  }

}
