package fr.flegac.experiments.approval;

import org.approvaltests.legacycode.LegacyApprovals;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

@UseReporter(JunitReporter.class)
public class ApprovalTest {

    final static String[] toto = {
        "a", ""
    };

    final static String[] tata = {
        "b", ""
    };

    final static String[] titi = {
        "", "c"
    };

    @Test
    public void _test1() throws Exception {
        LegacyApprovals.LockDown(this, "test1", toto, tata, titi);
    }

    @Test
    public void _test2() throws Exception {
        LegacyApprovals.LockDown(this, "test2", toto, tata, titi);
    }

    @Test
    public void _test3() throws Exception {
        LegacyApprovals.LockDown(this, "test3", toto, tata, titi);
    }

    public String test1(final String toto, final String tata, final String titi) {
        final Bidon item = new Bidon(toto, tata, titi);
        item.doSomething();
        return item.toString();
    }

    public String test2(final String toto, final String tata, final String titi) {
        final Bidon item = new Bidon(toto, tata, titi);
        item.setTata(titi);
        item.setToto(tata);
        item.setTiti(toto);

        return item.toString();
    }

    public String test3(final String toto, final String tata, final String titi) {
        final Bidon item = new Bidon(toto, tata, titi);

        return item.getTata() + item.getToto() + item.getTiti();
    }

}
