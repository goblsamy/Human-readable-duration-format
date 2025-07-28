package hu.samy;

public class Main {
    public static void main(String[] args) {

        System.out.println(formatDuration(356543)); // A funkció meghívása példa értékkel és az eredmény kiírása a konzolra.

    }

    public static String formatDuration(int inputSeconds) {

        String result = ""; // A végeredmény tárolására szolgáló változó inicializálása.
        if (inputSeconds == 0) { // 0 vizsgálat a bementei értékre a szabály alapján.
            result = "now";
        } else if (inputSeconds < 0) { // Negatív szám vizsgálata a bementei értékre, a szabály alapján. Ha a feltétel igaz, akkor rögtön visszatérek a megfelelő üzenettel.
            return "Input must be a positive integer";
        }
        final int SECONDS_IN_MINUTE = 60; // 60 seconds, 1 percben lévő másodpercek száma konstans változóban tárolva.
        final int SECONDS_IN_HOUR = 60 * 60; // 3600 seconds, 1 órában lévő másodpercek száma konstans változóban tárolva.
        final int SECONDS_IN_DAY = 24 * 60 * 60; // 86_400 seconds, 1 napban lévő másodpercek számakonstans változóban tárolva.
        final int SECONDS_IN_YEAR = 365 * 24 * 60 * 60; // 31_536_000 seconds, 1 évben lévő másodpercek száma konstans változóban tárolva.

        int years = inputSeconds / SECONDS_IN_YEAR; // Évek számának kiszámítása a bemeneti másodpercek alapján.
        inputSeconds %= SECONDS_IN_YEAR; // A bemeneti érték módosítása az évek levonásával, maradékos osztás használatával.

        int days = inputSeconds / SECONDS_IN_DAY; // Napok számának kiszámítása a bemeneti másodpercek alapján.
        inputSeconds %= SECONDS_IN_DAY; // A bemeneti érték módosítása a napok levonásával, maradékos osztás használatával.

        int hours = inputSeconds / SECONDS_IN_HOUR; // Órák számának kiszámítása a bemeneti másodpercek alapján.
        inputSeconds %= SECONDS_IN_HOUR; // A bemeneti érték módosítása az órák levonásával, maradékos osztás használatával.

        int minutes = inputSeconds / SECONDS_IN_MINUTE; // Percek számának kiszámítása a bemeneti másodpercek alapján.
        inputSeconds %= SECONDS_IN_MINUTE; // A bemeneti érték módosítása a percek levonásával, maradékos osztás használatával.

        int seconds = inputSeconds; // A fennmaradó másodpercek száma.

        if (years > 0) { // Az évek számának vizsgálata és hozzáfűzése az eredményhez, ha a feltétel igaz.
            result = years + (years > 1 ? " years" : " year"); // Ternary operátort használtam az egyes és többes szám megkülönböztetésére, a szabályok szerint.
        }
        if (days > 0) { // Napok számának vizsgálata és hozzáfűzése az eredményhez, ha a feltétel igaz.
            if (!result.isEmpty()) { // Ha az eredmény nem üres, akkor vesszővel és szóközzel elválasztva fűzzük hozzá a napokat, a szabályok szerint.
                result += ", ";
            }
            result += days + (days > 1 ? " days" : " day"); // Szintén ternary operátorral döntünk az egyes és többes számról.
        }
        if (hours > 0) { // Az órák számának vizsgálata és hozzáfűzése az eredményhez, ha a feltétel igaz.
            if (!result.isEmpty()) { // Ha az eredmény nem üres, akkor vesszővel és szóközzel elválasztva fűzzük hozzá az órákat, a szabályok szerint.
                result += ", ";
            }
            result += hours + (hours > 1 ? " hours" : " hour"); // Továbbra is ternary oprátort használok a megfelelő kiíratás érdekében.
        }
        if (minutes > 0) { // A percek számának vizsgálata és hozzáfűzése az eredményhez, ha a feltétel igaz.
            if (!result.isEmpty()) { // Ha az eredmény nem üres, akkor vesszővel és szóközzel elválasztva fűzzük hozzá a perceket, a szabályok szerint.
                result += ", ";
            }
            result += minutes + (minutes > 1 ? " minutes" : " minute"); // Itt is ternary operátort használok az egyes és többes szám megkülönböztetésére.
        }

        if (seconds > 0) { // A másodpercek számának vizsgálata és hozzáfűzése az eredményhez, ha a feltétel igaz.
            if (!result.isEmpty()) { // Ha a feltétel igaz, a másodperceket is hozzáfűzöm az eredményhez, előtte az 'and' szócskával elválasztva, a szabályok szerint.
                result += " and ";
            }
            result += seconds + (seconds > 1 ? " seconds" : " second");
        }
        return result; //Visszatérek a result változóval, amely tartalmazza a formázott időtartamot.

    }
}