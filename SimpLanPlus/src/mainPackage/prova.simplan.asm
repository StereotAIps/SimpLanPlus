move SP FP   //ProgLetInNode 
pushr FP 
move SP AL 
pushr AL 
push 0 //DecVarNode 
push 0 //DecVarNode 
//IfStmNode 
storei A0 1 //BoolExpNode 
storei T1 1 
beq A0 T1 label0
storei A0 1 //IntExpNode 
move AL T1  //AsgNode 
subi T1 1
load A0 0(T1)  //EndAsgNode 
b label1
label0:
storei A0 2 //IntExpNode 
move AL T1  //AsgNode 
subi T1 1
load A0 0(T1)  //EndAsgNode 
label1:
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
move AL T1  //AsgNode 
subi T1 2
load A0 0(T1)  //EndAsgNode 
halt  //EndProgLetInNode 
