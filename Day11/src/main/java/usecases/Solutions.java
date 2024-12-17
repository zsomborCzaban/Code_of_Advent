package usecases;

import utils.LinkedListNode;

import java.util.ArrayList;

public class Solutions {

    public static void solveWithLinkedList(int blinks){
        LinkedListNode<Long> inputHead = new LinkedListNode<>(4189L, null, null); //we should get the input as a param from main, that should read it from a class in the drivers package
        inputHead.addAfter(8L);
        inputHead.addAfter(0L);
        inputHead.addAfter(7478611L);
        inputHead.addAfter(655813L);
        inputHead.addAfter(61L);
        inputHead.addAfter(82070L);
        inputHead.addAfter(413L);

        for(int i = 0; i < blinks; i++){
            iterate(inputHead);
            inputHead = inputHead.getStartNode();
            System.out.println("done " + i + " out of " + blinks + " iterations");
        }

        System.out.println(inputHead.wholeListToString());
        System.out.println();
        System.out.println("total number of engravings: " + inputHead.getSize());

    }

    public static void solveWithArrayList(int blinks){
        ArrayList<Long> engravings = new ArrayList<>();
        engravings.add(4189L);
        engravings.add(413L);
        engravings.add(82070L);
        engravings.add(61L);
        engravings.add(655813L);
        engravings.add(7478611L);
        engravings.add(0L);
        engravings.add(8L);

        for(int i = 0; i < blinks; i++){
            System.out.println("done " + i + " out of " + blinks + " iterations");
            int stopSize = engravings.size();
            for(int j = 0; j < stopSize; j++){
                if(engravings.get(j) == 0){
                    engravings.set(j, 1L);
                    continue;
                }

                String engravingString = String.valueOf(engravings.get(j));
                int engravingLength = engravingString.length();

                if(engravingLength % 2 == 0){
                    Long leftEngraving = Long.valueOf(engravingString.substring(0, engravingLength/2)); //leading zeros will get ignored when the conversion happens
                    Long rightEngraving = Long.valueOf(engravingString.substring(engravingLength/2));

                    engravings.add(leftEngraving);
                    engravings.add(rightEngraving);
                    engravings.remove(engravings.get(j));
                    j--;
                    stopSize--;
                    continue;
                }
                else{
                    engravings.set(j, engravings.get(j)*2024);
                    continue;
                }
            }
        }

        System.out.println(engravings.toString());
        System.out.println(engravings.size());
    }

    private static void iterate(LinkedListNode<Long> head){
        LinkedListNode<Long> currentNode = head;
        while(currentNode != null){
            if(currentNode.getData() == 0){
                currentNode.setData(1L);
                currentNode = currentNode.getNodeAfter();
                continue;
            }

            String engraving = String.valueOf(currentNode.getData());
            int engravingLength = engraving.length();

            if(engravingLength % 2 == 0){
                Long leftEngraving = Long.valueOf(engraving.substring(0, engravingLength/2)); //leading zeros will get ignored when the conversion happens
                Long rightEngraving = Long.valueOf(engraving.substring(engravingLength/2));

                currentNode.addBefore(leftEngraving);
                currentNode.addBefore(rightEngraving);
                LinkedListNode<Long> nodeToRemove = currentNode;
                currentNode = currentNode.getNodeAfter();
                nodeToRemove.remove();
                continue;
            }
            else{
                currentNode.setData(currentNode.getData() * 2024);
                currentNode = currentNode.getNodeAfter();
                continue;
            }

        }

    }

}
