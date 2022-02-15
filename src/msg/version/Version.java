package msg.version;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

/** <strong>Version tracker</strong>, to enforce updates and correct server-to-client version.
 * <p></p> This utility class cannot be initialized.
 * */
public @NotNull @Unmodifiable final class Version {

    /*
     * ...........................................................................
     *
     *  NOTE: IF YOU ARE MAKING YOUR OWN PROJECT WITH MESSAGEENGINE THEN READ THIS.
     *  ..........................................................................
     *
     *  For forks without pull requests: make the version X.X.X-Yourgithubname
     *  Example: 0.0.0-afkvido
     * ......................................................................
     *
     *  For pull requests: Do not change the version, we will do this ourselves.
     * ....................................................
     *
     *  IF YOU ARE MAKING YOUR OWN PROJECT WITH MESSAGEENGINE (Clone):
     *  PLEASE CONTACT ME ON MY DISCORD SERVER https://disboard.org/server/893975758677086238
     *  ............................................................
     *
     *  If you are injecting messageengine in your project, please use injectVersion instead of Version
     *
     *
     */

    /** Version of MessageEngine */
    public @NotNull @Unmodifiable static final String Version = "0.1.3";

    /** Version of MessageEngine that gets injected into other projects. */
    public @NotNull @Unmodifiable static final String injectVersion = Version + "+Inject";

    /** Utility class <strong>Version</strong> cannot be initialized.*/
    private Version () {}



}
