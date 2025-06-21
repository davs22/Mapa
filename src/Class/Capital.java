package Class;

public enum Capital {
    BRASILIA("Brasília", "DF", 655, 541),
    SAO_PAULO("São Paulo", "SP", 675, 740),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", 756, 730),
    BELO_HORIZONTE("Belo Horizonte", "MG", 745, 650),
    SALVADOR("Salvador", "BA", 883, 481),
    MACEIO("Maceió", "AL", 955, 400),
    RECIFE("Recife", "PE", 980, 365),
    JOAO_PESSOA("João Pessoa", "PB", 981, 340),
    NATAL("Natal", "RN", 974, 310),
    FORTALEZA("Fortaleza", "CE", 888, 245),
    SAO_LUIS("São Luís", "MA", 752, 222),
    TERESINA("Teresina", "PI", 791, 283),
    ARACAJU("Aracaju", "SE", 920, 433),
    VITORIA("Vitória", "ES", 832, 660),
    GOIANIA("Goiânia", "GO", 616, 570),
    CUIABA("Cuiabá", "MT", 459, 540),
    CAMPO_GRANDE("Campo Grande", "MS", 490, 670),
    MANAUS("Manaus", "AM", 360, 230),
    BOA_VISTA("Boa Vista", "RR", 340, 80),
    PORTO_VELHO("Porto Velho", "RO", 265, 367),
    RIO_BRANCO("Rio Branco", "AC", 170, 405),
    BELEM("Belém", "PA", 650, 180),
    MACAPA("Macapá", "AP", 583, 147),
    PALMAS("Palmas", "TO", 647, 405),
    CURITIBA("Curitiba", "PR", 613, 782),
    FLORIANOPOLIS("Florianópolis", "SC", 630, 842),
    PORTO_ALEGRE("Porto Alegre", "RS", 570, 900);

    private final String nome;
    private final String sigla;
    private final int x;
    private final int y;

    Capital(String nome, String sigla, int x, int y) {
        this.nome = nome;
        this.sigla = sigla;
        this.x = x;
        this.y = y;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return nome + " (" + sigla + ")";
    }
}
