/*
1)
0x0000 42           (truth)
0x0001 0            (truth)  
0x0002 43           (halftruth)
0x0003 0            (halftruth)
0x0004 0x0000       (p1)
0x0005 0x0004       (p2)
0x0006 0x0002       (p3)
0x0007 0x0000       (p4)
0x0008 0x0006       (p5)
0x0009 0x0008       (p6)
0x000a 0x0004       (p7)
0x000b 0x0006       (p8)
0x000c 0x0000       (p9) 
0x000d 0x000a       (p10)

2)

short test;         undefined
test = *p1;         42
test = **p5;        43
test = *&*p9;       42
test = ***&p2;      42
test = ****&p6;     43
test = **p8;        43
p3 = p9;            Keine Zuweisung zu test und irrelevant für Rest des Programms
test = **p8;        43
*/




int main(){
    short truth = 42;
    short halfTruth = 23;

    short* p1 = &truth;
    short** p2 = &p1;
    short* p3 = &halfTruth;
    short* p4 = p1;
    short** p5 = &p3;
    short*** p6 = &p5;
    short*** p7 = &p2;
    short** p8 = *p6;
    short* p9 = *&*&p1;
    short** p10 = *p7;


    short test;
    test = *p1; 
    test = **p5; 
    test = *&*p9; 
    test = ***&p2; 
    test = ****&p6; 
    test = **p8; 
    p3 = p9;
    test = **p8;
}