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

public class RefalFiveLambdaVarImpl extends ASTWrapperPsiElement implements RefalFiveLambdaVar {

  public RefalFiveLambdaVarImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RefalFiveLambdaVisitor visitor) {
    visitor.visitVar(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RefalFiveLambdaVisitor) accept((RefalFiveLambdaVisitor)visitor);
    else super.accept(visitor);
  }

}
