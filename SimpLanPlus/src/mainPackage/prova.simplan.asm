move SP FP   //ProgLetInNode 
pushr FP 
move SP AL 
pushr AL 
storei A0 2 //IntExpNode 
pushr A0 //AsgNode 
//IfStmNode 
move AL T1  //IdExpNode 
subi T1 3
store A0 0(T1)  //EndIdExpNode 
pushr A0  //CompExpNode 
storei A0 1 //IntExpNode 
popr T1 
bleq A0 T1 label2
label4:
storei A0 0 
b label3
label2:
beq T1 A0 label4
storei A0 1 
label3: //EndCompExpNode 
storei T1 1 
beq A0 T1 label0
move AL T1  //IdExpNode 
subi T1 2
store A0 0(T1)  //EndIdExpNode 
pushr A0 //AsgNode 
b label1
label0:
move AL T1  //IdExpNode 
subi T1 3
store A0 0(T1)  //EndIdExpNode 
pushr A0 //AsgNode 
label1:
halt  //EndProgLetInNode 
