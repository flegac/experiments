package fr.flegac.experiments.approval;

public class Bidon {

    private String toto;

    private String tata;

    private String titi;

    public Bidon(final String toto, final String tata, final String titi) {
        super();
        this.toto = toto;
        this.tata = tata;
        this.titi = titi;
    }

    @Override
    public String toString() {
        return "Bidon [toto=" + toto + ", tata=" + tata + ", titi=" + titi + "]";
    }

    public void doSomething() {
        if (titi.isEmpty()) {
            toto = toto + tata;
        }
        else {
            if (tata.isEmpty()) {
                toto = titi + toto;
            }
        }
    }

    public String getToto() {
        return toto;
    }

    public void setToto(final String toto) {
        this.toto = toto;
    }

    public String getTata() {
        return tata;
    }

    public void setTata(final String tata) {
        this.tata = tata;
    }

    public String getTiti() {
        return titi;
    }

    public void setTiti(final String titi) {
        this.titi = titi;
    }

}
