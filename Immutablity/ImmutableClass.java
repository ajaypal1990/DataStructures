package com.ajay.concepts.Immutablity;

import java.util.*;

public final class ImmutableClass {
    private final Date dateField;
    private final List<String> stringList;
    private final List<Address> addressList;
    private final Map<Address, Address> stringMap;

    public ImmutableClass(Date dateField, List<String> stringList, List<Address> addressList, Map<Address, Address> stringMap) {
       this.dateField = new Date(dateField.getTime());
       this.stringList = new ArrayList<>(stringList);
       List<Address> copyAddress =new ArrayList<>();
       for (Address address:addressList){
           copyAddress.add(address);
       }
       this.addressList = Collections.unmodifiableList(copyAddress);

       Map<Address,Address> copymap=new HashMap<>();
       for(Map.Entry<Address,Address> entry:stringMap.entrySet()){
           copymap.put(new Address(entry.getKey()),new Address(entry.getValue()));
       }
       this.stringMap=Collections.unmodifiableMap(copymap);
    }

    public Date getDateField() {
        return new Date(dateField.getTime());
    }

    public List<String> getStringList() {
        return Collections.unmodifiableList(stringList);
    }

    public List<Address> getAddressList() {
        return Collections.unmodifiableList(addressList);
    }

    public Map<Address, Address> getStringMap() {
        return Collections.unmodifiableMap(stringMap);
    }
}
