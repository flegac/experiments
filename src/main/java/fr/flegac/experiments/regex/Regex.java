package fr.flegac.experiments.regex;

public class Regex {
    public static void main(String[] args) {
        String data = " <dmRefIdent>\r\n" +
            "                    <dmCode modelIdentCode=\"ARRANO1\" pmVolume=\"d\" systemCode=\"71\" subSystemCode=\"0\" subSubSystemCode=\"0\" assyCode=\"05\" disassyCode=\"01\" disassyCodeVariant=\"ZZZ\" infoCode=\"421\" infoCodeVariant=\"Z\" itemLocationCode=\"A\"/>\r\n"
            +
            "\r\n" +
            "                </dmRefIdent>";
        data = data.replaceAll("pmVolume=\"(.)\"", "pmVolume=\"0$1\"");
        System.out.println(data);
    }
}
