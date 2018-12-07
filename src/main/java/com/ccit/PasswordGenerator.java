package com.ccit;


public class PasswordGenerator {
    public static void main(String[] args) {
        genpwd("jxfotafl");
        genpwd("jxmingx");
        genpwd("jxliey");
        genpwd("jxshuns");
        genpwd("jxlinga");
        genpwd("jxhuam");
        genpwd("jxxings");
        genpwd("jxrongj");
        genpwd("jxshund");
        genpwd("jxlianx");
        genpwd("jxfeiy");

        genpwd("jxsouk");
        genpwd("jxlianxingwk");
        genpwd("jxhaikuotk");
        genpwd("jxpengy");
        genpwd("jxxingfsg");
        genpwd("jxnantm");

        genpwd("jsceshi@7xnetworks.com");
        genpwd("jswangba001@7x-networks.com");
        genpwd("jswangba002@7x-networks.com");
        genpwd("test.7x-networks");

        genpwd("admin", "7x-networks");
        genpwd("7x-networks");
        genpwd("MobileClient", "MobileClient20170624");
        genpwd("matrix", "bZokU21YgMgmEZoRQ7WyClIFEfQFbNWh");
        genpwd("matrix", "GtczzH8xoieOaj3TDJK5cjYazxOyi2Y3");
        genpwd("zion", "f5e2KD902jEUPCWSvz3gVbfNXCPTwSkg");
        genpwd("sextant", "wnCMiEgIfUl6s6fnoePhh4CtdzkgLTTt");
        genpwd("vincent", "9CgJL6Kc");
        genpwd("lance", "fenrir980665");
        genpwd("matrix", "4A9sOpYL");
        genpwd("acceleration", "f7yXYBeD");

        genpwd("7x-SPL", "lphq");
        genpwd("7x-LY", "k62A");
        genpwd("7x-WR", "OyzQ");
        genpwd("7x-test1");
        genpwd("7x-test2");
        genpwd("apollo", "apollo");
        genpwd("test", "test");
        genpwd("lirui123", "12345678");
        genpwd("x7-test");
        genpwd("shanghaikesen");

        genpwd("7x-networks", "djky");
        genpwd("7x-XG", "lond");
        genpwd("7x-XG-test", "keic");

        genpwd("paopaoadmin", "jdkiqngh");
        genpwd("7x-WB", "qAzXsw");
        genpwd("7x-ZY", "eDcRfv");
        genpwd("7x-JJZ", "tGbYhn");
        genpwd("7x-YH", "uJmIko");
        genpwd("matrix", "974c84f62a1d367c1ff5af75ca8181e7");
        genpwd("watone", "watoneAdmin");
        genpwd("nanjidianshang", "uJmIko");
        genpwd("admin", "admin");
        genpwd("rainbow", "KJYpKiiKwUStSOwAwvvVLxxrouaTT2Vz");
        genpwd("mine", "qAZxsW");
        genpwd("matrix", "eDcVfR");
        genpwd("guest", "guest");
        genpwd("onos", "i9mqcsf2isx7k3uxd9308tsn7i66fzq0");
        genpwd("nexus", "pUPwhm2oh51TDozMeiKDfUffZSlvJOAE");
        genpwd("admin", "fashionAdmin");
        genpwd("azeroth", "ielcpbvqili6gly42binsdvuew27kinh");
        genpwd("stormwind", "bn3tnf6ak3cqshdjiaee3y1py3162lsd");
        genpwd("castle", "lcamytbleb2sbfju49flrqo9mdtpoe5t");
        genpwd("admin", "Anchnet.com");
        genpwd("admin", "Lianyun.com");
        //融合OSS密码
        genpwd("azeroth", "nordrassil");
        genpwd("nexus-watsons", "0uj8b5wkoqg8memzo1ujo1eyxk80yfey");
        genpwd("teekee", "teekee@teekee!");
        genpwd("stormwind", "lcamytbleb2sbfju49flrqo9mdtpoe5t");
        genpwd("azeroth", "lcamytbleb2sbfju49flrqo9mdtpoe5t");
        genpwd("nexus-watsons", "lcamytbleb2sbfju49flrqo9mdtpoe5t");
        genpwd("7x0012017102001cd0a4d", "d2a7684c499bbe3842db258f16b5d8f5");
        genpwd("admin", "telecom@telecom!");
        genpwd("telecom", "telecom@telecom!");
    }

    public static void genpwd(String username, String password) {
        System.out.println(username + ":" + MD5Utils.encrypt(MD5Utils.encrypt(password)) + ":" +
                MD5Utils.encrypt(
                        MD5Utils.encrypt(MD5Utils.encrypt(password)) + "{" + username + "}")
        );
    }

    public static void genpwd(String username) {
        genpwd(username, username);
    }
}
