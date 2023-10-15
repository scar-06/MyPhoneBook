package org.example.services;

import java.util.*;

public class MyContacts {
//    use HashMap method to store multiple values (phoneNumbers) to a key(contactName)
    private final Map<String, List<String>> myContacts;

    public MyContacts() {
        this.myContacts = new HashMap<>();
    }

//    method to save contact name and number
    public void addNumber(String key, String value) {
        if (!myContacts.containsKey(key)) {
            myContacts.put(key, new ArrayList<>());
        }
        myContacts.get(key).add(value);
    }

//    method to search for phone number via contact name
    public List<String> findNumber(String key) {
        return myContacts.get(key);
    }

//    method to delete whole contact
    public void deleteContact(String key) {
        myContacts.remove(key);
    }

//    method to delete single phone number from contact name(assuming it has multiple numbers in one contact name)
    public void deleteNumber(String key, String value) {
        List<String> values = myContacts.get(key);
        if (values != null) {
            values.remove(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyContacts that = (MyContacts) o;
        return Objects.equals(myContacts, that.myContacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myContacts);
    }

    @Override
    public String toString() {
        return "MyContacts{" +
                "myContacts=" + myContacts +
                '}';
    }
}
