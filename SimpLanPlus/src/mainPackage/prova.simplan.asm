move SP FP  
pushr FP 
move SP AL 
pushr AL 
push h
pushr FP 
move SP FP 
addi FP 1 
move AL T1
pushr T1 
storei A0 5
pushr A0
move FP AL 
subi AL 1 
jsub h
halt

h:
pushr RA 
move SP FP  
pushr FP 
move SP AL 
pushr AL 
nullstorei T1 1 
beq A0 T1 label0
pushr FP 
move SP FP 
addi FP 1 
move AL T1
store T1 0(T1) 
store T1 0(T1) 
pushr T1 
nullpushr A0 
storei A0 1
popr T1 
sub T1 A0 
popr A0 
pushr A0
move FP AL 
subi AL 1 
jsub h
nullpushr A0 
nullpushr A0 
b label1
label0:
nullpushr A0 
storei A0 1
popr T1 
add A0 T1 
popr A0 
pushr A0 
label1:
popr RA 
addi SP 1
pop 
store FP 0(FP) 
move FP AL 
subi AL 1 
pop 
rsub RA 
