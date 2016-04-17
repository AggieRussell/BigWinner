package com.example.owner.databasetest;

/**
 * Created by Owner on 4/15/2016.
 */
/*
 * Margaret Baxter (main coding)
 * Christine Russell, Ryan Hairston (co-writers)
 * CSCE 315 - Spring 2016
 * Project SnowShoe
 */

import java.util.*;
//import java.io.*;
import static java.lang.System.out;


/*
 * RowID's start at zero
 * Print statements do not end the print line
 */
public class Column {

    private ArrayList<Object> values;   //The container for the column
    private String name;                //The name, or attribute, associated with a column
    int maxLength;
    String type;

    //Default constructor
    public Column() {
        maxLength = 10;
    }

    //Parameterized constructor
    public Column(String newName, String newType) {
        this();
        name = newName;

        //If the type is string determine maxLength
        if(newType.length() > 7 && (newType.substring(0,7)).equals("VARCHAR")) {
            type = "String";
            maxLength = Integer.parseInt(newType.substring(8,newType.length()-1));
        }
        else if(newType.toUpperCase().equals("INT") || newType.toUpperCase().equals("INTEGER")) {
            type = "int";
        }
        else if(newType.toUpperCase().equals("DOUBLE")) {
            type = "double";
        }
        else type = "String";

        values = new ArrayList<Object>();
    }

    //Parameterized constructor
    //The column ID must be a unqiue integer provided to this constructor
    public Column(String newName, String newType, ArrayList<Object> newValues) {
        this();
        name = newName;

        //If the type is string determine maxLength
        if(newType.length() > 7 && (newType.substring(0,7)).equals("VARCHAR")) {
            type = "String";
            maxLength = Integer.parseInt(newType.substring(8,newType.length()-1));
        }
        else if(newType.toUpperCase().equals("INT") || newType.toUpperCase().equals("INTEGER")) {
            type = "int";
        }
        else if(newType.toUpperCase().equals("DOUBLE")) {
            type = "double";
        }
        else type = "String";

        //Deep copy the elements of the passed in ArrayList to the local column ArrayList
        values = new ArrayList<Object>();
        for(int i=0; i<newValues.size(); ++i) {
            values.add(newValues.get(i));
        }
    }

    //Return the name of the column
    public String getName() {
        return name;
    }

    //Return the type of the attributes in the column
    public String getType() {
        return type;
    }

    //returns the maximum length of a value in this column
    public int getLength() {
        return maxLength;
    }

    //Update the name of the column
    public void changeName(String newName) {
        name = newName;
    }

    //Return the size of the column
    public int size() {
        return values.size();
    }

    //Adds new object to the end of column -- Christine, 13 Feb 2016
    public void addValue(Object newValue) {
        values.add(newValue);
    }

    //Adds all values in an array to end of the column
    public void addAllValues(ArrayList<Object> newValues) {
        values.addAll(newValues);
    }

    //Add one attribute, shift elements back to make room
    public void insertValue(int rowID, Object newValue) {
        if(rowID > values.size())
            out.println("Index out of Bounds in Column " + name);
        else if(rowID == values.size())
            values.add(newValue);
        else
            values.add(rowID,newValue);
    }

    //Delete one attribute, replaces it with null
    public void deleteValue(int rowID) {
        if(rowID >= values.size())
            out.println("Index out of Bounds in Column " + name);
        else
            values.remove(rowID);
    }

    //Return the value of a row's attribute
    public Object getValue(int rowID) {
        if(rowID >= values.size())
            out.println("Index out of Bounds in Column " + name);
        else return values.get(rowID);
        return null;
    }

    //Change the value of a row's attribute
    public boolean changeValue(int rowID, Object newValue) {
        if(rowID >= values.size()) {
            out.println("Index out of Bounds in Column " + name);
            return false;
        }
        else values.set(rowID, newValue);
        return true;
    }

    //Return the entire list of attributes
    public ArrayList<Object> getCol() {
        return values;
    }


    //General display
    //No new line character
    public void show() {
        out.printf("Column %s: ", name);
        for(int i=0; i<values.size(); ++i) {
            out.print(values.get(i) + " ");
        }
    }

    //Show with spacing to print maxLength characters
    //No endline character, no space after the string
    public String showValue(int rowID) {
        String result = "";
        result += values.get(rowID);
        if(result.length() > maxLength)
            return result.substring(0,maxLength);
        while(result.length() < maxLength)
            result += " ";
        return result;
    }

    public String showType() {
        String result = type;
        if(result.length() > maxLength)
            return result.substring(0,maxLength);
        while(result.length() < maxLength)
            result += " ";
        return result;
    }

    public String showMaxLength() {
        String result = "";
        result += maxLength;
        return result;
    }

    public String showName() {
        String result = name;
        if(result.length() > maxLength)
            return result.substring(0,maxLength);
        while(result.length() < maxLength)
            result += " ";
        return result;
    }
/*
    //FOR DEBUGGING
    public static void main(String[] args) {
        /*ArrayList<Object> data = new ArrayList<Object>();
        data.add(0);
        data.add(1);
        Column trial = new Column("First", data);
        trial.addValue(3);
        trial.insertValue(2,2);
        trial.changeValue(0,7);
        trial.show();
        out.println();
        trial.deleteValue(0);
        trial.show();
        out.println();
        String newType = "VARCHAR(30842384)";
        int maxLength = 0;
        if((newType.substring(0,7)).equals("VARCHAR")) {
            maxLength = Integer.parseInt(newType.substring(8,newType.length()-1));
        }
        out.println(newType.substring(0,7));
        out.println((newType.substring(0,7)).equals("VARCHAR"));
        out.println(newType.substring(8,newType.length()-1));
        out.println(maxLength);
    }
*/
}
