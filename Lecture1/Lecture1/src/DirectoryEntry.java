/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DirectoryEntry other = (DirectoryEntry) o;

        return this.name.equals(other.name);
    }
}

// Svar på 2.4 Self Check 1
// 1.1: {0, 1, 2, 3, 4, 4, 4, 4}
// 1.2: {0, 1, 2, 3, 4, 4, 5, 6}
