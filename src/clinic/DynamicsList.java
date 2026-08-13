/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinic;

import java.util.Iterator;

/**
 *
 * @author Student
 * @param <T>
 * @param <K>
 */
//la T significa type y K significa clave
public interface DynamicsList <T>{
    public boolean add(T item);
    public Iterator getAll();
    public int size();
    public boolean isEmpty();
}
