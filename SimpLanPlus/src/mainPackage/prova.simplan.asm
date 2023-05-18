move SP FP   //ProgLetInNode 
pushr FP 
move SP AL 
pushr AL 
push 0 //DecVarNode 
push 0 //DecVarNode 
storei A0 42 //IntExpNode 
move AL T1  //AsgNode 
subi T1 1
load A0 0(T1)  //EndAsgNode 
halt  //EndProgLetInNode 
