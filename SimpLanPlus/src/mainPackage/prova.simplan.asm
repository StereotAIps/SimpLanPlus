move SP FP   //ProgLetInNode 
pushr FP 
move SP AL 
pushr AL 
push function0
storei A0 5 //IntExpNode 
pushr A0 //AsgNode 
pushr FP //CallNode 
move SP FP 
addi FP 1 
move AL T1
pushr T1 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
pushr A0
move FP AL 
subi AL 1 
jsub function0
halt  //EndProgLetInNode 

function0: //DecfunNode 
pushr RA 
move AL T1  //IdExpNode 
subi T1 1
store A0 0(T1)  //EndIdExpNode 
addi SP 0 //innerDecsSize
popr RA 
addi SP 1 //parSize
pop 
store FP 0(FP) 
move FP AL 
subi AL 1 
pop 
rsub RA //EndDecfunNode
