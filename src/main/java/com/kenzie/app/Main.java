package com.kenzie.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{

    /*
        A EntryPass is unique if there is no pass with the same ID and access level.
        You will need to override equals() in EntryPass to check for equality of these items
        The equals() comparison is case-insensitive meaning VIP is equal to vip. 
     */
    public static boolean addPassIfUnique(HashMap<String, EntryPass> entryPassHashMap,EntryPass entryPass){
        //fill in method
        String nameId;
        if(entryPassHashMap.containsValue(entryPass)){
            return false;
        }else{
            nameId = entryPass.getName().concat(entryPass.getId());
            entryPassHashMap.put(nameId, entryPass);
        }

        return true;
    }


    /*
        getVIPList should return any name with a VIP pass. In this method, consider any case value of "vip"
        to be a valid VIP pass. Example: "vip" and "VIP" are both VIP passes.
     */
    public static ArrayList<String> getVIPList(HashMap<String, EntryPass> hashMap){
        //fill in method
        ArrayList<String> vipList = new ArrayList<>();
        for(Map.Entry<String, EntryPass> entry : hashMap.entrySet()){
            //String check = entry.getValue().getAccessLevel();
            if(entry.getValue().getAccessLevel().equalsIgnoreCase("vip")){
                vipList.add(entry.getValue().getName());
            }
        }
        return vipList;
    }

    public static void main(String[] args) {
        HashMap<String, EntryPass> entryPassesByName = new HashMap<>();
        ArrayList<String> blockList = new ArrayList<>();

        //define local variables as needed
        String name;
        String id;
        String accessLevel;
        Scanner scanner = new Scanner(System.in);

        // write your code here
        while(true) {
            System.out.println("Please enter name.");
            name = scanner.nextLine();
            System.out.println("Please enter id.");
            id = scanner.nextLine();
            System.out.println("Please enter access level.");
            accessLevel = scanner.nextLine();

            EntryPass entryPass = new EntryPass(name, id, accessLevel);

            if(addPassIfUnique(entryPassesByName, entryPass)){
                System.out.println("Added to EntryList");
            }else{
                System.out.println("Blocked");
                blockList.add(entryPass.getName());
            }

            System.out.println("Continue? Y/N");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")){
                break;
            }
        }

        //Use this print statement at the end of the program. Do not modify!
        System.out.println("Entry Pass List:");
        System.out.println(entryPassesByName.entrySet());
        System.out.println("Blocked list:");
        System.out.println(blockList);
        System.out.println("VIP List:");
        System.out.println(getVIPList(entryPassesByName));
    }
}
