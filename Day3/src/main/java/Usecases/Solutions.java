package Usecases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solutions {
    public static int calculateUncorruptedMul(String corruptedMemory){
        Pattern pattern = Pattern.compile("mul\\(([1-9]\\d{0,2}),([1-9]\\d{0,2})\\)");
        Matcher matcher = pattern.matcher(corruptedMemory);
        int sum = 0;

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            sum += x * y;
        }

        return sum;
    }

    public static int part2CalculateUncorruptedMul(String corruptedMemory){
        int i = 0;
        int sumOfMultiplications = 0;
        boolean isDo = true;

        while(i <= corruptedMemory.length() - 1){
            if(isDo){
                int[] mulSearch = checkForMul(corruptedMemory, i);
                int[] dontSearch = checkForSimpleString(corruptedMemory, i, "don't()");

                if(mulSearch[0] == 1){
                    sumOfMultiplications += mulSearch[2];
                    i += mulSearch[1];
                    continue;
                }

                if(dontSearch[0] == 1){
                    isDo = false;
                    i += dontSearch[1];
                    continue;
                }

                i += Math.max(mulSearch[1], dontSearch[1]); //this is possible because they dont share the same letter
            }

            //could be if else, but its clearer this way (in my opinion)
            if(!isDo){
                int[] doSearch = checkForSimpleString(corruptedMemory, i, "do()");

                if(doSearch[0] == 1){
                    isDo = true;
                }

                i += doSearch[1];
            }
        }

        return sumOfMultiplications;
    }

    public static int calculateUncorruptedMulLegacy(String corruptedMemory){    //made this because I taught it would look cool
        int i = 0;
        int sumOfMultiplications = 0;

        while(i <= corruptedMemory.length() - 1){
            if(corruptedMemory.charAt(i) == 'm'){
                i += 1;
            } else {
                i += 1;
                continue;
            }

            if(corruptedMemory.charAt(i) == 'u' && i <= corruptedMemory.length() - 1){
                i += 1;
            } else {
                continue;
            }

            if(corruptedMemory.charAt(i) == 'l'  && i <= corruptedMemory.length() - 1){
                i += 1;
            } else {
                continue;
            }

            if(corruptedMemory.charAt(i) == '('  && i <= corruptedMemory.length() - 1){
                i += 1;
            } else {
                continue;
            }

            int firstNumber = 0;

            if((corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
                firstNumber = corruptedMemory.charAt(i) - '0';
                i += 1;
            } else {
                continue;
            }

            if((corruptedMemory.charAt(i) == ',' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
                if(corruptedMemory.charAt(i) != ','){
                    firstNumber = firstNumber * 10 + corruptedMemory.charAt(i) - '0';
                    i += 1;
                }
            } else {
                continue;
            }

            if((corruptedMemory.charAt(i) == ',' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
                if(corruptedMemory.charAt(i) != ','){
                    firstNumber = firstNumber * 10 + corruptedMemory.charAt(i) - '0';
                    i += 1;
                }
            } else {
                continue;
            }

            if(corruptedMemory.charAt(i) == ','  && i <= corruptedMemory.length() - 1){
                i += 1;
            } else {
                continue;
            }

            int secondNumber = 0;

            if((corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
                secondNumber = corruptedMemory.charAt(i) - '0';
                i += 1;
            } else {
                continue;
            }

            if((corruptedMemory.charAt(i) == ')' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
                if(corruptedMemory.charAt(i) != ')'){
                    secondNumber = secondNumber * 10 + corruptedMemory.charAt(i) - '0';
                    i += 1;
                }
            } else {
                continue;
            }

            if((corruptedMemory.charAt(i) == ')' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
                if(corruptedMemory.charAt(i) != ')'){
                    secondNumber = secondNumber * 10 + corruptedMemory.charAt(i) - '0';
                    i += 1;
                }
            } else {
                continue;
            }

            if(corruptedMemory.charAt(i) == ')'  && i <= corruptedMemory.length() - 1){
                sumOfMultiplications += firstNumber * secondNumber;
                i += 1;
            } else {
                continue;
            }
        }

        return sumOfMultiplications;
    }


    private static int[] checkForSimpleString(String corruptedMemory, int startIndex, String checkForString){
        //returns [isFound, idxsChecked)]
        //don't use the idxsChecked if the string has repeating letters!
        int i = startIndex;

        while(i - startIndex <= checkForString.length() - 1){
            if(i > corruptedMemory.length() - 1 || corruptedMemory.charAt(i) != checkForString.charAt(i - startIndex)){
                i += 1;
                return new int[]{0, i - startIndex};
            }

            i += 1;
        }

        return new int[]{1, i - startIndex};
    }


    private static int[] checkForMul(String corruptedMemory, int startIndex){
        //returns [mulFound?, idxsChecked, sum)]
        int i = startIndex;

        if(corruptedMemory.charAt(i) == 'm'){
            i += 1;
        } else {
            i += 1;
            return new int[]{0,i - startIndex};
        }

        if(corruptedMemory.charAt(i) == 'u' && i <= corruptedMemory.length() - 1){
            i += 1;
        } else {
            return new int[]{0, i - startIndex};
        }

        if(corruptedMemory.charAt(i) == 'l'  && i <= corruptedMemory.length() - 1){
            i += 1;
        } else {
            return new int[]{0, i - startIndex};
        }

        if(corruptedMemory.charAt(i) == '('  && i <= corruptedMemory.length() - 1){
            i += 1;
        } else {
            return new int[]{0, i - startIndex};
        }

        int firstNumber = 0;

        if((corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
            firstNumber = corruptedMemory.charAt(i) - '0';
            i += 1;
        } else {
            return new int[]{0, i - startIndex};
        }

        if((corruptedMemory.charAt(i) == ',' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
            if(corruptedMemory.charAt(i) != ','){
                firstNumber = firstNumber * 10 + corruptedMemory.charAt(i) - '0';
                i += 1;
            }
        } else {
            return new int[]{0, i - startIndex};
        }

        if((corruptedMemory.charAt(i) == ',' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
            if(corruptedMemory.charAt(i) != ','){
                firstNumber = firstNumber * 10 + corruptedMemory.charAt(i) - '0';
                i += 1;
            }
        } else {
            return new int[]{0, i - startIndex};
        }

        if(corruptedMemory.charAt(i) == ','  && i <= corruptedMemory.length() - 1){
            i += 1;
        } else {
            return new int[]{0, i - startIndex};
        }

        int secondNumber = 0;

        if((corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
            secondNumber = corruptedMemory.charAt(i) - '0';
            i += 1;
        } else {
            return new int[]{0, i - startIndex};
        }

        if((corruptedMemory.charAt(i) == ')' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
            if(corruptedMemory.charAt(i) != ')'){
                secondNumber = secondNumber * 10 + corruptedMemory.charAt(i) - '0';
                i += 1;
            }
        } else {
            return new int[]{0, i - startIndex};
        }

        if((corruptedMemory.charAt(i) == ')' || corruptedMemory.charAt(i) == '0' || corruptedMemory.charAt(i) == '1' || corruptedMemory.charAt(i) == '2' ||corruptedMemory.charAt(i) == '3' ||corruptedMemory.charAt(i) == '4' ||corruptedMemory.charAt(i) == '5' ||corruptedMemory.charAt(i) == '6' ||corruptedMemory.charAt(i) == '7' ||corruptedMemory.charAt(i) == '8' ||corruptedMemory.charAt(i) == '9') && i <= corruptedMemory.length() - 1){
            if(corruptedMemory.charAt(i) != ')'){
                secondNumber = secondNumber * 10 + corruptedMemory.charAt(i) - '0';
                i += 1;
            }
        } else {
            return new int[]{0, i - startIndex};
        }

        if(corruptedMemory.charAt(i) == ')'  && i <= corruptedMemory.length() - 1){
            i += 1;
            return new int[]{1, i-startIndex, firstNumber * secondNumber};
        } else {
            return new int[]{0, i - startIndex};
        }
    }

//    private static int[] checkForDo(String corruptedMemory, int startIndex){
//        //returns [doFound?, idxsChecked)]
//        int i = startIndex;
//
//        if(corruptedMemory.charAt(i) == 'd'){
//            i += 1;
//        } else {
//            i += 1;
//            return new int[]{0,i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == 'o' && i <= corruptedMemory.length() - 1){
//            i += 1;
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == '('  && i <= corruptedMemory.length() - 1){
//            i += 1;
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == ')'  && i <= corruptedMemory.length() - 1){
//            i += 1;
//            return new int[]{1, i - startIndex};
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//    }
//
//    private static int[] checkForDont(String corruptedMemory, int startIndex){
//        //returns [dontFound?, idxsChecked)]
//        int i = startIndex;
//
//        if(corruptedMemory.charAt(i) == 'd'){
//            i += 1;
//        } else {
//            i += 1;
//            return new int[]{0,i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == 'o' && i <= corruptedMemory.length() - 1){
//            i += 1;
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == 'n'  && i <= corruptedMemory.length() - 1){
//            i += 1;
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == '\''  && i <= corruptedMemory.length() - 1){
//            i += 1;
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == 't'  && i <= corruptedMemory.length() - 1){
//            i += 1;
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == '('  && i <= corruptedMemory.length() - 1){
//            i += 1;
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//
//        if(corruptedMemory.charAt(i) == ')'  && i <= corruptedMemory.length() - 1){
//            i += 1;
//            return new int[]{1, i - startIndex};
//        } else {
//            return new int[]{0, i - startIndex};
//        }
//    }


}
