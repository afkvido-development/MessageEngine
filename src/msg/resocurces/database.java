package msg.resocurces;
import msg.Main;
import msg.account.Account;
import msg.message.TextMessage;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class database {

        public static Account gemsvido;
        public static Account system;
        public static Account test;
        public static Account chat;
        public static Account empty;
        public static Account SYSTEM_TOKEN;
        public static ArrayList<Account> accounts;
        public static Account impersonated;
        public static ArrayList<String> ez;
        public static Boolean loaded = false;
        public static ArrayList<String> messageblacklist;


        public static void load () {

                if (!loaded) {

                        // Add ban list
                        do {


                        } while (false);

                        // Add Account Data
                        do {
                                gemsvido = new Account("gemsvido", "please_subscribe", "OWNER", "6b33c874-61bd-4472-a1da-b42d3b121c14");
                                system = new Account("system", "12d9e695-4eb3-4567-8a50-d13bf5db9787", "ADMIN", "4b80a385-be1a-4ee6-ac27-831dade116ae");
                                test = new Account("test", "test_passowrd", "ADMIN", "4b99fa8a-a87a-4187-bb0a-63329475f8b3");
                                chat = new Account("chat", "f252b880-8329-4ba1-bfb0-c2ad8d785980", "CHAT", "5af07648-8059-4809-9e74-c2a6a141f286");
                                empty = new Account("null", UUID.randomUUID().toString(), "", "");
                                impersonated = new Account("Jimothy", UUID.randomUUID().toString(), "DEFAULT", "");
                                SYSTEM_TOKEN = new Account("SYSTEM_TOKEN", UUID.randomUUID().toString(), "DEFAULT", "");

                        } while (false);

                        // Add Accounts to ArrayList
                        do {
                                accounts = new ArrayList<>();
                                accounts.add(gemsvido);
                                accounts.add(system);
                                accounts.add(test);
                                accounts.add(chat);
                                accounts.add(empty);
                        } while (false);

                        // Add ez messages to ArrayList
                        do {

                                ez = new ArrayList<String>();
                                ez.add("Wait... This isn't what I typed!");
                                ez.add("Anyone else really like Rick Astley?");
                                ez.add("Hey helper, how play game?");
                                ez.add("Sometimes I sing soppy, love songs in the car.");
                                ez.add("I like long walks on the beach and playing Hypixel");
                                ez.add("Please go easy on me, this is my first game!");
                                ez.add("You're a great person! Do you want to play some Hypixel games with me?");
                                ez.add("In my free time I like to watch cat videos on Youtube");
                                ez.add("When I saw the witch with the potion, I knew there was trouble brewing.");
                                ez.add("If the Minecraft world is infinite, how is the sun spinning around it?");
                                ez.add("Hello everyone! I am an innocent player who loves everything Hypixel.");
                                ez.add("Plz give me doggo memes!");
                                ez.add("I heard you like Minecraft, so I built a computer in Minecraft in your Minecraft so you can Minecraft while you Minecraft");
                                ez.add("Why can't the Ender Dragon read a book? Because he always starts at the End.");
                                ez.add("Maybe we can have a rematch?");
                                ez.add("I sometimes try to say bad things then this happen");
                                ez.add("Behold, the great and powerful, my magnificent and almighty nemisis!");
                                ez.add("Doin a bamboozle fren.");
                                ez.add("Your clicks per second are godly");
                                ez.add("What happens if I add chocolate milk to macaroni and cheese?");
                                ez.add("Can you paint with all the colors of the wind");
                                ez.add("Blue is greener than purple for sure");
                                ez.add("I had something to say, then I forgot it.");
                                ez.add("When nothing is right, go left.");
                                ez.add("I need help, teach me how to play!");
                                ez.add("Your personality shines brighter than the sun.");
                                ez.add("You are very good at the game friend.");
                                ez.add("I like pineapple on my pizza");
                                ez.add("I like pasta, do you prefer nachos?");
                                ez.add("I like Minecraft pvp but you are truly better than me!");
                                ez.add("I have really enjoyed playing with you! <3");
                                ez.add("ILY<3");
                                ez.add("Pineapple doesn't go on pizza!");
                                ez.add("Lets be friends instead of fighting okay?");
                                ez.add("AIDS");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("uwu");
                                ez.add("uwu");
                                ez.add("i have a short d");
                                ez.add("chat filter?");
                                ez.add("im bad");
                                ez.add("Alex is tall, for sure. No cap.");
                                ez.add("uwu");
                                ez.add("uwu");
                                ez.add("owo");
                                ez.add("Nvidia bread is the future of bread.");
                                ez.add(c.pr + "twitch.tv/gemsvido" + c.rs);
                                ez.add(c.pr + "twitch.tv/gemsvido" + c.rs);
                                ez.add(c.pr + "twitch.tv/V183Z" + c.rs);
                                ez.add("Subscribe to gemsvido");
                                ez.add("Fortnite sucks balz");
                                ez.add("crack");
                                ez.add("ur mom");
                                ez.add(c.pr + "discord.gg/EMQpumB" + c.rs);
                                ez.add("I'm not a simp, piss off.");
                                ez.add(c.rd + "youtu.be/dQw4w9WgXcQ");
                                ez.add("Wait... This isn't what I typed!");
                                ez.add("Anyone else really like Rick Astley?");
                                ez.add("Hey helper, how play game?");
                                ez.add("Sometimes I sing soppy, love songs in the car.");
                                ez.add("I like long walks on the beach and playing Hypixel");
                                ez.add("Please go easy on me, this is my first game!");
                                ez.add("You're a great person! Do you want to play some Hypixel games with me?");
                                ez.add("In my free time I like to watch cat videos on Youtube");
                                ez.add("When I saw the witch with the potion, I knew there was trouble brewing.");
                                ez.add("If the Minecraft world is infinite, how is the sun spinning around it?");
                                ez.add("Hello everyone! I am an innocent player who loves everything Hypixel.");
                                ez.add("Plz give me doggo memes!");
                                ez.add("I heard you like Minecraft, so I built a computer in Minecraft in your Minecraft so you can Minecraft while you Minecraft");
                                ez.add("Why can't the Ender Dragon read a book? Because he always starts at the End.");
                                ez.add("Maybe we can have a rematch?");
                                ez.add("I sometimes try to say bad things then this happen");
                                ez.add("Behold, the great and powerful, my magnificent and almighty nemisis!");
                                ez.add("Doin a bamboozle fren.");
                                ez.add("Your clicks per second are godly");
                                ez.add("What happens if I add chocolate milk to macaroni and cheese?");
                                ez.add("Can you paint with all the colors of the wind");
                                ez.add("Blue is greener than purple for sure");
                                ez.add("I had something to say, then I forgot it.");
                                ez.add("When nothing is right, go left.");
                                ez.add("I need help, teach me how to play!");
                                ez.add("Your personality shines brighter than the sun.");
                                ez.add("You are very good at the game friend.");
                                ez.add("I like pineapple on my pizza");
                                ez.add("I like pasta, do you prefer nachos?");
                                ez.add("I like Minecraft pvp but you are truly better than me!");
                                ez.add("I have really enjoyed playing with you! <3");
                                ez.add("ILY<3");
                                ez.add("Pineapple doesn't go on pizza!");
                                ez.add("Lets be friends instead of fighting okay?");
                                ez.add("AIDS");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("ILY<3");
                                ez.add("rat");
                                ez.add("uwu");
                                ez.add("uwu");
                                ez.add("i have a short d");
                                ez.add("chat filter?");
                                ez.add("im bad");
                                ez.add("Alex is tall, for sure. No cap.");
                                ez.add("uwu");
                                ez.add("uwu");
                                ez.add("owo");
                                ez.add("Nvidia bread is the future of bread.");
                                ez.add(c.pr + "twitch.tv/gemsvido" + c.rs);
                                ez.add(c.pr + "twitch.tv/gemsvido" + c.rs);
                                ez.add(c.pr + "twitch.tv/V183Z" + c.rs);
                                ez.add("Subscribe to gemsvido");
                                ez.add("Fortnite sucks balz");
                                ez.add("crack");
                                ez.add("ur mom");
                                ez.add(c.pr + "discord.gg/EMQpumB" + c.rs);
                                ez.add("I'm not a simp, piss off.");
                                ez.add(c.rd + "youtu.be/dQw4w9WgXcQ");
                                ez.add("ez?");
                                ez.add("Please give me money -Ivan aka Technoblade");
                                ez.add("Please give me money -Ivan aka Technoblade");


                        } while (false);

                        // Add Message Blacklist
                        do {
                                messageblacklist = new ArrayList<>();
                                messageblacklist.add("nigga");
                                messageblacklist.add("penis");
                                messageblacklist.add("vagina");
                                messageblacklist.add("anus");
                                messageblacklist.add("sex");
                                messageblacklist.add("porn");
                                messageblacklist.add("testicles");

                        } while (false);

                        loaded = true;

                } else {
                        TextMessage alert_1 = new TextMessage(system, "Database already loaded. To reload, use reload() [801]", Main.loggedin);
                        Main.message(alert_1, Main.n_log);
                }

        }

        public static void unload () {

                if (loaded) {

                        gemsvido = null;
                        system = null;
                        test = null;
                        chat = null;
                        empty = null;
                        impersonated = null;

                        accounts = null;

                        ez = null;

                        messageblacklist = null;

                        loaded = false;

                } else {
                        TextMessage alert_2 = new TextMessage(system, "Database is not loaded. To reload, use load() [802]", Main.loggedin);
                        Main.message(alert_2, Main.n_log);
                }
        }

        public static void reload () {
                if (loaded) {

                        unload();
                        load();
                } else {
                        TextMessage alert_3 = new TextMessage(system, "Database is not loaded. To reload, use load() [803]", Main.loggedin);
                        Main.message(alert_3, Main.n_log);
                }
        }

        public static String returnez () {
                if (loaded) {
                        int random = new Random().nextInt(database.ez.size());
                        return ez.get(random);
                } else {
                        System.out.println(c.yw + "Database is not loaded [804]");
                        return null;
                }


        }

        public static String accessSystemToken (String reason) {
                Main.c_log.logcmd("System token was accessed. Reason: " + reason, system);
                return SYSTEM_TOKEN.getPassword();
        }


}