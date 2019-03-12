package com.wastack.blog.domain;

public enum Role {
	ADMIN("Admin"),
	USER("User");
	
	private String name;

    private Role(String stringVal) {
        name=stringVal;
    }
    public String toString(){
        return name;
    }

    public static String getEnumByString(String code){
        for(Role e : Role.values()){
            if(code == e.name) return e.name();
        }
        return null;
    }
    public static String setEnumByString(String code){
        for(Role e : Role.values()){
            if(code == e.name) return e.name();
        }
        return null;
    }
	
}
