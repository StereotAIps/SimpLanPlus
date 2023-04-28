//ProgLetInNode 
move SP FP  
pushr FP 
move SP AL 
pushr AL 
//DecFunNode 
push function0
pushr FP 
//CallNode 
move SP FP 
addi FP 1 
move AL T1
pushr T1 
//IntExpNode 
storei A0 1
pushr A0
move FP AL 
subi AL 1 
jsub function0
halt

//DecFunNodeCODE 
function0:
pushr RA 
//BodyNode 
move SP FP  
pushr FP 
move SP AL 
pushr AL 
//NumExpNode 
//IntExpNode 
storei A0 3
pushr A0 
//IdExpNode 
move AL T1 
store T1 0(T1) 
subi T1 1
store A0 0(T1) 
popr T1 
add A0 T1 
popr A0 
popr RA 
addi SP 1
pop 
store FP 0(FP) 
move FP AL 
subi AL 1 
pop 
rsub RA 
