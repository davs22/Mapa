package Class;

public enum Capital {
    VITORIA("Vitória"),
    RIO_BRANCO("Rio Branco"),
    SALVADOR("Salvador"),
    MACEIO("Maceió"),
    MANAUS("Manaus"),
    BELO_HORIZONTE("Belo Horizonte");


    private final String nome;

    Capital(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Capital fromNome(String nome) {
        for (Capital c : values()) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
