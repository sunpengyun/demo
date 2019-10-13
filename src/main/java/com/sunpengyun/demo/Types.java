package com.sunpengyun.demo;

import java.io.Serializable;

public class Types implements Serializable {

    private int id;
    private String name;
    private String abstracts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Types types = (Types) o;

        if (id != types.id) return false;
        if (name != null ? !name.equals(types.name) : types.name != null) return false;
        return abstracts != null ? abstracts.equals(types.abstracts) : types.abstracts == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (abstracts != null ? abstracts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abstracts='" + abstracts + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

	public Types(int id, String name, String abstracts) {
		super();
		this.id = id;
		this.name = name;
		this.abstracts = abstracts;
	}

	public Types() {
		super();
	}
    
	
    
}
