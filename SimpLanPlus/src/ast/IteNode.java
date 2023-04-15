package ast;

public class IteNode implements Node {

        private Node exp;
        private Node then_statement;
        private Node else_statement;

        public IteNode(Node exp, Node then_statement, Node else_statement, int line) {
            this.exp = exp;
            this.then_statement = then_statement;
            this.else_statement = else_statement;
        }

        public IteNode(Node exp, Node then_statement, int line) {
            this.exp = exp;
            this.then_statement = then_statement;
        }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return null;
    }
}
