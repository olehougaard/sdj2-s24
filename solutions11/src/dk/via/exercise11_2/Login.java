package dk.via.exercise11_2;

import java.io.Serializable;

public record Login(String username, String password) implements Serializable {

}
