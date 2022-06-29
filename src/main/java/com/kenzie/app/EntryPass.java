package com.kenzie.app;

import java.util.Objects;

public class EntryPass {
    //Class properties
    // TODO: Fill in the properties
    private String name;
    private String id;
    private String accessLevel;

    //Class constructors
    // TODO: Fill in the constructors
    public EntryPass(String name, String id){
        this.name = name;
        this.id = id;
        this.accessLevel = "general";
    }

    public EntryPass(String name, String id, String accessLevel){
        this.name = name;
        this.id = id;
        this.accessLevel = accessLevel;
    }
    //Class methods
    // TODO: Fill in the methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }


    //Override equals
    //@Override
    //public boolean equals(Object entryPass){
        // TODO: Fill in the method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryPass entryPass = (EntryPass) o;
        return Objects.equals(id, entryPass.id) &&
                Objects.equals(accessLevel.toLowerCase(), entryPass.accessLevel.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accessLevel);
    }

    //}

}
