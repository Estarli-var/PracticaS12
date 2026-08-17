/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinic;

/**
 *
 * @author Student
 */
public interface iViews <T>{
    public void clear();
public void showData(T data);
public void showError(String Error);
public void showMessage(String message);
}
