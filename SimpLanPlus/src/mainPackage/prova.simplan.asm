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
storei A0 3 //IntExpNode 
pushr A0
move FP AL 
subi AL 1 
jsub function0
halt  //EndProgLetInNode 

function0: //DecfunNode 
pushr RA 
storei A0 1 //IntExpNode 
move AL T1  //AsgNode 
store T1 0(T1) 
subi T1 1
load A0 0(T1)  //EndAsgNode 
move AL T1  //IdExpNode 
store T1 0(T1) 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
popr T1 
add A0 T1 
popr A0  //EndNumExpNode 
pushr A0 //AsgNode 
move AL T1  //IdExpNode 
subi T1 3
store A0 0(T1)  //EndIdExpNode 
pushr A0  //NumExpNode 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
popr T1 
add A0 T1 
popr A0  //EndNumExpNode 
addi SP 1 //innerDecsSize
popr RA 
addi SP 1 //parSize
pop 
store FP 0(FP) 
move FP AL 
subi AL 1 
pop 
rsub RA //EndDecfunNode
