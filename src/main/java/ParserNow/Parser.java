/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParserNow;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.printer.YamlPrinter;
import com.github.javaparser.resolution.declarations.ResolvedTypeDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.SymbolReference;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gopesh
 */
public class Parser {
static CombinedTypeSolver combinedTypeSolver;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try 
        {
            combinedTypeSolver = new CombinedTypeSolver();
            combinedTypeSolver.add(new ReflectionTypeSolver());
            combinedTypeSolver.add(new JarTypeSolver("android.jar"));
            combinedTypeSolver.add(new JavaParserTypeSolver("/home/gopesh/NetBeansProjects/ParserNow/src/main/java"));
            CompilationUnit cu = JavaParser.parse(new FileInputStream("/home/gopesh/NetBeansProjects/ParserNow/src/main/java/ParserNow/MainActivity.java"));
            VoidVisitor<?> methodNameVisitor = new MethodNamePrinter();
           // methodNameVisitor.visit(cu, null); 
           
            ClassOrInterfaceDeclaration classX = cu.getClassByName("ReversePolishNotation").get();            
            methodNameVisitor.visit(classX.getMethodsByName("calc").get(0), null);
        } catch (Exception ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static class MethodNamePrinter extends VoidVisitorAdapter<Void> {

       @Override
       public void visit(MethodCallExpr  md, Void arg) 
       {
            super.visit(md, arg);
            System.out.println(md+" "+md.getBegin().get().line);
            //try{
             //   System.out.println(md.getNameAsString()+"  "+md.getArgument(0).toString());
              //  System.out.println(md.getChildNodes().get(0)+" "+md.getBegin().get().line);
               // System.out.println(md+"  "+md.resolveInvokedMethod().getQualifiedName());
     //           System.out.println(JavaParserFacade.get(combinedTypeSolver).solveMethodAsUsage(md).declaringType().getQualifiedName()+"  "+md.getNameAsString());
              // System.out.println(JavaParserFacade.get(combinedTypeSolver).solve(md).getCorrespondingDeclaration().declaringType().getQualifiedName()+"   "+md.getNameAsString());
               // System.out.println(JavaParserFacade.get(combinedTypeSolver).getType(md.getScope().get().asNameExpr()).asReferenceType().getQualifiedName()+" "+md.getName()+"  "+md.getBegin().get().line);
            //}catch(Exception ex){}
            /*
                Restrict to one method only
                ClassOrInterfaceDeclaration classX = cu.getClassByName("X");

                for (MethodDeclaration method : classX.getMethods()) 
                {
                    // Make the visitor go through everything inside the method.
                    method.accept(new MethodCallVisitor(), null);
                }
            */
       }
        
      /* @Override
       public void visit(AssignExpr  md, Void arg) 
       {
            super.visit(md, arg);  
            System.err.println(JavaParserFacade.get(combinedTypeSolver).getType(md.getChildNodes().get(0)).describe()+"     "+md.getChildNodes().get(0).toString()+" || "+md+" Assign expression: "+md.getBegin().get().line); 
            
       }*/
       @Override
       public void visit(FieldAccessExpr md, Void arg) 
       {
            super.visit(md, arg);
           
          // System.out.println(md+"  "+md.getBegin().get().line+" child = "+md.getChildNodes().size());
         //   System.out.println(md);
            /*
            VariableDeclarator
            System.out.println(md+"  "+md.getNameAsString()+"   "+md.getTypeAsString());
            */
            /*
            NameExpr
            reject static symbols + find whether local variable or class variable + get type of variable
            + get if it is a parameter.
            JavaParserFacade jprs=JavaParserFacade.get(combinedTypeSolver);
            SymbolReference ref=jprs.solve(md);            
            if(ref.isSolved())
            {                
                System.out.println(ref.getCorrespondingDeclaration().isField()+"  "+md.getBegin().get().line+"  "+md+" "+jprs.getType(md).describe());
            }*/
          //VariableDeclarator  System.err.println(md+"  "+JavaParserFacade.get(combinedTypeSolver).convertToUsageVariableType(md).describe());           
       }
    }
}
