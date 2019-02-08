package com.company.Exercise2;

class PvmValidator {

    final boolean checkPvmCode(int[] code){
        int A1 = 0, R1, A2 = 0, R2;

        if (code.length == 9){
            if (code[code.length - 2] == 1) {
                for (int i = 1; i < code.length; i++) {
                    A1 += i * code[i - 1];
                }
                R1 = A1 % 11;
                if (R1 != 10){
                    return code[code.length - 1] == R1;
                }
                else{
                    for (int i = 3; i < 10; i++){
                        A2 += i * code[i - 3];
                    }
                    A2 += code[code.length - 2];
                    R2 = A2 % 11;
                    if (R2 == 10){
                        return code[code.length - 1] == 0;
                    }
                    else{
                        return code[code.length - 1] == R2;
                    }
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
