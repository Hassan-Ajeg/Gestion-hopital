/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Specialite {
    
    private int id;
    private String nomSpecialite;

    public Specialite() {
    }

    public Specialite(int id, String nomSpecialite) {
        this.id = id;
        this.nomSpecialite = nomSpecialite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    @Override
    public String toString() {
        return "Specialite{" + "id=" + id + ", nomSpecialite=" + nomSpecialite + '}';
    }
           
    
}
