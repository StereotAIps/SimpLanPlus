move SP FP   //ProgLetInNode 
pushr FP 
move SP AL 
pushr AL 
storei A0 2 //IntExpNode 
move AL T1  //AsgNode 
subi T1 1
load A0 0(T1)  //EndAsgNode 
storei A0 3 //IntExpNode 
move AL T1  //AsgNode 
subi T1 2
load A0 0(T1)  //EndAsgNode 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0  //CompExpNode 
move AL T1  //IdExpNode 
subi T1 2
store A0 0(T1)  //EndIdExpNode 
popr T1 
bleq T1 A0 label2
label4:
storei A0 0 
b label3
label2:
beq T1 A0 label4
storei A0 1 
label3: //EndCompExpNode 
storei T1 1  //IfExpNode 
beq A0 T1 label0
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
move AL T1  //IdExpNode 
subi T1 2
store A0 0(T1)  //EndIdExpNode 
popr T1 
sub T1 A0 
popr A0 move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
move AL T1  //IdExpNode 
subi T1 2
store A0 0(T1)  //EndIdExpNode 
popr T1 
mul A0 T1 
popr A0  //EndNumExpNode 
b label1
label0:
move AL T1  //IdExpNode 
subi T1 2
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
popr T1 
sub T1 A0 
popr A0 move AL T1  //IdExpNode 
subi T1 2
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
popr T1 
mul A0 T1 
popr A0  //EndNumExpNode 
label1: //EndIfExpNode 
halt  //EndProgLetInNode 
