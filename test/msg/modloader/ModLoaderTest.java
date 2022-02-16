package msg.modloader;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>ModLoader</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
final class ModLoaderTest {

    /** This tests the <strong>loadMods</strong> method in the <strong>ModLoader</strong> class, with <code>int i = 1</code>  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void loadMods1 () {
        System.out.println("\nloadMods1  [\n");
        ModLoader.LoadMods(i.getToken(), 1);
        System.out.println("\n]\n\n\n");
    }

    /** This tests the <strong>loadMods</strong> method in the <strong>ModLoader</strong> class, with <code>int i = 2</code>  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void loadMods2 () {
        System.out.println("\nloadMods2  [\n");
        ModLoader.LoadMods(i.getToken(), 2);
        System.out.println("\n]\n\n\n");
    }

    /** This tests the <strong>loadMods</strong> method in the <strong>ModLoader</strong> class, with <code>int i = 3</code>  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void loadMods3 () {
        System.out.println("\nloadMods3  [\n");
        ModLoader.LoadMods(i.getToken(), 3);
        System.out.println("\n]\n\n\n");
    }

    /** This tests the <strong>loadMods</strong> method in the <strong>ModLoader</strong> class, with <code>int i = 4</code>  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void loadMods4 () {
        System.out.println("\nloadMods4  [\n");
        ModLoader.LoadMods(i.getToken(), 4);
        System.out.println("\n]\n\n\n");
    }

    /** This tests the <strong>loadMods</strong> method in the <strong>ModLoader</strong> class, with <code>int i = 5</code>  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void loadMods5 () {
        System.out.println("\nloadMods5  [\n");
        ModLoader.LoadMods(i.getToken(), 5);
        System.out.println("\n]\n\n\n");
    }

    /** This tests the <strong>loadMods</strong> method in the <strong>ModLoader</strong> class, with <code>int i = 6</code>  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void loadMods6 () {
        System.out.println("\nloadMods6  [\n");
        ModLoader.LoadMods(i.getToken(), 6);
        System.out.println("\n]\n\n\n");
    }

    /** This tests the <strong>loadMods</strong> method in the <strong>ModLoader</strong> class, with <code>int i = 7</code>  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void loadMods7 () {
        System.out.println("\nloadMods7  [\n");
        ModLoader.LoadMods(i.getToken(), 7);
        System.out.println("\n]\n\n\n");
    }

    /** Private constructor prevents utility class <strong>ModLoaderTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private ModLoaderTest () {}
}