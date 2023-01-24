package br.com.gabrielalencar.restwithspringbootandjava;

public class Greeting {
    private final long id;
    private final String content;

    //  Construtor
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
    //  Getters
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
