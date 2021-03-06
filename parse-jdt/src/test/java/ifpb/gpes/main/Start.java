package ifpb.gpes.main;
//package br.edu.ifpb.scm.api.git

import ifpb.gpes.io.SmartFile;
import ifpb.gpes.jdt.PrintASTVisitor;
import ifpb.gpes.jdt.SmartASTParser;
import ifpb.gpes.jdt.SmartAllVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 02/06/2017, 16:41:58
 */
public class Start {

//    static SmartRecursiveVisitor visitor = new SmartRecursiveVisitor();
    static SmartAllVisitor visitor = new SmartAllVisitor();
//    static PrintASTVisitor visitor = new PrintASTVisitor();

    public static void main(String[] args) {
        String path = "/home/juan/facul/periodo4/projetoDePesquisa/parse-review/parse-jdt/src/test/java/ifpb/gpes/jdt/"
                + "samples/LambdaAndAnonymous.java";
        String sources = "/home/juan/facul/periodo4/projetoDePesquisa/parse-review/parse-jdt/src/test/java";
//        String path = "/Users/job/Documents/dev/gpes/parse-review/parse-jdt/src/main/java/ifpb/gpes/jdt/samples/X.java";
//        String sources ="/Users/job/Documents/dev/gpes/parse-review/parse-jdt/src/main/java/";
//        String path = "/Users/job/Documents/dev/gpes/parse-review/parse-jdt/src/test/java/ifpb/gpes/jdt/samples/ClasseAnonima.java";
//        String[] sources = {"/Users/job/Documents/dev/gpes/parse-review/parse-jdt/src/test/java/"};
        SmartFile smart = SmartFile.from(Paths.get(path));
        SmartASTParser parser = SmartASTParser.from(sources);

        Stream<Path> files = smart.extension(".java");

        files.forEach(p -> {
            parser.updateUnitName(p);
            parser.acceptVisitor(visitor);
        });

        visitor.methodsCall()
                .forEach(n -> System.out.println(n.callGraph()));
    }

}
