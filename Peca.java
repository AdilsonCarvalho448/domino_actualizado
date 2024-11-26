/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domino_actualizado;

/**
 *
 * @author pc
 */
public class Peca {
        private int ladoA;
    private int ladoB;

    public Peca(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public int getLadoA() {
        return ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    @Override
    public String toString() {
        return "[" + ladoA + "|" + ladoB + "]";
    }
    
}
