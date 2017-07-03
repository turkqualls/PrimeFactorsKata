package PrimeFactor;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorGenerator {

    public boolean IsPrime(int number){
        int halfOfNumber = number / 2;
        int index = 2;
        while(index <= halfOfNumber){
            if (number % index == 0)
                return false;
            index++;
        }

        return true;
    }

    public List<Integer> GetPrimeFactors(int number){

        if (number <= 1)
            return Arrays.asList();

        if (IsPrime(number))
            return Arrays.asList(number);

        List<Integer> list = new ArrayList<>();
        for (int x = 2; x <= number / 2; x++){
            if(number % x == 0){

                list.add(x);

                int quotient = number / x;
                if(IsPrime(quotient))
                    list.add(quotient);
                else
                    list.addAll(GetPrimeFactors(quotient));
                break;
            }
        }
        return list;
    }
}
