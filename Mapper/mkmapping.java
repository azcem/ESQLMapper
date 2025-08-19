package Mapper;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.InputStream;

public class mkmapping {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
        CharStream input = CharStreams.fromStream(is);
        ESQLLexer lexer = new ESQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ESQLParser parser = new ESQLParser(tokens);
        ParseTree tree = parser.program(); //parse
        ParseTreeWalker walker = new ParseTreeWalker();
        ESQLBaseListener mapper = new ESQLMapper(args[1], args[2], args[3], args[4]);
        walker.walk(mapper, tree);
    }
}
