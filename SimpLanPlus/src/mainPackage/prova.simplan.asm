move SP FP   //ProgLetInNode 
pushr FP 
move SP AL 
pushr AL 
push function0
pushr FP //CallNode 
move SP FP 
addi FP 1 
move AL T1
pushr T1 
storei A0 5 //IntExpNode 
pushr A0
move FP AL 
subi AL 1 
jsub function0
halt  //EndProgLetInNode 

function0: //DecfunNode 
pushr RA 
push 0 //DecVarNode 
push 0 //DecVarNode 
//IfStmNode 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0  //EqExpNode 
storei A0 0 //IntExpNode 
popr T1 
beq A0 T1 label2
storei A0 0 
b label3
label2:
storei A0 1 
label3:
storei T1 1 
beq A0 T1 label0
pushr FP //CallNode 
move SP FP 
addi FP 1 
move AL T1
store T1 0(T1) 
pushr T1 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
storei A0 1 //IntExpNode 
popr T1 
sub T1 A0 
popr A0  //EndNumExpNode 
pushr A0
move FP AL 
subi AL 1 
jsub function0
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
move AL T1  //AsgNode 
subi T1 2
load A0 0(T1)  //EndAsgNode 
move AL T1  //IdExpNode 
subi T1 2
store A0 0(T1)  //EndIdExpNode 
move AL T1  //AsgNode 
subi T1 3
load A0 0(T1)  //EndAsgNode 
b label1
label0:
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
storei A0 1 //IntExpNode 
popr T1 
add A0 T1 
popr A0  //EndNumExpNode 
move AL T1  //AsgNode 
subi T1 2
load A0 0(T1)  //EndAsgNode 
label1:
addi SP 2 //innerDecsSize
popr RA 
addi SP 1 //parSize
pop 
store FP 0(FP) 
move FP AL 
subi AL 1 
pop 
rsub RA //EndDecfunNode
