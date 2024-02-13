//Date: 2/9/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Defanging an IP Address

/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"

Constraints:
The given address is a valid IPv4 address.
*/

public class DefangingAnIPAddress {
    
    public static void main(String[] args) {

    }

    public static String defangIPaddr(String address) {
        
        String defanged_address = "";

        //Iterate through ip address
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (ch == '.'){
                defanged_address += "[.]";
            }
            else {
                defanged_address += ch;
            }
        }

        return defanged_address;
    }
}
