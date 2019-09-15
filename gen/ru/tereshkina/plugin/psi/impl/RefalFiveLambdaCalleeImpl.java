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

public class RefalFiveLambdaCalleeImpl extends ASTWrapperPsiElement implements RefalFiveLambdaCallee {

  public RefalFiveLambdaCalleeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RefalFiveLambdaVisitor visitor) {
    visitor.visitCallee(this);
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
  @Nullable
  public RefalFiveLambdaCallee getCallee() {
    return findChildByClass(RefalFiveLambdaCallee.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaFuncName getFuncName() {
    return findChildByClass(RefalFiveLambdaFuncName.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaFuncPtr getFuncPtr() {
    return findChildByClass(RefalFiveLambdaFuncPtr.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaResult getResult() {
    return findChildByClass(RefalFiveLambdaResult.class);
  }

  @Override
  @Nullable
  public RefalFiveLambdaVar getVar() {
    return findChildByClass(RefalFiveLambdaVar.class);
  }

}
