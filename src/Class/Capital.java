package Class;

public enum Capital {
    BRASILIA("Brasília", "DF", 520, 500),
    SAO_PAULO("São Paulo", "SP", 550, 600),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", 600, 580),
    BELO_HORIZONTE("Belo Horizonte", "MG", 570, 540),
    SALVADOR("Salvador", "BA", 680, 460),
    MACEIO("Maceió", "AL", 730, 420),
    RECIFE("Recife", "PE", 760, 400),
    JOAO_PESSOA("João Pessoa", "PB", 770, 380),
    NATAL("Natal", "RN", 780, 360),
    FORTALEZA("Fortaleza", "CE", 750, 320),
    SAO_LUIS("São Luís", "MA", 670, 300),
    TERESINA("Teresina", "PI", 690, 340),
    ARACAJU("Aracaju", "SE", 700, 440),
    VITORIA("Vitória", "ES", 620, 570),
    GOIANIA("Goiânia", "GO", 500, 520),
    CUIABA("Cuiabá", "MT", 420, 520),
    CAMPO_GRANDE("Campo Grande", "MS", 430, 600),
    MANAUS("Manaus", "AM", 360, 230),
    BOA_VISTA("Boa Vista", "RR", 340, 80),
    PORTO_VELHO("Porto Velho", "RO", 290, 300),
    RIO_BRANCO("Rio Branco", "AC", 230, 330),
    BELEM("Belém", "PA", 630, 220),
    MACAPA("Macapá", "AP", 640, 180),
    PALMAS("Palmas", "TO", 570, 360),
    CURITIBA("Curitiba", "PR", 550, 680),
    FLORIANOPOLIS("Florianópolis", "SC", 540, 730),
    PORTO_ALEGRE("Porto Alegre", "RS", 520, 800);

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

    public String getNome() { return nome; }
    public String getSigla() { return sigla; }
    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return nome + " (" + sigla + ")";
    }
}
