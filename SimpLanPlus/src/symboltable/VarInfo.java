package symboltable;

import ast.Types.Type;

public class VarInfo {
    private boolean assigned;


    public VarInfo() {
        assigned = false;
    }

    public VarInfo(boolean _assigned) {
        assigned = _assigned;
    }

    public String toPrint(){
        return (assigned? "true": "false");
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }


    public boolean equals(VarInfo object) {
        return (object.assigned==this.assigned);
    }
}