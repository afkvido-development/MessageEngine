package msg.modloader.mods;

import msg.i;
import msg.modloader.resources.Mod;
import msg.modloader.resources.Script;
import msg.resources.account.Account;
import msg.resources.message.TextMessage;
import msg.resources.rank;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/** Just a mod for testing.
 * <p></p>
 * @author gemsvidø
 * @since 0.1.12
 * @see msg.modloader.ModLoader */
@Mod public interface testMod {

     @Script static void previewMessage(@NotNull Integer r) {

          if (r == 3) {

               Account rcp = new Account("rcp", "rcp password", rank.CHAT);
               Account rcp2 = new Account("rcp", "rcp password", rank.OWNER);

               Account acc = new Account("gemsvido", UUID.randomUUID().toString(), rank.MVPPLUS2, "");
               TextMessage msg = new TextMessage(acc, "Hi!", rcp);
               i.message(msg);


               acc = new Account("Person", UUID.randomUUID().toString(), rank.VIP, "");
               msg = new TextMessage(acc, "this tbh", rcp);
               i.message(msg);


               acc = new Account("git hub", UUID.randomUUID().toString(), rank.MVPPLUS1, "");
               msg = new TextMessage(acc, "github best", new Account("skid", UUID.randomUUID().toString(), rank.VIPPLUS1, ""));
               i.message(msg);


               acc = new Account("ak97", UUID.randomUUID().toString(), rank.YT, "");
               msg = new TextMessage(acc, "i'm cool lmao", rcp2);
               i.message(msg);


          }

     }

}
