package msg.resocurces;

import msg.Main;
import msg.resocurces.account.Account;
import msg.resocurces.message.TextMessage;

import java.util.ArrayList;
import java.util.UUID;

public class database {

        public static Account system;
        public static Account Admin;
        public static Account LocalServer;
        public static Account empty;
        public static Account SYSTEM_TOKEN;
        public static ArrayList<Account> accounts;
        public static Account impersonated;
        public static Boolean loaded = false;
        public static String name;


        public static void load () {



                if (!loaded) {
                        Main.debugLine("Info", "Loading database...");




                        // Add Account Data

                        Main.debugLine("Info", "Defining preset accounts...");
                        Admin = new Account("gemsvido", "please_subscribe", rank.OWNER, "6b33c874-61bd-4472-a1da-b42d3b121c14");
                        LocalServer = new Account("LocalServer", UUID.randomUUID().toString(), rank.CHAT, "5af07648-8059-4809-9e74-c2a6a141f286");
                        empty = new Account("Pre-login account", UUID.randomUUID().toString(), rank.DEFAULT, "");
                        Main.debugLine("Info", "Defined preset accounts.");


                        // Add Accounts to ArrayList


                        Main.debugLine("Info", "Initializing accounts ArrayList");
                        accounts = new ArrayList<>();
                        Main.debugLine("Info", "Initialized accounts ArrayList");
                        Main.debugLine("Info", "Adding existing accounts to the ArrayList");
                        accounts.add(Admin);
                        accounts.add(system);
                        accounts.add(LocalServer);
                        accounts.add(empty);
                        Main.debugLine("Info", "Added existing accounts to the ArrayList");


                        loaded = true;

                } else {
                        Main.debugLine("Info", "Database is already loaded. Reload with reload(), or unload with unload()");
                        TextMessage alert_1 = new TextMessage(system, "Database already loaded. To reload, use reload() [801]", Main.loggedin);
                        Main.message(alert_1);
                }

        }

        public static void unload () {
                Main.debugLine("Info", "Unloading database...");

                if (loaded) {

                        Main.debugLine("Info", "Nulling individual accounts...");
                        Admin = null;
                        system = null;
                        LocalServer = null;
                        empty = null;
                        impersonated = null;
                        Main.debugLine("Info", "Nulled all individual accounts");

                        Main.debugLine("Info", "Nulling account ArrayList...");
                        accounts = null;
                        Main.debugLine("Info", "Nulled account ArrayList");


                        Main.debugLine("Info", "Confirming loaded status");
                        loaded = false;
                        Main.debugLine("Info", "database.loaded is now false\n");

                        Main.debugLine("Info", "Database successfully unloaded");

                } else {
                        Main.debugLine("Info", "Nevermind. The database wasn't loaded in the first place.");
                        TextMessage alert_2 = new TextMessage(system, "Database is not loaded. To reload, use load() [802]", Main.loggedin);
                        Main.message(alert_2);
                }
        }

        public static void reload () {
                if (loaded) {
                        Main.debugLine("Info", "Reloading database.");

                        Main.debugLine("Info", "Unloading database...");
                        unload();
                        Main.debugLine("Info", "Unloaded database.");
                        Main.debugLine("Info", "Loading database...");
                        load();
                        Main.debugLine("Info", "Loaded database.");
                        Main.debugLine("Info", "\nSuccessfully reloaded database.");

                } else {
                        Main.debugLine("Info", "Database could not be reloaded as the database isn't loaded.");
                        TextMessage alert_3 = new TextMessage(system, "Database is not loaded. To reload, use load() [803]", Main.loggedin);
                        Main.message(alert_3);
                }
        }




}